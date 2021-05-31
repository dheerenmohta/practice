
System design 	"Design a system that scales to millions of users on AWS

1) FEATURE EXPECTATIONS [5 min]

        (1) Use cases
            user can do crud operations
            Service will process and return result
            Service needs to evolve from serving a small amount of users to millions of users
            Service has high availability

                1) Benchmark/Load Test, 2) Profile for bottlenecks 3) address bottlenecks while evaluating alternatives and trade-offs, and 4) repeat,

        (2) Scenarios that will not be covered
        (3) Who will use
        (4) How many will use
        (5) Usage patterns

(2) ESTIMATIONS [5 min]
        Traffic is not evenly distributed
        Need for relational data
        Scale from 1 user to tens of millions of users
        Users+
        Users++
        Users+++

        (1) Throughput (QPS for read and write queries)
            2.5 million seconds are there in a month
            10 million users



        (2) Latency expected from the system (for read and write queries) - 150 ms from 1 az to another az
        (3) Read/Write ratio
            1 billion writes per month
            100 billion reads per month
            100:1 read to write ratio
            1 KB content per write

        (4) Traffic estimates
                - Write (QPS, Volume of data)

                400 writes per second on average

                - Read  (QPS, Volume of data)
                40,000 reads per second on average

        (5) Storage estimates
                1 TB of new content per month
                1 KB per write * 1 billion writes per month
                36 TB of new content in 3 years
                Assume most writes are from new content instead of updates to existing ones



        (6) Memory estimates
                - If we are using a cache, what is the kind of data we want to store in cache
                - How much RAM and how many machines do we need for us to achieve this ?
                - Amount of data you want to store in disk/ssd
                Reading 1 MB sequentially from memory takes about 250 microseconds, while reading from SSD takes 4x and from disk takes 80x longer.1"	"(3) DESIGN GOALS [5 min]

        (1) Latency and Throughput requirements
        (2) Consistency vs Availability  [Weak/strong/eventual => consistency | Failover/replication => availability]
(4) HIGH LEVEL DESIGN [5-10 min]

        (1) APIs for Read/Write scenarios for crucial components

        (2) Database schema
        (3) Basic algorithm
        (4) High level design for Read/Write scenario
