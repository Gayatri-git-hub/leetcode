class Solution {
     Map<Character, String> map = Map.of('2', "abc",'3', "def",'4', "ghi",'5', "jkl",'6', "mno",'7', "pqrs",'8', "tuv", '9', "wxyz");

    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        if(digits.length() == 0) return res;

        backtrack(digits, 0, "");

        return res;
    }

    private void backtrack(String digits, int index, String curr){

        if(index == digits.length()){
            res.add(curr);
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            backtrack(digits, index + 1, curr + c);
        }
    }
}