// WITHOUT SORTING  => O(N)
class Solution {
    public String customSortString(String order, String s) {

        if(s.length() == 0 || order.length() == 0) return null;

        Map<Character, Integer> freqMap = new HashMap<>();
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(order.indexOf(s.charAt(i)) > 0)
                freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
            else  
                sb1.append(s.charAt(i));  

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            if(freqMap.containsKey(order.charAt(i)))
                for (int j = 0; j < freqMap.get(order.charAt(i)); j++) {
                    sb.append(order.charAt(i));
                }
        }
        
        return sb1.append(sb).toString();
    }
}

/*  WITH SORTING - O(N log N)

class Solution {
    public String customSortString(String order, String s) {
        //Character[] arr = Arrays.asList<Character>()(s.toCharArray());
        //Character arr = Arrays.asList<Character>(s.transform<Character>((c) -> (Character) c));
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        

        Arrays.sort(arr, (c1, c2) -> order.indexOf(c1) - order.indexOf(c2));
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}
*/