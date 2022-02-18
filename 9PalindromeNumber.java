/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
For example, 121 is a palindrome while 123 is not.
*/

class Solution {
    public boolean isPalindrome(int x) {
        
        int y = x;
        int reverse = 0;
        while (y>0)
        {
            reverse *=10;
            reverse += y%10;
            y /= 10;
        }
        return reverse == x;
    }
}
