class Solution {
    List<String> results = new ArrayList<>();
    Map<Character, String> map = Map.of('2', "abc",'3', "def",'4', "ghi",'5', "jkl",'6', "mno",'7', "pqrs",'8', "tuv", '9', "wxyz");
    String givenDigits;

    private void backtrack(int index, StringBuilder sb){

        if(sb.length() == givenDigits.length()){
            results.add(sb.toString());
            return;
        }

        String possChars = map.get(givenDigits.charAt(index));
        for (int i = 0; i < possChars.length(); i++) {
            sb.append(possChars.charAt(i));

            backtrack(index+1, sb);

            sb.deleteCharAt(sb.length()-1);
        }

    }
    
    public List<String> letterCombinations(String digits) {     

        if (digits.length() ==0) return results;

        givenDigits = digits;

        backtrack(0, new StringBuilder());

        return results;

      
    }
}