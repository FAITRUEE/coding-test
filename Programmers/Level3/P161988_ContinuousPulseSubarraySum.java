class Solution {
    public long solution(int[] sequence) {
        long[] arr1 = new long[sequence.length];
        long[] arr2 = new long[sequence.length];
        
        for (int i = 0; i < sequence.length; i++) {
            arr1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1); // [1,-1,1,-1...]
            arr2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1); // [-1,1,-1,1...]
        }
        
        long maxSum1 = arr1[0];
        long maxSum2 = arr2[0];
        long currentSum1 = arr1[0];
        long currentSum2 = arr2[0];
        
        // 카데인 알고리즘
        for (int i = 1; i < arr1.length; i++){
            currentSum1 = Math.max(arr1[i], currentSum1 + arr1[i]);
            maxSum1 = Math.max(maxSum1, currentSum1);
        }
        
        for (int i = 1; i < arr2.length; i++){
            currentSum2 = Math.max(arr2[i], currentSum2 + arr2[i]);
            maxSum2 = Math.max(maxSum2, currentSum2);
        }
        
        return Math.max(maxSum1,maxSum2);
        
    }
}
