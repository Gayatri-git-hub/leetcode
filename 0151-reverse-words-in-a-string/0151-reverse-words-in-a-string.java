class Solution {
    public String reverseWords(String s) {
        String[] origStr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int i = origStr.length -1;
        while (i >= 0){
            System.out.println("i: " + i + "#" + origStr[i] + "#");
            System.out.println("i: " + i + "#" + sb.toString() + "#");
            if(!origStr[i].trim().isEmpty())
                sb.append(origStr[i].trim());
            if(i != 0)
                sb.append(" ");
            i--;
        }

        return sb.toString().trim();
    }
}