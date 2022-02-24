/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Example:
Input: x = -123
Output: -321
*/

class Solution {
    public int reverse(int x) {
        
        int result = 0;  
        int temp = x;
        boolean negate = false;
        
        if (temp<0)
        {
            negate = true;
            temp*=(-1);
        }
        
        while (temp>0)
        {
            if(result>(Math.pow(2,31)/10))
            {
                return 0;
            }
            result*=10;
            result+=temp%10;
            temp = temp/10;
        }
        
        if(negate)
        {
            result*=(-1);
        }
        
        return result;
    }
}
