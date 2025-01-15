class Solution {
    public int minimizeXor(int num1, int num2) {
        int countNum2Bits = Integer.bitCount(num2);
        int result = 0;

        for (int i = 31; i >= 0 && countNum2Bits > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i);
                countNum2Bits--;
            }
        }

        for (int i = 0; i <= 31 && countNum2Bits > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                countNum2Bits--;
            }
        }

        return result;
    }
}
