import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FlattenListCreateListIterator {
     public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer,
              // rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds,
              // if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds,
              // if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }



    public class NestedIterator implements Iterator<Integer> {
        List<Integer> list = new ArrayList<>();
        int index = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            // Initialize your data structure here.

            flatenHelper(nestedList, list);
        }

        public void flatenHelper(List<NestedInteger> nestedList,
                                 List<Integer> list) {

            for (NestedInteger obj : nestedList) {
                if (obj.isInteger()) {
                    list.add(obj.getInteger());
                } else {
                    flatenHelper(obj.getList(), list);
                }
            }
        }

        // @return {int} the next element in the iteration
        @Override
        public Integer next() {
            // Write your code here
            return list.get(index++);
        }

        // @return {boolean} true if the iteration has more element or false
        @Override
        public boolean hasNext() {
            // Write your code here
            if (index < list.size()) return true;
            else return false;
        }

        @Override
        public void remove() {
        }
    }
}
