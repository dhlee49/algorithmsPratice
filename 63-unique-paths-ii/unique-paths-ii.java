class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid[0].length;
        int y = obstacleGrid.length;
        int[][] ans = new int[y][x];
        ans[0][0] = (1 - obstacleGrid[0][0]) * 1;
        //Basecase;
        for(int i = 1; i < y; i ++) {
            ans[i][0] = ans[i - 1][0] * (1 - obstacleGrid[i - 1][0]);
        }
        for(int i = 1; i < x; i ++) {
            ans[0][i] = ans[0][i - 1] * (1 - obstacleGrid[0][i - 1]);
        }
        for(int i = 1; i < y; i ++) {
            for(int j = 1; j < x; j++) {
                int top = ans[i - 1][j] * (1 - obstacleGrid[i - 1][j]);
                int left = ans[i][j - 1] * (1 - obstacleGrid[i][j - 1]);
                ans[i][j] = top + left;
            }
        }
        return (1 - obstacleGrid[y - 1][x - 1]) * ans[y - 1][x - 1];
    }
}