class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[] rowIdx = new int[rowSum.length];
        int[] colIdx = new int[colSum.length];
        int[][] ans = new int[rowSum.length][colSum.length];
        for(int i = 0; i < rowSum.length; i++) {
            for(int j = 0; j < colSum.length; j++) {
                if(rowSum[i] > colSum[j]) {
                    //Row is bigger
                    ans[i][j] = colSum[j];
                    rowSum[i] -= colSum[j];
                    colSum[j] -= colSum[j];
                } else {
                    ans[i][j] = rowSum[i];
                    colSum[j] -= rowSum[i];
                    rowSum[i] -= rowSum[i];
                }
            }
        }
        return ans;
            
    }
}