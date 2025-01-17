class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int xLen = maze.length;
        int yLen = maze[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[xLen][yLen];
        Queue<int[]> bfsQueue = new LinkedList();
        bfsQueue.offer(start);
        visited[start[0]][start[1]] = true;
        
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfsQueue.poll();
                if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
                for(int[] direction : directions) {
                    int x = curr[0];
                    int y = curr[1];
                    while(x >= 0 && x < xLen && y >= 0 && y < yLen && maze[x][y] != 1)  {
                        x += direction[0];
                        y += direction[1];
                    }
                    x -= direction[0];
                    y -= direction[1]; 
                    if(visited[x][y]) continue;
                    System.out.println(x + "& " + y);
                    bfsQueue.offer(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}