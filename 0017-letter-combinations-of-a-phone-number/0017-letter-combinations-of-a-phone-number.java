class Solution {
    List<String> res;

    Map<Character, String> map = Map.of('2', "abc",'3', "def",'4', "ghi",'5', "jkl",'6', "mno",'7', "pqrs",'8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {

        res = new LinkedList<>();
        if(digits.isEmpty()) return res;
        
        backtrack(digits, 0, "");

        return res;
    }

    private void backtrack(String digits, int index, String currStr){
        if (index == digits.length()) {
            res.add(currStr.toString());
            return;
        }
        
        String letters = map.get(digits.charAt(index));

        for (char c : letters.toCharArray()) {
            backtrack(digits, index + 1, currStr + c);
        }

    }
}