package java.divideandconquer;

//calculates highest subsum wich is possible in the given array

public class SumSubArray {
    public static int sumsubarray(int[] A, int i, int j){

        if(i == j){ // base case
            return A[i];
        }

        int m = (i+j)/2;

        int l = sumsubarray(A, i, m);
        int r = sumsubarray(A, m+1, j);
        int c = sumcrossarray(A, i, m, j);

        return Math.max(Math.max(l,r), c);
    }

    public static int sumcrossarray(int[] A, int i, int m, int j) {

        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int k = m; k >= i; k--) {
            sum = sum + A[k];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int k = m + 1; k <= j; k++) {
            sum = sum + A[k];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }


        return Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));

    }

    public static void main(String[] args) {
        int arr[] = {4, -5, 1, 3, -3, 2, 5, -1};
        int n = arr.length;
        int maxSum = sumsubarray(arr, 0, n-1);

        System.out.println("Maximum contiguous sum is " + maxSum);

    }
}
