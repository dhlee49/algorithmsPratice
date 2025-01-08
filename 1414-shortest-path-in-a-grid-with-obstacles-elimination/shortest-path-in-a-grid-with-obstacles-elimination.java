class Solution {
    public int shortestPath(int[][] grid, int k) {
        //use BFS approach
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        Queue<int[]> qu = new LinkedList();
        qu.offer(new int[] {0, 0, k});
        visited[0][0][k] = true;
        int cnt = 0;
        int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!qu.isEmpty()) {
            int size  = qu.size();
            for(int i = 0; i < size; i++) {
                int[] curr = qu.poll();
                int x = curr[0];
                int y = curr[1];
                int curK = curr[2];
                //Base case - reached the end
                if(x == grid.length - 1 && y == grid[0].length - 1) return cnt;
                for(int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
                    int newK = curK - grid[newX][newY];
                    if(newK < 0) continue;
                    //Base case - dupe
                    if(visited[newX][newY][newK]) continue;
                    visited[newX][newY][newK] = true;
                    qu.offer(new int[] {newX, newY, newK});
                }
            }
            cnt++;
        }
        return -1;
    }
}