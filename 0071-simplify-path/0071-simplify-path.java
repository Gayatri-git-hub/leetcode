class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < dirs.length; i++) {
            String dirOrFile = dirs[i];
            
            if(dirOrFile.equalsIgnoreCase("..")){
                if(!stk.isEmpty())
                    stk.pop();
            }
            else if(!dirOrFile.equalsIgnoreCase(".") && !dirOrFile.isEmpty() && !dirOrFile.isBlank())
                stk.push(dirOrFile);
        }

        for (String st : stk) {
                sb.append("/").append(st);
        }

        return sb.toString().isEmpty() ? "/": sb.toString();   
    }
}