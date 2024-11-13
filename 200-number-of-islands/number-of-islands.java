class Solution {
    private char[][] map;
    private int islands = 0;
    public int numIslands(char[][] grid) {
        map = grid;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(map[i][j] == '1') {
                    bfs(i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void bfs(int x, int y) {
        //we already checked island, clean up the map
        map[x][y] = '0';
        if(x - 1 > -1 && map[x-1][y] != '0') bfs(x-1,y);
        if(y - 1 > -1 && map[x][y-1] != '0') bfs(x,y-1);
        if(x + 1 < map.length && map[x+1][y] != '0') bfs(x+1,y);
        if(y + 1 < map[0].length && map[x][y+1] != '0') bfs(x,y+1);
        return;
    }
}