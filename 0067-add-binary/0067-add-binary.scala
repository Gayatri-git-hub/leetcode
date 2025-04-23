object Solution {
    def addBinary(s1: String, s2: String): String = {
      println("Starting processing now...")
      val maxLen = Math.max(s1.length(),s2.length())

      var i = s1.length()-1
      var j = s2.length()-1
      var sum =0
      var carry = 0

      val sb= StringBuilder() 

      for(c <- 0 until maxLen){
          //println(s"c: $c")
          sum=sum + carry

          if(i >= 0)
            {
              println(s"Picked: ${s1.charAt(i)}")
              sum = sum + (s1.charAt(i) - '0')
              println(s"sum: $sum")
              i = i -1
            }
          
          if(j >= 0)
            {
              println(s"Picked: ${s2.charAt(j)}")
              sum = sum + (s2.charAt(j) - '0')
              println(s"sum: $sum")
              j =j-1
              }

          if(sum >= 2)
            carry = 1
          else 
            carry=0

          sb.append(sum % 2)
          sum = 0
          println(s"carry: $carry")
          println(s"Appended String: ${sb.toString()}")
          println("--------------------------------------")
      }
      if (carry == 1) sb.append(carry)
      sb.reverse.toString()
    }
}
