class Solution {
    public int myAtoi(String s) {
    
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 1. Trim leading/trailing whitespace
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        // 2. Handle optional sign
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        // 3. Convert digits, stop at first non-digit
        long result = 0;  // use long to detect overflow
        while (index < s.length()) {
            char c = s.charAt(index);
            if (!Character.isDigit(c)) {
                break;
            }
            int digit = c - '0';
            result = result * 10 + digit;

            // 4. Check overflow / underflow
            long tmp = result * sign;
            if (tmp > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (tmp < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }

        return (int)(result * sign);
    }
}
