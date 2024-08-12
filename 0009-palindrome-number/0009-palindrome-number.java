class Solution {
    public boolean isPalindrome(int x) {
        String numStr = Integer.toString(x);

        int left = 0;
        int right = numStr.length()-1;
        while (left < right) {
            if(numStr.toCharArray()[left] != numStr.toCharArray()[right])
                return false;
            left++;
            right--;    
        }

        return true;
    }
}