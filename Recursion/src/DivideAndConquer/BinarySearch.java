package DivideAndConquer;

public class BinarySearch {
    public static int count = 0;
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8};
        binarySearch(array, 10);
        binarySearchUsingRecursion(array, 7,0,array.length-1);
    }
    public static void binarySearch(int[] array, int searchElement) {
        int left = 0;
        int right = array.length - 1;
        int middle;
        while(left <= right) {
            middle = (left+right)/2;
            System.out.println("left: "+left + " right: " + right);
            System.out.println("middle: " + middle);
            for(int i=left; i<=right; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            if(array[middle] == searchElement) {
                System.out.println("Element "+array[middle]+" found at position "+middle);
                return;
            }
            else if(searchElement < array[middle]) {
                //left side array
                right = middle - 1;
            }
            else if(searchElement > array[middle]) {
                //right side array
                left = middle + 1;
            }

        }
        System.out.println("Element is not found");
    }
    public static void binarySearchUsingRecursion(int[] array, int searchElement, int left, int right) {
        if(left > right) { // base condition
            System.out.println("Element is not found");
            return;
        }
        int middle = (left+right)/2;
        //printing:
        System.out.println("left: "+left + " right: " + right);
        System.out.println("middle: " + middle);
        for(int i=left; i<=right; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        if(array[middle] == searchElement) {
            System.out.println("Element "+array[middle]+" found at position "+middle);
            return;
        }
        else if(searchElement < array[middle]) {
            //left side array
            right = middle - 1;
        }
        else if(searchElement > array[middle]) {
            //right side array
            left = middle + 1;
        }
        binarySearchUsingRecursion(array, searchElement, left, right); //different
    }

}