import java.util.*;

public class RandomizedSet {
    private Map<Integer,Integer> indexMap;
    private List<Integer> dataList;
    private java.util.Random randomElement;

    public RandomizedSet() {
        indexMap = new HashMap<>();
        dataList = new ArrayList<>();
        randomElement = new Random();
    }

    public boolean insert(int value){
        if(indexMap.containsKey(value)){
            return false;
        }
        dataList.add(value);
        indexMap.put(value,dataList.size()-1);
        return true;
    }

    public boolean remove(int value) {
        if(!indexMap.containsKey(value)){
            return false;
        }
        int removalIndex = indexMap.get(value);
        int lastElement = dataList.get(dataList.size()-1);
        //replace removal element index with last element
        dataList.set(removalIndex,lastElement);
        indexMap.put(lastElement,removalIndex);

        //remove last element
        dataList.remove(dataList.size()-1);
        indexMap.remove(value);
        return  true;
    }

    public int getRandom(){
        return dataList.get(randomElement.nextInt(dataList.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1)); // true
        System.out.println(rs.remove(2)); // false
        System.out.println(rs.insert(2)); // true
        System.out.println(rs.getRandom()); // 1 or 2
        System.out.println(rs.remove(1)); // true
        System.out.println(rs.insert(2)); // false
        System.out.println(rs.getRandom()); // 2
    }


}
