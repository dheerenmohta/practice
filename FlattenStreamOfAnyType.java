

  
    // Function to flatten a Stream of Arrays
                                            // {{ 1, 2 }, { 3}}
                                            // {{a,b}, {c}}
    public static <T> Stream <T> flattenStream(T[][] arrays)
    {
  
        // Create an empty list to collect the stream
        List<T> list = new ArrayList<>(); 
  
        // Using forEach loop
        // convert the array into stream
        // and add the stream into list
        for (T[] array : arrays) {
            Arrays.stream(array)
                .forEach(list::add);
        }
  
        // Convert the list into Stream and return it
        return list.stream();
    }
  
    public static void main(String[] args)
    {
  
        // Get the arrays to be flattened.
        Integer[][] arr = {
            { 1, 2 },
            { 3}
        };
  
        // Flatten the Stream
        Integer[] flatArray = flattenStream(arr)
                                  .toArray(Integer[] ::new);
  
        // Print the flattened array
        System.out.println(Arrays.toString(flatArray));
    }
}