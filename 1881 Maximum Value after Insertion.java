/*
You are given a very large integer n, represented as a string, and an integer digit x. The digits in n and the digit x are in the inclusive range [1, 9], and n may represent a negative number.

You want to maximize n's numerical value by inserting x anywhere in the decimal representation of n. You cannot insert x to the left of the negative sign.

For example, if n = 73 and x = 6, it would be best to insert it between 7 and 3, making n = 763.
If n = -55 and x = 2, it would be best to insert it before the first 5, making n = -255.
Return a string representing the maximum value of n after the insertion.

Example:
Input: n = "-13", x = 2
Output: "-123"
Explanation: You can make n one of {-213, -123, -132}, and the largest of those three is -123.
*/

class Solution {
    public String maxValue(String n, int x) {
        if (!n.substring(0,1).equals("-")) //if n is positive
        {
            for (int i = 0; i<n.length(); i++)
            {
                if (Integer.parseInt(n.substring(i,i+1))<x)
                {
                    //put x in the string at that position
                    return n.substring(0,i) + x + n.substring(i);
                }
            }
        }
        else //n is negative
        {
            for (int i = 1; i<n.length(); i++)
            {
                if (Integer.parseInt(n.substring(i,i+1))>x)
                {
                    //put x in the string at that position
                    return n.substring(0,i) + x + n.substring(i);
                }
            }
        }
        return n+x;
    }
}
