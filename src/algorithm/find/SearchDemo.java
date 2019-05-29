package algorithm.find;

import com.alibaba.fastjson.JSONObject;

import algorithm.sort.SortService;
import algorithm.sort.SortServiceImpl;

public class SearchDemo {
    private final static int[] array = {6, 17, 14, 19, 8, 11, 4, 10, 3, 3, 2, 7};

    public static void main(String[] args) {
        SearchService searchService = new SearchServiceImpl();
        SortService sortService = new SortServiceImpl();
        sortService.quickSort(array, 0, array.length - 1);
        System.out.println(JSONObject.toJSONString(array));
        System.out.println(searchService.binarySearch(array, 10));
    }
}
