class Solution:
    def isValid(self, s: str) -> bool:
        stk = []

        if (s.__len__() <= 0):
            return True
        
        if (s.__len__() % 2 != 0):
            return False

        dict = { ')': '(', ']' : '[', '}': '{' }

        # Input: s = "([])"
        for char in s:
            if (char in dict.values()):
                stk.append(char)
            else:
                if (stk.__len__() == 0):
                    return False
                stkTop = stk[-1]
                if (stkTop == dict.get(char)):
                    stk.pop(-1)
                else:
                    return False

        if (stk.__len__() > 0):
            return False
        else:
            return True



        