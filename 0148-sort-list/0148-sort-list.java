class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null)
        {
            arr.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(arr);
        head=new ListNode(-1);
        temp=head;
        for(int num:arr)
        {
            temp.next=new ListNode(num);
            temp=temp.next;
        }
        return head.next;
    }
}