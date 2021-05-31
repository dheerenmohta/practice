Design the Twitter timeline and search	"Use cases verbs
posting tweet
deleting tweet
updating tweet
creating user
Viewing timeline of User
Viewing timeline of other users
Searching within user content
Serching within "	"Handy conversion guide:

2.5 million seconds in a month
1 request per second = 2.5 million requests per month
40 requests per second = 100 million requests per month
400 requests per second = 1000million = 1 billion requests per month"	"client
web server (reverse proxy to auth and authorized)
readHandler. searchhandler writeHandler"	"readHadler.      sql
                               cache.    uses media to store in objectStore
tweetTimelineSerice
tweetInfoService"	"searchHandler
searchIndexService
"	"notificationService
Uses queue

[.     ] send notification asynchronusly"	"Latency Comparison Numbers
--------------------------
L1 cache reference                           0.5 ns
Branch mispredict                            5   ns
L2 cache reference                           7   ns                      14x L1 cache
Mutex lock/unlock                           25   ns
Main memory reference                      100   ns                      20x L2 cache, 200x L1 cache
Compress 1K bytes with Zippy            10,000   ns       10 us
Send 1 KB bytes over 1 Gbps network     10,000   ns       10 us
Read 4 KB randomly from SSD*           150,000   ns      150 us          ~1GB/sec SSD
Read 1 MB sequentially from memory     250,000   ns      250 us
Round trip within same datacenter      500,000   ns      500 us
Read 1 MB sequentially from SSD*     1,000,000   ns    1,000 us    1 ms  ~1GB/sec SSD, 4X memory
HDD seek                            10,000,000   ns   10,000 us   10 ms  20x datacenter roundtrip
Read 1 MB sequentially from 1 Gbps  10,000,000   ns   10,000 us   10 ms  40x memory, 10X SSD
Read 1 MB sequentially from HDD     30,000,000   ns   30,000 us   30 ms 120x memory, 30X SSD
Send packet CA->Netherlands->CA    150,000,000   ns  150,000 us  150 ms"
