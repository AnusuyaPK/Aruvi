public class LeetCode {
    public static void main(String[] args) {
//        int[] array = {4,5,6,7,0,1,2};
//        System.out.println(binarySearchUsingRecursion(array, 0, 0,array.length-1));

        int[] array2 = {1,3,5,6};
        int target  = 6;
        System.out.println(findInsertionPosition(array2, target, 0, array2.length-1));
    }

    //1.search in rotated sorted array
    public static int binarySearchUsingRecursion(int[] array, int searchElement, int left, int right) {
        if (left > right) { // base condition
            System.out.println("Element is not found");
            return -1;
        }
        int middle = (left + right) / 2;
        //printing:
        System.out.println("left: " + left + " right: " + right);
        System.out.println("middle: " + middle);
        for (int i = left; i <= right; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        if (array[middle] == searchElement) {
            System.out.println("Element " + array[middle] + " found at position " + middle);
            return middle;
        }
        // left middle right
        // 1. find which is sorted
        if (array[left] <= array[middle]) { // left is sorted
            if (searchElement >= array[left] && searchElement <= array[middle]) { // search ele lies in left
                right = middle - 1; //go to left
            } else {
                left = middle + 1;
            }
        } else if (array[right] >= array[middle]) { // right is sorted
            if (searchElement >= array[middle] && searchElement <= array[right]) { // search ele lies in right
                left = middle + 1; //go to right
            } else {
                right = middle - 1;
            }
        }
        return binarySearchUsingRecursion(array, searchElement, left, right); //different
    }

    // find insertion position
    public static int findInsertionPosition(int[] array, int searchElement, int left, int right) {
        if(left > right) { // base condition
            System.out.println("Element is not found");
            return left;
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
            return middle;
        }
        else if(searchElement < array[middle]) {
            //left side array
            right = middle - 1;
        }
        else if(searchElement > array[middle]) {
            //right side array
            left = middle + 1;
        }
        return findInsertionPosition(array, searchElement, left, right); //different
    }

}