(5) DEEP DIVE [15-20 min]

        (1) Scaling the algorithm
             With only 1-2 users, you only need a basic setup
                Web server on EC2
                Storage for user data
                MySQL Database

                Keep an eye on metrics to determine how to scale up

        Use basic monitoring to determine bottlenecks: CPU, memory, IO, network, etc
        CloudWatch, top, nagios, statsd, graphite, etc

        The constraints assume there is a need for relational data. We can start off using a MySQL Database on the single box.

        Assign a public static IP

        Elastic IPs provide a public endpoint whose IP doesn't change on reboot


        (2) Scaling individual components:
                -> Availability, Consistency and Scale story for each component
                -> Consistency and availability patterns
        (3) Think about the following components, how they would fit in and how it would help
                a) DNS
                Add a DNS such as Route 53 to map the domain to the instance's public IP.
                A Domain Name System (DNS) translates a domain name such as www.example.com to an IP address.
                Your router or ISP provides information about which DNS server(s) to contact when doing a lookup
                DNS results can also be cached by your browser or OS for a certain period of time, determined by the time to live (TTL).
                NS record (name server) - Specifies the DNS servers for your domain/subdomain
                MX record (mail exchange) - Specifies the mail servers for accepting messages.
                A record (address) - Points a name to an IP address.
                CNAME (canonical) - Points a name to another name or CNAME (example.com to www.example.com) or to an A record.

                Services such as CloudFlare and Route 53 provide managed DNS services. Some DNS services can route traffic through various methods:

                Weighted round robin
                    Prevent traffic from going to servers under maintenance
                    Balance between varying cluster sizes
                    A/B testing
                Latency-based
                Geolocation-based

                Disadvantage :
                Accessing a DNS server introduces a slight delay, although mitigated by caching described above.
                DNS services have recently come under DDoS attack, preventing users from accessing websites such as Twitter without knowing Twitter's IP address(es).

                b) CDN [Push vs Pull]
                A content delivery network (CDN) is a globally distributed network of proxy servers, serving content from locations closer to the user.
                Generally, static files such as HTML/CSS/JS, photos, and videos are served from CDN, although some CDNs such as Amazon's CloudFront support dynamic content.
                Users receive content from data centers close to them
                Your servers do not have to serve requests that the CDN fulfills


                Push CDNs receive new content whenever changes occur on your server.
                You take full responsibility for providing content, uploading directly to the CDN and rewriting URLs to point to the CDN. You can configure when content expires and when it is updated. Content is uploaded only when it is new or changed, minimizing traffic, but maximizing storage.

                Pull CDNs grab new content from your server when the first user requests the content. You leave the content on your server and rewrite URLs to point to the CDN. This results in a slower request until the content is cached on the CDN.

                Move static (and some dynamic) content to a Content Delivery Network (CDN) such as CloudFront to reduce load and latency"	"c) Load Balancers [Active-Passive, Active-Active, Layer 4, Layer 7]
                d) Reverse Proxy
                    Secure the web server

                        Open up only necessary ports
                        Allow the web server to respond to incoming requests from:
                        80 for HTTP
                        443 for HTTPS
                        22 for SSH to only whitelisted IPs


                Prevent the web server from initiating outbound connections
                        Encrypt in transit and at rest
                        Sanitize all user inputs or any input parameters exposed to user to prevent XSS and SQL injection.
                        Use parameterized queries to prevent SQL injection.
                        Use the principle of least privilege


                e) Application layer scaling [Microservices, Service Discovery]

                User++
                ______

                Client
                                DNS
                Web Server

                to
                ______

                Client
                                DNS
                Web Server

                SQL        Object store

                Our Benchmarks/Load Tests and Profiling are pointing to the MySQL Database taking up more and more memory and CPU resources, while the user content is filling up disk space.
                Lighten load on the single box and allow for independent scaling
                Store static content separately in an Object Store
                Move the MySQL Database to a separate box

                Store static content separately
                Consider using a managed Object Store like S3 to store static content
                Highly scalable and reliable
                Server side encryption'

                Move static content to S3
                User files
                JS
                CSS
                Images
                Videos


                f) DB [RDBMS, NoSQL]

                    Move the MySQL database to a separate box

                    Consider using a service like RDS to manage the MySQL Database
                        Simple to administer, scale
                        Multiple availability zones
                        Encryption at rest"	"User++
                ______


                client      DNS
                            CDN
                LBR
                Webserver

                Read APIs   Write APIs

                (SQL write Master slave)  Object Store


                Web Server bottlenecks during peak hours, resulting in slow responses and in some cases, downtime. As the service matures, we'd also like to move towards higher availability and redundancy.

                Use Horizontal Scaling to handle increasing loads and to address single points of failure

                Add a Load Balancer such as Amazon's ELB or HAProxy
                ELB is highly available
                If you are configuring your own Load Balancer, setting up multiple servers in active-active or active-passive in multiple availability zones will improve availability
                Terminate SSL on the Load Balancer to reduce computational load on backend servers and to simplify certificate administration
                Use multiple Web Servers spread out over multiple availability zones



                Users+++
                ________

                client      DNS

                LoadBalancers

                Webservers

                ReadAPI       WriteAPI


                                 MemoryCache

                SQL Write                      SQL Read             ObjectStore
                Master-Slave                   Replica

                Internal Load Balancers not shown to reduce clutter

                _______________


                Our Benchmarks/Load Tests and Profiling show that we are read-heavy (100:1 with writes) and our database is suffering from poor performance from the high read requests.

                First, try to configure the MySQL Database cache to see if that is sufficient to relieve the bottleneck before implementing a Memory Cache

                Session data from the Web Servers, The Web Servers become stateless, allowing for Autoscaling


                        > RDBMS
                            >> Master-slave, Master-master, Federation, Sharding, Denormalization, SQL Tuning
                            Use multiple MySQL instances in Master-Slave Failover mode across multiple availability zones to improve redundancy

                            Add MySQL Read Replicas to reduce load on the write master
                            Add more Web Servers and Application Servers to improve responsiveness

                            Add MySQL read replicas

                            In addition to adding and scaling a Memory Cache, MySQL Read Replicas can also help relieve load on the MySQL Write Master
                            Add logic to Web Server to separate out writes and reads
                            Add Load Balancers in front of MySQL Read Replicas (not pictured to reduce clutter)
                            Most services are read-heavy vs write-heavy

                            A relational database like SQL is a collection of data items organized in tables.

                            ACID is a set of properties of relational database transactions.

                            Atomicity - Each transaction is all or nothing
                            Consistency - Any transaction will bring the database from one valid state to another
                            Isolation - Executing transactions concurrently has the same results as if the transactions were executed serially
                            Durability - Once a transaction has been committed, it will remain so

                            Master-slave replication

                            The master serves reads and writes, replicating writes to one or more slaves, which serve only reads.
                            Slaves can also replicate to additional slaves in a tree-like fashion.
                            If the master goes offline, the system can continue to operate in read-only mode until a slave is promoted to a master or a new master is provisioned.

                                client          read/Write TO Master

                                                replication to slaves from Master

                                                read only(slave1 slave2)

                            Master-master replication

                            Both masters serve reads and writes and coordinate with each other on writes.
                            If either master goes down, the system can continue to operate with both reads and writes.

                            Federation
                                Federation (or functional partitioning) splits up databases by function.
                                For example, instead of a single, monolithic database, you could have three databases: forums, users, and products,
                                Smaller databases result in more data that can fit in memory, which in turn results in more cache hits due to improved cache locality
                                With no single central master serializing writes you can write in parallel, increasing throughput.

                                You'll need to update your application logic to determine which database to read and write.

                            Sharding

                                Sharding distributes data across different databases such that each database can only manage a subset of the data.

                                Disadvantage(s): sharding
                                Rebalancing adds additional complexity. A sharding function based on consistent hashing can reduce the amount of transferred data.

                                    Consistent Hashing-  Here you have a number of nodes in a cluster of databases,
                                    or in a cluster of web caches. How do you figure out where the data for a particular key goes in that cluster?

                                    You apply a hash function to the key.

                                    The same key will always return the same hash code (hopefully),
                                    so once you've figured out how you spread out a range of keys across the nodes available,
                                    you can always find the right node by looking at the hash code for a key

                            Indices are usually represented as self-balancing B-tree that keeps data sorted and allows searches,
                            sequential access, insertions, and deletions in logarithmic time.

                            Placing an index can keep the data in memory, requiring more space.
                            Writes could also be slower since the index also needs to be updated.
                            When loading large amounts of data, it might be faster to disable indices, load the data, then rebuild the indices.
