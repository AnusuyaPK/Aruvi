public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38,27,43,3,9,82,10,15,60,22}; // arrays are pass by reference in java
        mergeSort(array, 0, array.length-1);
        for(int i = 0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] array, int left, int right) {
        if(left == right) { //base condition
            return;
        }
        //1.divide
        int middle = (left + right) / 2;
        // array 1: left - middle; array2: middle + 1 - right

        //2.sort
        mergeSort(array, left, middle); // sort 1st array
        mergeSort(array, middle + 1, right); // sord secord array

        //3.merge sorted arrays
        mergeSortedArrays(array, left, middle, right);

        System.out.println("Array1");
        for(int i = left; i<=middle; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("Array2");
        for(int j = middle+1; j<=right; j++){
            System.out.print(array[j]+" ");
        }
        System.out.println();

    }

    public static void mergeSortedArrays(int[] array, int left, int middle, int right) {
        // [left - middle] [ middle+1 - right]
        int i = left;
        int j = middle+1;
        int sizeOfSortedArray = right - left + 1;
        int[] sortedArray = new int[sizeOfSortedArray];
        int sortedIndex = 0;

        while(i <= middle && j <= right) {
            if(array[i] < array[j]) {
                sortedArray[sortedIndex] = array[i]; sortedIndex++;
                i++;
            } else if (array[i] > array[j]) {
                sortedArray[sortedIndex] = array[j]; sortedIndex++;
                j++;
            } else {
                sortedArray[sortedIndex] = array[i]; sortedIndex++;
                sortedArray[sortedIndex] = array[j]; sortedIndex++;
                i++; j++;
            }
        }
        //add remaining elements
        while (i <= middle) {
            sortedArray[sortedIndex] = array[i]; sortedIndex++;
            i++;
        }
        while (j <= right) {
            sortedArray[sortedIndex] = array[j]; sortedIndex++;
            j++;
        }

        //update main array
        for(int k=0; k<sizeOfSortedArray; k++) {
            array[left + k] = sortedArray[k];
        }
    }
}
