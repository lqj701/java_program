package algorithm.find;

public class SearchServiceImpl implements SearchService {

    @Override
    public int binarySearch(int[] array, int value) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int middle = begin + (end - begin) / 2;
            if (value > array[middle]) {
                begin = middle + 1;
            } else if (value < array[middle]) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    @Override
    public int binarySearchForInsertSort(int[] array, int value) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int middle = begin + (end - begin) / 2;
            if (value > array[middle]) {
                begin = middle + 1;
            } else if (value < array[middle]) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return begin - 1;
    }
}
