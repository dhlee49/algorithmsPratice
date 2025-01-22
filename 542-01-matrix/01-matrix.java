class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> bfsQueue = new LinkedList();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) bfsQueue.offer(new int[] {i, j});
                if(mat[i][j] == 1) mat[i][j] = -1;
            }
        }
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!bfsQueue.isEmpty()) {
            int[] curr = bfsQueue.poll();
            for(int[] direction : directions) {
                int x = curr[0] + direction[0];
                int y = curr[1] + direction[1];
                if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] > -1) continue;
                mat[x][y] = mat[curr[0]][curr[1]] + 1;
                bfsQueue.offer(new int[] {x, y});
            }
        }
        return mat;
    }
}