class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Pair<Character, Integer>> sk = new Stack<Pair<Character, Integer>>();
        Set<Integer> idxSet = new HashSet<>();

        for (int i =0; i<s.length(); i++){
            Character c = s.charAt(i);
            
            if(c == '(')
                sk.push(new Pair<Character, Integer>(c, i));  

            if(c == ')'){
                if (sk.empty()) {
                   idxSet.add(i); 
                }
                else if(sk.peek().getKey() == '(')
                    sk.pop();
                
            } 
        }
        while (!sk.isEmpty()) {
            idxSet.add(sk.pop().getValue());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i =0; i<s.length(); i++){
            if(!idxSet.contains(i))
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}