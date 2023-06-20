class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
    public void print()
    {
        ListNode temp = this;
        while (temp!=null)
        {
            System.out.print(temp.val);
            if (temp.next!=null)
            {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }
}
public class Reverse_a_LL {
    public static ListNode solution(ListNode head)
    {
        ListNode curr = head;
        ListNode forward = null;
        ListNode prev = null;
        while (curr!=null)
        {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        head = prev;
        return head;
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
        ListNode rev = solution(n1);
        rev.print();
    }
}
