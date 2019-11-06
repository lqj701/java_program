package algorithm.sort;

import java.util.Arrays;

import algorithm.find.SearchService;
import algorithm.find.SearchServiceImpl;

public class SortServiceImpl implements SortService {

    @Override
    public void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private int[] swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        return array;
    }

    @Override
    public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int index = partition(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    /**
     *  two point i,j . 0->i put smaller than pivot element,i->j put larger than pivot element
     *  because element in i+1 should not smaller than pivot element,when element in j smaller than pivot element,swap
     */
    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }


    /**
     * Find the insert position,than the elements between this position and current element should move one bit backward
     * @param array
     */
    @Override
    public void insertionSort(int[] array) {
        for (int cur = 1; cur < array.length; cur++) {
            int key = array[cur];
            int index;
            for (index = cur - 1; index >= 0 && array[index] > key; index--) {
                array[index + 1] = array[index];
            }
            // index represent the insert position,the key insert after this position
            array[index + 1] = key;
        }
    }

    /**
     * Find the insert position,than the elements between this position and current element should move one bit backward
     * @param array
     */
    @Override
    public void binaryInsertionSort(int[] array) {
        SearchService searchService = new SearchServiceImpl();
        for (int cur = 1; cur < array.length; cur++) {
            int key = array[cur];
            int index = searchService.binarySearchForInsertSort(Arrays.copyOfRange(array, 0, cur), key);
            for (int i = cur - 1; i >= index && i >= 0; i--) {
                array[i + 1] = array[i];
            }
            array[index + 1] = key;
        }
    }

    @Override
    public void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // divide into (gap) groups,than sort each group by insertion sort method
            for (int i = 0; i < gap; i++) {
                for (int cur = i + gap; cur < array.length; cur += gap) {
                    int key = array[cur];
                    int index;
                    for (index = cur - gap; index >= 0 && array[index] > key; index -= gap) {
                        array[index + gap] = array[index];
                    }
                    array[index + gap] = key;
                }
            }
        }
    }

    @Override
    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < key) {
                    key = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = key;
        }
    }

    @Override
    public void heapSort(int[] array) {

    }

    // private int[] buildMaxHeap(int[] array) {
    // return 1;
    // }

    @Override
    public void mergeSort(int[] array) {

    }

    @Override
    public void countingSort(int[] array) {

    }

    @Override
    public void bucketSort(int[] array) {

    }

    @Override
    public void radixSort(int[] array) {

    }
}
