class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> numList = new ArrayList<>();
        //int numRows = numRows//Integer.getInteger(args[0]);
        //int[] num = new int[numRows];
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            if (numList.size() == 0) {
                num.add(i+1);
                numList.add(num);
            } else {
                num = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        num.add(numList.get(i - 1).get(0));
                    } else
                        num.add(numList.get(i - 1).get(j - 1) + numList.get(i - 1).get(j));

                }
                numList.add(num);
            }
        }
        System.out.println("output");
        return numList;
        //numList.forEach(System.out::println);
        //               numList.add(num)

        // numList.add(numRws)
    }
}