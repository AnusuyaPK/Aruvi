import java.util.Arrays;

public class LeetCode_MergeSort {
    public static void main(String[] args) {
        //kth element in merged two sorted arrays
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 7;

        int[] finalArray = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            finalArray[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            finalArray[a.length + i] = b[i];
        }
        mergeSortedArrays(finalArray, 0, a.length-1, finalArray.length-1);
        System.out.println(finalArray[k]);

        System.out.println(findkthIndexElement(a, b, k));
    }

    //Method1
    public static void mergeSortedArrays(int[] array, int left, int middle, int right) {
        // [left - middle] [ middle+1 - right]
        int i = left;
        int j = middle + 1;
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

    //Method2
    public static int findkthIndexElement(int[] array1, int[] array2, int k) {
        // [left - middle] [ middle+1 - right]
        int i = 0;
        int j = 0;
        int pntr = -1;

        while(i <= array1.length-1 && j <= array2.length-1) {
            if(array1[i] < array2[j]) {
                pntr += 1;
                if(pntr == k) {
                    return array1[i];
                }
                i++;
            } else if (array1[i] > array2[j]) {
                pntr += 1;
                if(pntr == k) {
                    return array2[j];
                }
                j++;
            } else {
                pntr += 1;
                if(pntr == k) {
                    return array1[i];
                }
                i++;
                pntr += 1;
                if(pntr == k) {
                    return array2[j];
                }
                j++;
            }
        }
        //add remaining elements
        while (i <= array1.length-1) {
            pntr += 1;
            if(pntr == k) {
                return array1[i];
            }
            i++;
        }
        while (j <= array2.length-1) {
            pntr += 1;
            if(pntr == k) {
                return array2[j];
            }
            j++;
        }
        return -1;
    }
}
