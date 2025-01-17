class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] directions = new int[][] {{1, 0},{-1, 0},{0, -1},{0, 1}};
        char[] directionsChar = new char[] {'d', 'u', 'l', 'r'};
        int xLen = maze.length;
        int yLen = maze[0].length;
        int[][] visited = new int[xLen][yLen];
        String[][] visitedPath = new String[xLen][yLen];
        for(int[] visit : visited) {
            Arrays.fill(visit, -1);
        }
        PriorityQueue<int[]> bfsQueue = new PriorityQueue<>((a, b) -> (visited[a[0]][a[1]] - visited[b[0]][b[1]]));
        bfsQueue.offer(ball);
        visited[ball[0]][ball[1]] = 0;
        visitedPath[ball[0]][ball[1]] = "";
        List<String> ans = new ArrayList();
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                int[] curr = bfsQueue.poll();
                for(int j = 0; j < 4; j++) {
                    int currMoves = visited[curr[0]][curr[1]];
                    String currMovesString = visitedPath[curr[0]][curr[1]] + directionsChar[j];
                    int x = curr[0];
                    int y = curr[1];
                    while(x >= 0 && x < xLen && y >= 0 && y < yLen && maze[x][y] != 1) {
                        x += directions[j][0];
                        y += directions[j][1];
                        if(x - directions[j][0] == hole[0] && y - directions[j][1] == hole[1]) break;
                        currMoves++;
                    }
                    if(x != curr[0] || y != curr[1]) {
                        x -= directions[j][0];
                        y -= directions[j][1];
                        currMoves--;
                    }
                    if(visited[x][y] != -1 && visited[x][y] < currMoves) continue;
                    if(visited[x][y] != -1 && visited[x][y] == currMoves) {
                        if(visitedPath[x][y] == null || currMovesString.compareTo(visitedPath[x][y]) < 0) {
                            visitedPath[x][y] = currMovesString;
                        } else {
                            continue;
                        }
                    }
                    visited[x][y] = currMoves;
                    if(visitedPath[x][y] == null || currMovesString.compareTo(visitedPath[x][y]) < 0) {
                        visitedPath[x][y] = currMovesString;
                    } 
                    if(x == hole[0] && y == hole[1]) {
                        ans.add(currMovesString);
                    } else {
                        bfsQueue.offer(new int[] {x, y});
                    }
                }
            }
        }
        if(ans.isEmpty()) return "impossible";
        Collections.sort(ans);
        return ans.get(0);
    }
}
