class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int x1 = 0;
        int x2 = matrix[0].length - 1;
        int y1 = 0;
        int y2 = matrix.length - 1;
        boolean inverse = false;
        //base current position
        int x = 0, y = 0;
        List<Integer> ans = new LinkedList();
        while(y2 >= y1 && x2 >= x1) {
            if(x1 == x2 && y1 == y2) {
                ans.add(matrix[x1][y1]);
                break;
            }
            //First iteration go right ->
            for(int i = x1; i < x2; i++) {
                ans.add(matrix[y1][i]);
            }
            //Go down
            for(int i = y1; i < y2; i++) {
                ans.add(matrix[i][x2]);
            }
            //Go left
            if(y1 != y2) {
                for(int i = x2; i > x1; i--) {
                    ans.add(matrix[y2][i]);
                }
            } else {
                ans.add(matrix[y2][x2]);
            }
            //Go up
            if(x1 != x2) {
                for(int i = y2; i > y1; i--) {
                    ans.add(matrix[i][x1]);
                }
            } else {
                ans.add(matrix[y2][x1]);
            }
            x1++;
            x2--;
            y1++;
            y2--;
        }
        return ans;
    }
}