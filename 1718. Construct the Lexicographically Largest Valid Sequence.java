class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean[] used = new boolean[n+1];
        int[] seq = new int[2 * n - 1];
        backtrack(0, seq, used, n);
        return seq;
    }

    public boolean backtrack(int index, int[] seq, boolean[] used, int n) {
        while (index < seq.length && seq[index] != 0) {
            index++;
        }

        if (index == seq.length) {
            return true;
        }
        for (int i = n; i >= 1; i--) {
            if (used[i]) {
                continue;
            }
            if (i == 1) {
                seq[index] = i;
                used[i] = true;
                if (backtrack(index + 1, seq, used, n)) {
                    return true;
                }
                seq[index] = 0;
                used[i] = false;
            } else if(index + i < seq.length && seq[index+i] == 0){
                seq[index] = i;
                seq[index + i] = i;
                used[i] = true;
                if (backtrack(index + 1, seq, used, n)) {
                    return true;
                }
                seq[index] = 0;
                seq[index + i] = 0;
                used[i] = false;
            }
        }
        return false;
    }
}
