public class middle_element {
    public static ListNode middleNode(ListNode head) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        int i = 1;
        while(temp1!=null)
        {
            temp1 = temp1.next;
            if (i%2 == 0)
            {
                temp2 = temp2.next;
            }
            i++;
        }
        return temp2;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode middle = middleNode(n1);
        middle.print();
    }
}
