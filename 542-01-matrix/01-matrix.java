class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int xLen = mat.length;
        int yLen = mat[0].length;
        Queue<int[]> bfsQueue = new LinkedList<>(); 
        for(int i = 0; i < xLen; i++) {
            for(int j = 0; j < yLen; j++) {
                if(mat[i][j] == 0) {
                    bfsQueue.offer(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while(!bfsQueue.isEmpty()) {
            int[] curr = bfsQueue.poll();
            int x = curr[0];
            int y = curr[1];
            System.out.println(x + "  & " + y);
            System.out.println(mat[x][y]);
            for(int[] direction : directions) {
                x = curr[0] + direction[0];
                y = curr[1] + direction[1];
                if(x < 0 || x >= xLen || y < 0 || y >= yLen || mat[x][y] == 0 || mat[x][y] > 0) continue;
                mat[x][y] = mat[curr[0]][curr[1]] + 1;
                bfsQueue.offer(new int[] {x, y});
            }
        }
        return mat;
    }
}