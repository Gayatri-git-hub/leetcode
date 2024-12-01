class Solution {
    public int calculate(String s) {
        int result =0;
        int currNum=0;
        Stack<Integer> st = new Stack<>();
        Character op = '+';

        for (int i=0; i<s.length(); i++){
            Character currChar = s.charAt(i);

            if(Character.isDigit(currChar))
                currNum =(currNum * 10) + (currChar - '0');

            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length()-1){

                switch (op) {
                    case '-':
                        st.push(-1 * currNum);
                        break;
                    case '+':
                        st.push(currNum);
                        break;
                    case '*':
                        st.push(st.pop() * currNum);
                        break;
                    case '/':
                        st.push(st.pop() / currNum);
                        break;
                }

                currNum =0;
                op= currChar;
            }

        }
        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}