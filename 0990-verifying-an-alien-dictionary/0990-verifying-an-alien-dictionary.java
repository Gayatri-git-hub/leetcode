class Solution {
    HashMap<Character, Integer> sortMap = new HashMap<>();

    private int compareChar(Character a, Character b){
        if (sortMap.get(a) < sortMap.get(b)) return -1;
        else if (sortMap.get(a) == sortMap.get(b)) return 0;
        return 1;
    }

    private int compareStr(String s1, String s2){
       int minLength = Math.min(s1.length(), s2.length());

       for (int i = 0; i <= minLength-1; i++) {
            int res = compareChar(s1.charAt(i), s2.charAt(i));
            if (res == 0) {
                if (i < minLength-1) 
                    continue;
                else
                    if(s1.length() == s2.length()) return 0;
                    else if (s1.length() == minLength) return -1;
                    else return 1; 
            }
            return res;
       } 
       return 0;
    }

    private int compareNew(char a, char b, String order){

        return Integer.compare(order.indexOf(a), order.indexOf(b));
    }

    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if(j >= words[i+1].length()) return false;
                if(compareNew(words[i].charAt(j), words[i+1].charAt(j), order) < 0 ) break;        
                else if(compareNew(words[i].charAt(j), words[i+1].charAt(j), order) > 0 ) return false;
            }
            
        }
        return true;
/*
        for (int i = 0; i < order.length(); i++) {
            sortMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length -1; i++) {
            if (compareStr(words[i], words[i+1]) <= 0) continue;
            else return false;
        }
        return true; */
    }
}