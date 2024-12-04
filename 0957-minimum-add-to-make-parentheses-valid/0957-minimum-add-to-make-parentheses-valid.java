class Solution {
    public int minAddToMakeValid(String s) {
        int minPar =0;
        Stack<Character> st = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') st.push(c);
            else {
                if (c ==')' && st.isEmpty()) minPar += 1;
                else
                    st.pop();  
            }
        }
        minPar += st.size();

        return minPar;
        
    }
}