"	"> NoSQL
                            >> Key-Value, Wide-Column, Graph, Document

                            NoSQL is a collection of data items represented in a key-value store,
                            document store, wide column store, or a graph database.
                            Data is denormalized, and joins are generally done in the application code.
                            Most NoSQL stores lack true ACID transactions and favor eventual consistency.

                         Key-value store

                        Abstraction: hash table
                        A key-value store generally allows for O(1) reads and writes and is often backed by memory or SSD.
                        Data stores can maintain keys in lexicographic order,
                        allowing efficient retrieval of key ranges.
                        Key-value stores can allow for storing of metadata with a value.

                        Key-value stores provide high performance and are often used for simple data models or for rapidly-changing data,
                        such as an in-memory cache layer. Since they offer only a limited set of operations,
                        complexity is shifted to the application layer if additional operations are needed.

                        BASE is often used to describe the properties of NoSQL databases.
                        In comparison with the CAP Theorem, BASE chooses availability over consistency.

                        Basically available - the system guarantees availability.
                        Soft state - the state of the system may change over time, even without input.
                        Eventual consistency - the system will become consistent over a period of time, given that the system doesn't receive input during that period.
                        In addition to choosing between SQL or NoSQL,
                        it is helpful to understand which type of NoSQL database best fits your use case(s).
                        We'll review key-value stores, document stores, wide column stores, and graph databases in the next section.





                                Fast-lookups:
                                -------------
                                    >>> RAM  [Bounded size] => Redis, Memcached
                                    >>> AP [Unbounded size] => Cassandra, RIAK, Voldemort
                                    >>> CP [Unbounded size] => HBase, MongoDB, Couchbase, DynamoDB
                g) Caches
                        > Client caching, CDN caching, Webserver caching, Database caching, Application caching, Cache @Query level, Cache @Object level
                        > Eviction policies:
                                >> Cache aside
                                >> Write through
                                >> Write behind
                                >> Refresh ahead
                h) Asynchronism
                        > Message queues
                        > Task queues
                        > Back pressure

                        Separating out the web layer from the application layer (also known as platform layer) allows you to scale and configure both layers independently.
                        Adding a new API results in adding application servers without necessarily adding additional web servers.
                        The single responsibility principle advocates for small and autonomous services that work together.
                        Small teams with small services can plan more aggressively for rapid growth.

                        Request     LoadBalancer    Webserver      ApplicationServer

                                                    Webserver      ApplicationServer

                                                    Webserver      ApplicationServer

                        Separate out the Web Servers from the Application Servers
                        Scale and configure both layers independently
                        Web Servers can run as a Reverse Proxy
                        For example, you can add Application Servers handling Read APIs while others handle Write APIs"	" Workers in the application layer also help enable asynchronism.

        Asynchronism -
                                            MessageQueue       Queue Consumer
                Request    Webserver
                                              Database

        Asynchronous workflows help reduce request times for expensive operations that would otherwise be performed in-line.
        They can also help by doing time-consuming work in advance, such as periodic aggregation of data

            Message queues

            Message queues receive, hold, and deliver messages.
            If an operation is too slow to perform inline, you can use a message queue with the following workflow:

            An application publishes a job to the queue, then notifies the user of job status
            A worker picks up the job from the queue, processes it, then signals the job is complete

            Redis is useful as a simple message broker but messages can be lost.

            RabbitMQ is popular but requires you to adapt to the 'AMQP' protocol and manage your own nodes.

            Amazon SQS is hosted but can have high latency and has the possibility of messages being delivered twice.


            Task queues

            Tasks queues receive tasks and their related data,
            runs them, then delivers their results.
            They can support scheduling and can be used to run computationally-intensive jobs in the background.



            Back pressure
            If queues start to grow significantly,
            the queue size can become larger than memory,
            resulting in cache misses, disk reads, and even slower performance.
            Back pressure can help by limiting the queue size,
            thereby maintaining a high throughput rate and good response times for jobs already in the queue.
            Once the queue fills up, clients get a server busy or HTTP 503 status code to try again later.
            Clients can retry the request at a later time, perhaps with exponential backoff.

                i) Communication
                        > TCP
                           handshake, secure, no packet loss
                        > UDP
                            dataloss is there, streaming
                        > REST
                            URI, Verbs, Methods (GET PUT POST DELETE PATCH), HATEOS( HTML interface for http,service should be fully accessible in a browser )
                        > RPC
                            client client stub dispatcher  server dispatcher serverstub



