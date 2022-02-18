/* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The container borders are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water the container can contain is 49.
*/

class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        
        for (int i = 0; i<height.length-1; i++)
        {
            if(!(max>(height.length-i)*height[i])) //to make the method run a little faster
            {
                for (int j = i+1; j<height.length; j++)
                {
                    if(!(max>(j-i)*height[i])) //to make the method run a little faster
                    {
                        int shorter = height[i];
                        if (height[j] < height[i])
                        {
                            shorter = height[j];
                        }
                        
                        int area = shorter*(j-i);
                        if (area > max)
                        {
                        max = area;
                        }
                    }
                }
            }
        }
        return max; 
    }
}
