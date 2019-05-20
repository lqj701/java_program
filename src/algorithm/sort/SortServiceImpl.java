package algorithm.sort;

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
     *  because element in i+1 must not smaller than pivot element,when element in j smaller than pivot element,swap
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


    @Override
    public void insertionSort(int[] array) {

    }

    @Override
    public void shellSort(int[] array) {

    }

    @Override
    public void selectionSort(int[] array) {

    }

    @Override
    public void heapSort(int[] array) {

    }

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
