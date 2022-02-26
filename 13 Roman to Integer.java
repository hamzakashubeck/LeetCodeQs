/*
Given a roman numeral, convert it to an integer.

Example:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/


class Solution {
    public int romanToInt(String s) {
        
        HashMap<String,Integer> roman = new HashMap<String, Integer>();
        roman.put("I",1);
        roman.put("V",5);
        roman.put("X",10);
        roman.put("L",50);
        roman.put("C",100);
        roman.put("D",500);
        roman.put("M",1000);
        
        int total = 0;
        for (int i = 0; i<s.length(); i++)
        {
            String letter = s.substring(i,i+1);
            if (letter.equals("I") && i+1<s.length())
            {
                String nextLet = s.substring(i+1,i+2);
                
                if(nextLet.equals("V"))  { total+=4; i++;}
                
                else if (nextLet.equals("X"))   { total+=9; i++;}
                
                else    { total+=roman.get(letter); }
            }
            else if (letter.equals("X") && i+1<s.length())
            {
                String nextLet = s.substring(i+1,i+2);
                
                if(nextLet.equals("L"))  { total+=40; i++;}
                
                else if (nextLet.equals("C")) { total+=90; i++;}
                
                else    { total+=roman.get(letter); }
            }
            else if (letter.equals("C") && i+1<s.length())
            {
                String nextLet = s.substring(i+1,i+2);
                
                if(nextLet.equals("D")) { total+=400; i++;}
                
                else if (nextLet.equals("M")) { total+=900; i++;}
                
                else    { total+=roman.get(letter); }
            }
            else
            {
                total+= roman.get(letter);
            }
        }
        return total;
    }
}
