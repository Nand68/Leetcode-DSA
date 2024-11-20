class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();

        int countA = 0, countB = 0, countC = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') countA++;
            else if (ch == 'b') countB++;
            else if (ch == 'c') countC++;
        }

        if (countA < k || countB < k || countC < k) {
            return -1;
        }

     
        int i = 0, j = 0;
        int notDeletedWindowSize = 0;

        while (j < n) {

            if (s.charAt(j) == 'a') {
                countA--;
            } else if (s.charAt(j) == 'b') {
                countB--;
            } else if (s.charAt(j) == 'c') {
                countC--;
            }

            
            while (i <= j && (countA < k || countB < k || countC < k)) {
                if (s.charAt(i) == 'a') {
                    countA++;
                } else if (s.charAt(i) == 'b') {
                    countB++;
                } else if (s.charAt(i) == 'c') {
                    countC++;
                }
                i++;
            }

            
            notDeletedWindowSize = Math.max(notDeletedWindowSize, j - i + 1);
            j++;
        }

        return n - notDeletedWindowSize;
    }
}
