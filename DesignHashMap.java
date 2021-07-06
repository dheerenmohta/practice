class MyHashMap {
    
    /*
    MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    */

	private class HTPair {
		int key;
		int value;

		HTPair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	private LinkedList<HTPair>[] bucketarray;

    /** Initialize your data structure here. */
    public MyHashMap() {
        initBucket(DEFAULT_CAPACITY);
		size = 0;
    }

	private void initBucket(int N) {
		bucketarray = new LinkedList[N]; // [20 values]
		for (int bi = 0; bi < bucketarray.length; bi++) {
			bucketarray[bi] = new LinkedList<HTPair>();// {[],[],.. 20 values after rehash}
		}
	}
    
    /** value will always be non-negative. */
                    // 1.     // 1
                    //.1.     // 1
    public void put(int key, int value) {
		    
        int bucketIndex = hashFunction(key); //   1 // 1
                                         // 1     1
                                        //  1.    1
		int dataIndex = getDataWithinBucket(key, bucketIndex); // -1 // 0

		if (dataIndex == -1) {
			// no index found           
                                        //1. 1
			HTPair newPair = new HTPair(key, value);
            //{[1,1]}
			bucketarray[bucketIndex].add(newPair);
			size++;// 1 
		} else {                                        
			LinkedList<HTPair> bucketLocation = bucketarray[bucketIndex];// [1,1]
			bucketLocation.get(dataIndex).value = value;  // [1,1].get(0).value = 1 // {[1,1]}
		}

		// rehasing threshold
                        // 10*1 /10 = 1 
                        // 20*1 /10 = 2
                        // 30*1/ 10 = 3
		double lambda = size * 1.0 / bucketarray.length;
            // 1 > 2
            // 2 > 2 
            // 3 > 2 t
		if (lambda > 2.0) {
			rehash();
		}        
    }
  
	private void rehash() {
		LinkedList<HTPair>[] oldbucket = bucketarray;//{[1,1]}
		initBucket(oldbucket.length * 2); // 20
		size = 0;
		for (int bi = 0; bi < oldbucket.length; bi++) {
			for (HTPair pairs : oldbucket[bi]) {
				put(pairs.key, pairs.value);
			}
		}
	}
                                //    1
	private int hashFunction(Integer key) {
        
		int hashCode = key.hashCode();
		return Math.abs(hashCode) % bucketarray.length; // 1.hashCode()%10 ~ 1
	}
                                    //  1     1
                                    //  1.    1
	private int getDataWithinBucket(int keys, int bi) {
		int id = 0;
		for (HTPair pairs : bucketarray[bi]) {
                // 1.keys == 1 f
                // 1 == 1 t
			if (pairs.key == keys) // == here because we used int as key,value
				return id; // 0
			id++; // 1
		}
		return -1;
	}

    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
                    // 1
    public int get(int key) {
		
        int bucketIndex = hashFunction(key); // 1
                                            // 1   1 
		int dataIndex = getDataWithinBucket(key, bucketIndex);// 0

		if (dataIndex == -1) {
			return dataIndex; // no data found
		} else {
			LinkedList<HTPair> bucketLocation = bucketarray[bucketIndex]; // b[0] = [1, 1]
			return bucketLocation.get(dataIndex).value; // [1, 1].getValue() // 1
		}        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
                        // 1
    public void remove(int key) {
		
        int bucketIndex = hashFunction(key); // 1
		int dataIndex = getDataWithinBucket(key, bucketIndex); // 0

		if (dataIndex == -1) {
			return;
		} else {
			LinkedList<HTPair> bucketLocation = bucketarray[bucketIndex];// bucketarray[1] // [1,1]
			bucketLocation.remove(dataIndex);// {[1,1]} >> remove(0) >> {}
			size--;// 1-- // 0
		}        
    }
}