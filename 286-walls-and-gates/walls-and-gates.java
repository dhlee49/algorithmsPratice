class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> bfsQueue = new LinkedList();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] > 0) continue;
                if(rooms[i][j] == -1) continue;
                bfsQueue.offer(new int[] {i, j});
            }
        }
        bfs(bfsQueue, rooms);
    }
    private void bfs(Queue<int[]> bfsQueue, int[][] rooms) {
        int cnt = 0;
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfsQueue.poll();
                for(int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] != Integer.MAX_VALUE) continue;
                    rooms[x][y] = rooms[curr[0]][curr[1]] + 1;
                    bfsQueue.offer(new int[] {x, y});
                }
            }
        }
    }
}