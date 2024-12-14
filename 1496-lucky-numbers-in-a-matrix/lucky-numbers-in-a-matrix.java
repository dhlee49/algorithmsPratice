class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] col = new int[matrix[0].length];
        int[] row = new int[matrix.length];
        for(int i = 0; i < matrix.length; i ++) {
            row[i] = Arrays.stream(matrix[i]).min().orElse(-1);
        }
        for(int i = 0; i < matrix[0].length; i ++) {
            for(int j = 0; j < matrix.length; j++) {
                col[i] = Math.max(col[i], matrix[j][i]);
            }
        }
        List<Integer> ans = new LinkedList();
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == row[i] && matrix[i][j] == col[j]) ans.add(matrix[i][j]);
            }
        }
        return ans;
    }
}