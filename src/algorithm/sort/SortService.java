package algorithm.sort;

public interface SortService {
    // bubble sort
    void bubbleSort(int[] array);

    // quick sort
    void quickSort(int[] array, int left, int right);

    // insert sort
    void insertionSort(int[] array);

    void binaryInsertionSort(int[] array);

    // Shell sort
    void shellSort(int[] array);

    // select sort
    void selectionSort(int[] array);

    // heap sort
    void heapSort(int[] array);

    // merge sort
    void mergeSort(int[] array);


    // counting sort
    void countingSort(int[] array);

    // bucket sort
    void bucketSort(int[] array);

    // radix sort
    void radixSort(int[] array);
}
