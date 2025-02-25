class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int count = 0;
        int totalEven = 1; 
        int totalOdd = 0;
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 != 0) { 
                count = (count + totalEven) % mod;
                totalOdd++;
            } else { 
                count = (count + totalOdd) % mod;
                totalEven++;
            }
        }

        return count;
    }
}
