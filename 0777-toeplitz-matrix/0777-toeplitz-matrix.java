class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (!hm.containsKey(i-j)) hm.put(i-j, matrix[i][j]);
                else if (matrix[i][j] != hm.get(i-j)) return false;
            }
        }

        return true;
    }
}