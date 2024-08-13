class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        ArrayList<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        triangle.add(new ArrayList<Integer>(currRow));

        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = triangle.get(row-1);

            currRow = new ArrayList<>();
            currRow.add(1);
            for (int col = 1; col < triangle.get(row-1).size(); col++) {
                currRow.add(triangle.get(row-1).get(col-1) + triangle.get(row-1).get(col));    
            }
            currRow.add(1);
            triangle.add(new ArrayList<Integer>(currRow));
        }
       
        return triangle;
    }
}