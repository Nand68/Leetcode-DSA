class Solution {
    int n;

    public String smallestNumber(String pattern) {
        n = pattern.length();
        boolean[] used = new boolean[10];
        int[] nums = new int[n + 1];
        backtrack(0, used, nums, pattern);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + 1; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public boolean backtrack(int index, boolean[] used, int[] nums, String pattern) {
        if (index > n) {
            return true;
        }
        for (int digit = 1; digit < 10; digit++) {
            if (used[digit] == true) {
                continue;
            }
            if (index == 0) {
                used[digit] = true;
                nums[index] = digit;
                if (backtrack(index + 1, used, nums, pattern)) {
                    return true;
                }
                used[digit] = false;
                nums[index] = 0;
            } else {
                if (pattern.charAt(index-1) == 'I') {
                    if (nums[index - 1] < digit) {
                        used[digit] = true;
                        nums[index] = digit;
                        if (backtrack(index + 1, used, nums, pattern)) {
                            return true;
                        }
                        used[digit] = false;
                        nums[index] = 0;
                    }
                } else {
                    if (nums[index - 1] > digit) {
                        used[digit] = true;
                        nums[index] = digit;
                        if (backtrack(index + 1, used, nums, pattern)) {
                            return true;
                        }
                        used[digit] = false;
                        nums[index] = 0;

                    }
                }
            }
        }
        return false;
    }
}
