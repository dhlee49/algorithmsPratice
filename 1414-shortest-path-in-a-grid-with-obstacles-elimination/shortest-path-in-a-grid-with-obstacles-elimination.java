class Solution {
    public int shortestPath(int[][] grid, int k) {
        boolean visited[][][] = new boolean[grid.length][grid[0].length][k + 1];
        Queue<int[]> bfsQ = new LinkedList();
        bfsQ.offer(new int[] {0, 0, k});
        visited[0][0][k] = true;
        int steps = 0;
        int[][] directions = new int[][] {{1, 0},{-1, 0},{0, 1},{0, -1}};
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfsQ.poll();
                int x = curr[0];
                int y = curr[1];
                int curK = curr[2];
                if(x == grid.length - 1 && y == grid[0].length - 1 && k >= 0) return steps;
                for(int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
                    int newK = curK - grid[newX][newY];
                    if(newK < 0) continue;
                    if(visited[newX][newY][newK]) continue;
                    visited[newX][newY][newK] = true;
                    bfsQ.offer(new int[] {newX, newY, newK});
                }
            }
            steps++;
        }
        return -1;
    }
}