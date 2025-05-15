import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {20,2,7,12,15,1,6,8};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) { // 1 single element
            return;
        }

        //partition the array based on pivot
        int pivotsStortedIndex = partition(arr, low, high);
        System.out.println(Arrays.toString(arr));

        //recursive sort
        quickSort(arr, low, pivotsStortedIndex - 1);
        quickSort(arr, pivotsStortedIndex + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        // choose pivot
        System.out.println("low: " + low + ", high: " + high);
        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j <= high-1; j++) {
            if(arr[j] < pivot) {
                i+=1;
                //swap i and j
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // less, high, pivot
        // swap i+1 with pivot
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        // pivot's sorted index
        return i+1;
    }

}
