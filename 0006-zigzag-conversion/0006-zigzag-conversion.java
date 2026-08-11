class Solution {
    public String convert(String s, int numRows) {
    
        if (numRows == 1 || s.length() <= numRows) {
            // If only one row, or string shorter than rows, zigzag is just the string itself
            return s;
        }

        // One StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // If we reach either top or bottom, reverse the direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows to form result
        StringBuilder result = new StringBuilder();
        for (StringBuilder rowSB : rows) {
            result.append(rowSB);
        }
        return result.toString();
    }
}