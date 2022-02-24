/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Example:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
*/

class Solution {
    public String defangIPaddr(String address) {
        
        for (int i = 0; i<address.length(); i++)
        {
            if (address.substring(i,i+1).equals("."))
            {
                String newAd = address.substring(0,i) + "[.]";
                if (i<address.length())
                {
                    newAd+= address.substring(i+1);
                }
                address = newAd;
                i++;
            }
        }
        return address;
    }
}
