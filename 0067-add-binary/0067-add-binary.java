class Solution {
    public String addBinary(String a, String b) {

        //Option 3) using Bit manipulation
        /*
        int x= Integer.parseInt(a, 2);
        int y = Integer.parseInt(b, 2);

        while (y != 0) {
            int temp = (x & y) << 1;
            x= x ^ y;
            y = temp;
        }

       return Integer.toBinaryString(x);  */

        //Option 2
        //return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

        //option1()
         StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() -1;
        int carry = 0;
        int sum = 0;

        while (i >= 0 || j >=0) {
            sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';

            sb.append(sum % 2);
            carry = sum / 2;

            i--; j--;
        }
        if (carry == 1)
            sb.append('1');
        return sb.reverse().toString();         
    }
}