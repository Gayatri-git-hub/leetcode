class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
        return false;

        int[] scounter = new int[26];
        int[] tcounter = new int[26];

        for(int i=0; i<s.length(); i++){
           scounter[s.charAt(i) - 'a']++;
           tcounter[t.charAt(i) - 'a']++;     
        }

        for (int i = 0; i < 26; i++) {
            if(scounter[i] != tcounter[i])
                return false;
        }

        return true;

        
    }
}