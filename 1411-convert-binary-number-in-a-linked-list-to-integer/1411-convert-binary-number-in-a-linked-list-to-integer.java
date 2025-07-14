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
    public int getDecimalValue(ListNode head) {
       List<Integer> tempList = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            tempList.add(current.val);
            current = current.next;
        }

        // Convert to int array
        int[] result = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            result[i] = tempList.get(i);
        }

        int count = 0;
        int value = 0;
        for(int i = result.length-1;i>=0;i--){
            if(result[i]== 1){
                count += Math.pow(2,value);
            }
            value++;
        }
        return count;
    }
}