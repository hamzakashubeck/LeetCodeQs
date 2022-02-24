/* 
You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.
For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
Return the head of the modified linked list.

Example:
Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation: The modified list contains
- The sum of the nodes: 3 + 1 = 4.
- The sum of the nodes: 4 + 5 + 2 = 11.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        
        ListNode myListHead = new ListNode();
        ListNode myListCurr = myListHead;
        
        while (head!=null)
        {
            int currSum = 0;
            while (head.val!=0)
            {
                currSum += head.val;
                head = head.next;
            }
            if (currSum!=0)
            {
                myListCurr.next = new ListNode(currSum);
                myListCurr = myListCurr.next;
            }
            head = head.next;
        }
        return myListHead.next;
    }
}
