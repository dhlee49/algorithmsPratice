class Solution {
    public int getFood(char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int[] start = null;

        for(int i = 0; i < xLen; i++) {
            for(int j = 0; j < yLen; j++) {
                if(grid[i][j] == '*') {
                    start = new int[] {i, j};
                    break;
                }
            }
            if(start != null) break;
        }
        return bfs(start, grid);
    }
    private int bfs(int[] start, char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[xLen][yLen];
        Queue<int[]> bfsQueue = new LinkedList();
        bfsQueue.offer(start);
        int cnt = 0;
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfsQueue.poll();
                for(int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if(x < 0 || x >= xLen || y < 0 || y >= yLen || grid[x][y] == 'X') continue;
                    if(grid[x][y] == '#') return cnt + 1;
                    if(visited[x][y]) continue;
                    visited[x][y] = true;
                    bfsQueue.offer(new int[] {x, y});
                }
            }
            cnt++;
        }
        return -1;
    }
}