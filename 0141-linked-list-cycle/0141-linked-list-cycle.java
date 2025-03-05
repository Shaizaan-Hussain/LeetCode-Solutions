/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tptr = null;
        for(tptr=head; tptr!=null;tptr=tptr.next)
        {
            if(set.contains(tptr)==true)
            {
                return true;
            }
            else
            {
                set.add(tptr);
            }
        }      
        return false;
    }
}