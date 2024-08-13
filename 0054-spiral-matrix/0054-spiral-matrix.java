class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> results = new ArrayList<>();

        int rowBegin =0, rowEnd = matrix.length-1, colBegin = 0,  colEnd = matrix[0].length-1;
      
       while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                 results.add(matrix[rowBegin][j]);   
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                results.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd){
                for (int j = colEnd; j >= colBegin; j--) {
                    results.add(matrix[rowEnd][j]);
                }
                
            }
            rowEnd--;

            if(colBegin <= colEnd){
                for (int i = rowEnd; i >=rowBegin; i--) {
                    results.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
       }
       return results;
    }
}