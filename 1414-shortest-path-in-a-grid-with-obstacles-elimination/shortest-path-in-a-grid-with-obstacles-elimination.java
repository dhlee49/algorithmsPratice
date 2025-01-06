class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        int[] entry = new int[] {0, 0, k};
        Queue<int[]> bfs = new LinkedList();
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        bfs.offer(entry);
        if(rows == 1 && cols == 1) return 0;
        visited[0][0][k] = true;
        int result = 0;
        while(!bfs.isEmpty()) {
            result++;
            int size = bfs.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfs.poll();
                for(int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) continue;
                    int curK = curr[2] - grid[x][y];
                    if(x == grid.length - 1 && y == grid[0].length - 1 && curK >= 0)   return result;
                    if(curK < 0) continue;
                    if(!visited[x][y][curK]) {
                        bfs.offer(new int[] {x, y, curK});
                        visited[x][y][curK] = true;
                    }
                }
            }
        }
        return -1;
    }
}