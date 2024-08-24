class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Character prevCh=null;
            if(!st.empty())
                prevCh = st.peek();
            if (ch == prevCh) 
                    st.pop();
            else
                st.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
}