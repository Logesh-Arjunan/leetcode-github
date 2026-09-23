class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lo = 0, hi = n - 1;
        int ans = 0;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int papersAtLeast = n - mid; // papers with citations >= citations[mid]
            
            if (citations[mid] >= papersAtLeast) {
                ans = papersAtLeast;
                hi = mid - 1; // try to find a smaller index (larger h-index range)
            } else {
                lo = mid + 1;
            }
        }
        
        return ans;
    }
}