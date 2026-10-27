class Solution {
    public int integerBreak(int n) {
        int [] m= new int[n+1];
        m[1] = 1;
        for(int i= 2;i<=n;i++){
            for(int j=1;j<i;j++){
                m[i] = Math.max(m[i],Math.max (j*(i-j),j*m[i-j]));
            }
        }
        return m[n];
            }
        }