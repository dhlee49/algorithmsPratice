class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] directions = new int[][] {{1, 0},{-1, 0},{0, -1},{0, 1}};
        int xLen = maze.length;
        int yLen = maze[0].length;
        int[][] visited = new int[xLen][yLen];
        for(int[] visit : visited) {
            Arrays.fill(visit, -1);
        }
        PriorityQueue<int[]> bfsQueue = new PriorityQueue<>((a, b) -> (visited[a[0]][a[1]] - visited[b[0]][b[1]]));
        bfsQueue.offer(start);
        visited[start[0]][start[1]] = 0;
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfsQueue.poll();
                for(int[] direction : directions) {
                    int currMoves = visited[curr[0]][curr[1]];
                    int x = curr[0];
                    int y = curr[1];
                    while(x >= 0 && x < xLen && y >= 0 && y < yLen && maze[x][y] != 1) {
                        x += direction[0];
                        y += direction[1];
                        currMoves++;
                    }
                    if(x != curr[0] || y != curr[1]) {
                        x -= direction[0];
                        y -= direction[1];
                        currMoves--;
                    }
                    if(visited[x][y] != -1 && visited[x][y] <= currMoves) continue;
                    visited[x][y] = currMoves;
                    System.out.println(x + " & " + y);
                    bfsQueue.offer(new int[] {x, y});
                }
            }
        }
        return visited[destination[0]][destination[1]];
    }
}