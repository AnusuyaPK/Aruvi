public class MaximumSubarraySum {
    public static void main(String[] args) {
        int array[] = {2,3,-8,7,-1,2,3};
        System.out.println( calculateMaxSubarraySum(array, 0, array.length-1) );
    }

    public static int calculateMaxSubarraySum(int[] array, int low, int high) {
        // base condition
        if(low == high) {
            return array[low];
        }
        int midPoint = (low + high)/2;
        // left array - max sum
        int maxSumFromLeftArray = calculateMaxSubarraySum(array, low, midPoint);
        // right array - max sum
        int maxSumFromRightArray = calculateMaxSubarraySum(array, midPoint+1, high);
        // cross - max sum
        int maxSumFromCross = calculateMaxSumFromCross(array, low, high);

        return maxOf(maxSumFromLeftArray, maxSumFromRightArray, maxSumFromCross);
    }

    public static int calculateMaxSumFromCross(int[] array, int low, int high) {
        int rightMax = Integer.MIN_VALUE;
        int midPoint = (low+high)/2;
        // right
        // 7
        // 7 -1
        // 7 -1 2
        // 7 -1 2 3
        int end = midPoint;
        int sum = 0;
        while(end <= high){
            sum += array[end];
            end+=1;
            if(sum > rightMax) {
                rightMax = sum;
            }
        }

        // left
        int leftMax = Integer.MIN_VALUE;
        int leftEnd = midPoint;
        int leftSum = 0;
        // 7
        // -8 7
        // 3 -8 7
        // 2 3 -8 7
        while(leftEnd >= low){
            leftSum += array[leftEnd];
            leftEnd-=1;
            if(leftSum > leftMax) {
                leftMax = leftSum;
            }
        }
        // max
        return maxOf(rightMax, leftMax + rightMax - array[midPoint]);
    }

    public static int maxOf(int a, int b, int c) {
        if(a > b && a > c) {
            return a;
        } else if( b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public  static  int maxOf(int a, int b){
        if(a>b) {
            return a;
        }
        return b;
    }

}