Security
    Secure the system

    Encrypt data in transit and at rest
    Use a Virtual Private Cloud
        Create a public subnet for the single Web Server so it can send and receive traffic from the internet
        Create a private subnet for everything else, preventing outside access
        Only open ports from whitelisted IPs for each component"	"(6) JUSTIFY [5 min]

        (1) Throughput of each layer
        (2) Latency caused between each layer
        (3) Overall latency justification




Add Autoscaling to provision capacity as needed
Keep up with traffic spikes
Reduce costs by powering down unused instances
Automate DevOps
Chef, Puppet, Ansible, etc
Continue monitoring metrics to address bottlenecks
Host level - Review a single EC2 instance
Aggregate level - Review load balancer stats
Log analysis - CloudWatch, CloudTrail, Loggly, Splunk, Sumo
External site performance - Pingdom or New Relic
Handle notifications and incidents - PagerDuty
Error Reporting - Sentry



Add autoscaling

Consider a managed service such as AWS Autoscaling
Create one group for each Web Server and one for each Application Server type, place each group in multiple availability zones
Set a min and max number of instances
Trigger to scale up and down through CloudWatch
Simple time of day metric for predictable loads or
Metrics over a time period:
CPU load
Latency
Network traffic
Custom metric
Disadvantages
Autoscaling can introduce complexity
It could take some time before a system appropriately scales up to meet increased demand, or to scale down when demand drops


User++++
______

                 client      DNS

                LoadBalancers

                Webservers

                ReadAPI       WriteAPI              WriteApiAsync       Queue       WorkerServices

                                                                                          |
                                 MemoryCache                                              |
                                                                                          |
                SQL Write                      SQL Read             ObjectStore         NoSQL
                Master-Slave                   Replica



                Sharding

                Federation



We'll continue to address scaling issues due to the problem's constraints:

If our MySQL Database starts to grow too large,
we might consider only storing a limited time period of data in the database,
while storing the rest in a data warehouse such as Redshift
A data warehouse such as Redshift can comfortably handle the constraint of 1 TB of new content per month
With 40,000 average read requests per second, read traffic for popular content can be addressed by scaling the Memory Cache, which is also useful for handling the unevenly distributed traffic and traffic spikes
The SQL Read Replicas might have trouble handling the cache misses, we'll probably need to employ additional SQL scaling patterns
400 average writes per second (with presumably significantly higher peaks) might be tough for a single SQL Write Master-Slave, also pointing to a need for additional scaling techniques
"
