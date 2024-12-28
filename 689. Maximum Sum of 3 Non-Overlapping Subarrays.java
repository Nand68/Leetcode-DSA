import java.util.*;

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] ksum = new int[n - k + 1];
        int[] L = new int[n - 3 * k + 1];
        Arrays.fill(L, -1);

        int maxKsum = 0;
        ksum[0] = 0;
        for (int i = 0; i < k; i++) {
            ksum[0] += nums[i];
        }

        maxKsum = ksum[0];
        L[0] = 0;
        for (int i = 1; i < n - k + 1; i++) {
            ksum[i] = ksum[i - 1] - nums[i - 1] + nums[i + k - 1];
            if (i > n - 3 * k) continue;
            if (maxKsum < ksum[i]) {
                maxKsum = ksum[i];
                L[i] = i;
            } else {
                L[i] = L[i - 1];
            }
        }

        int[] R = new int[n - 3 * k + 1];
        Arrays.fill(R, -1);

        maxKsum = ksum[n - k];
        R[n - 3 * k] = n - k;
        for (int i = n - k - 1; i >= 2 * k; i--) {
            if (maxKsum <= ksum[i]) {
                maxKsum = ksum[i];
                R[i - 2 * k] = i;
            } else {
                R[i - 2 * k] = R[i + 1 - 2 * k];
            }
        }

        int[] ans = new int[3];
        Arrays.fill(ans, -1);
        int max3K = 0;
        for (int i = 0; i <= n - 3 * k; i++) {
            int sum3K = ksum[L[i]] + ksum[i + k] + ksum[R[i]];
            if (sum3K > max3K) {
                max3K = sum3K;
                ans[0] = L[i];
                ans[1] = i + k;
                ans[2] = R[i];
            }
        }

        return ans;
    }
}
