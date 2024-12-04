
class Solution {
    public String customSortString(String order, String s) {
        //Character[] arr = Arrays.asList<Character>()(s.toCharArray());
        //Character arr = Arrays.asList<Character>(s.transform<Character>((c) -> (Character) c));
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        

        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < order.length(); i++) {
            map.put((Character) order.charAt(i), i);
        }
        Arrays.sort(arr, (c1, c2) -> map.getOrDefault(c1, 0) - map.getOrDefault(c2, 0));
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}