class Solution {
    public int minimumObstacles(int[][] grid) {
        //Idea 
        //Perform DFS. Fill the new array with 0 if the path is clean.
        //If you cannot reach the end, unfortunate end your trip there but mark kyour trip!
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[0][0] = 0;
        int ans = - 1, cnt = 0;
        Queue<int[]> bfs = new LinkedList<int[]>();
        bfs.offer(new int[] {0, 0});
        int count = 0;
        while(!bfs.isEmpty()) {
            int size = bfs.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfs.poll();
                int y = curr[0];
                int x = curr[1];
                if(y > 0 && verify(grid[y-1][x],visited[y - 1][x], visited[y][x])) {
                    bfs.offer(new int[] { y - 1, x});
                    visited[y-1][x] = visited[y][x] + grid[y-1][x];
                }
                //Left
                if(x > 0 && verify(grid[y][x-1],visited[y][x - 1], visited[y][x])) {
                    bfs.offer(new int[] { y, x - 1});
                    visited[y][x-1] = visited[y][x] + grid[y][x-1];
                }
                //Right
                if(x < grid[0].length - 1 && verify(grid[y][x+1], visited[y][x + 1], visited[y][x])) {
                    bfs.offer(new int[] { y , x + 1});
                    visited[y][x+1] = visited[y][x] + grid[y][x+1];
                }
                //Bottom
                if(y < grid.length - 1 && verify(grid[y+1][x],visited[y + 1][x], visited[y][x])) {
                    bfs.offer(new int[] { y + 1, x });
                    visited[y+1][x] = visited[y][x] + grid[y+1][x];
                }
            }
        }
        return visited[grid.length - 1][grid[0].length - 1];
    }
    private boolean verify(int grid, int visited, int rock) {
        if(visited == -1) return true;
        if(rock + grid< visited) return true;
        return false;
    }
}