public class MaxSquareWithOne {

    public int maxSquare(int[][] matrix) {
        int rows, cols;
        if((rows = matrix.length) == 0 || (cols = matrix[0].length) == 0) {
            return 0;
        }
        int[][] dp = new int[rows + 1][cols + 1];
        int max = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] > 0) {
                    dp[i+1][j+1] = 1 + Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]));
                    max = Math.max(max, dp[i+1][j+1]);
                }
            }
        }
        return max * max;
    }
}
