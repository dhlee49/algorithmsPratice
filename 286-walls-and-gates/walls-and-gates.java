class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) continue;
                if(rooms[i][j] == -1) continue;
                rooms[i][j] = bfs(i, j, rooms);
            }
        }
    }
    private int bfs(int i1, int j1, int[][] rooms) {
        
        Queue<int[]> bfsQueue = new LinkedList();
        bfsQueue.offer(new int[] {i1, j1});
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        int cnt = 0;
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            cnt++;
            for(int i = 0; i < size; i++) {
                int[] curr = bfsQueue.poll();
                for(int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) continue;
                    if(visited[x][y]) continue;
                    visited[x][y] = true;
                    if(rooms[x][y] == 0) return cnt;
                    if(rooms[x][y] == -1) continue;
                    bfsQueue.offer(new int[] {x, y});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}