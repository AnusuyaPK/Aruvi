package DivideAndConquer;

public class LeetCode_MergeSort {
    public static void main(String[] args) {
        //Problem 1: kth element in merged two sorted arrays
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

        //Problem 2: Count the inversions
        int[] arrayProb2 = {4,3,2,1};
        int inversionCount = countInversions(arrayProb2, 0, arrayProb2.length-1);
        System.out.println(inversionCount);
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

    public static int countInversions(int[] array, int left, int right) {
        if(left == right) { //base condition
            return 0;
        }
        int inversionCount = 0;
        //1.divide
        int middle = (left + right) / 2;
        // array 1: left - middle; array2: middle + 1 - right

        //2.sort
        int countFromLeftArray = countInversions(array, left, middle); // sort 1st array
        int countFromRightArray = countInversions(array, middle + 1, right); // sord secord array

        //3.merge sorted arrays
        int countFromMerge = mergeSortedArrays2(array, left, middle, right);
        inversionCount = countFromLeftArray + countFromRightArray + countFromMerge;


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

        return inversionCount;
    }

    public static int mergeSortedArrays2(int[] array, int left, int middle, int right) {
        // [left - middle] [ middle+1 - right]
        int inversionCount = 0;
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
                inversionCount += middle - i + 1; // eg: [left 4 - middle 9] i=7, 9-7+1
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

        return inversionCount;
    }
}
