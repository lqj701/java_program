package algorithm.sort;

import com.alibaba.fastjson.JSONObject;

public class SortDemo {
    private final static int[] array = {6, 17, 14, 19, 8, 11, 4, 10, 3, 3, 2, 7, 15};

    public static void main(String[] args) {
        SortService sortService = new SortServiceImpl();
        // sortService.bubbleSort(array);
        // sortService.quickSort(array, 0, array.length - 1);
        // sortService.insertionSort(array);
        sortService.binaryInsertionSort(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
