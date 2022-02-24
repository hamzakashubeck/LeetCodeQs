/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
*/


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] merged = new int[nums1.length+nums2.length];
        
        int a1 = 0;
        int a2 = 0;
        int currIndex = 0;
        
        while (a1<nums1.length && a2<nums2.length)
        {
            if (nums1[a1] > nums2[a2])
            {
                merged[currIndex] = nums2[a2];
                a2++;
            }
            else
            {
                merged[currIndex] = nums1[a1];
                a1++;
            }
            currIndex++;
        }
        
        if(!(a1<nums1.length))
        {
            //a2 has leftover elements to be included
            while (a2<nums2.length)
            {
                merged[currIndex] = nums2[a2];
                currIndex++;
                a2++;
            }
        }
        else if(!(a2<nums2.length))
        {
            //a1 has leftover elements to be included
            while (a1<nums1.length)
            {
                merged[currIndex] = nums1[a1];
                currIndex++;
                a1++;
            }
        }
        
        if (merged.length %2 !=0)
        {
            return merged[merged.length/2];
        }
        else
        {
            return (merged[merged.length/2] + merged[merged.length/2 -1])/2.0;
        }
    }
}
