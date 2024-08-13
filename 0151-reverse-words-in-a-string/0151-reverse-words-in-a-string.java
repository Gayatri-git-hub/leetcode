class Solution {
    public String reverseWords(String s) {
       StringBuilder sb = new StringBuilder();

       String[] wd = s.split(" ");

        sb.append(wd[wd.length-1]);
       for (int i = wd.length -2; i >=0 ; i--) {
            if (!wd[i].isBlank()) {
                sb.append(" ").append(wd[i]);
            }    
       }

       return sb.toString();
    }
}