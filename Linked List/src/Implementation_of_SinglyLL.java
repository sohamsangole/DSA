import org.w3c.dom.Node;

class node<E>{
    E data;
    node<E> next;
}
class myLinkedList<E>{
    node<E>head;
    node<E>tail;
    public int size = 0;

    public node<E> createLL(E data)
    {
        node<E> n = new node<>();
        n.data = data;
        n.next = null;
        head = n;
        tail = n;
        size = 1;
        return n;
    }
    public void insert(E data,int location)
    {
        node<E> n = new node<>();
        n.data = data;
        if (head==null)
        {
            createLL(data);
        }
        else if (location == 0)
        {
            n.next = head;
            head = n;
            size++;
        }
        else if (location>=size) {
            n.next = null;
            tail.next = n;
            tail = n;
            tail.next = null;
            size++;
        }
        else
        {
            node<E> temp = new node<>();
            temp = head;
            for (int i = 0; i <location; i++) {
                temp = temp.next;
            }
            node<E> nextNode = new node<>();
            nextNode = temp.next;
            temp.next = n;
            n.next = nextNode;
            size++;
        }
    }

    public void printList()
    {
        node<E> temp = new node<>();
        temp = head;
        for (int i = 0;i<size;i++)
        {
            System.out.print(temp.data);

            if (temp.next != null)
            {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void delete(int location)
    {
        if (size == 0)
        {
            System.out.println("Head is Null!");
        }
        else if (size == 1)
        {
            head = null;
            tail = null;
            size = 0;
        }
        else if (location == 0)
        {
            head = head.next;
            size--;
        }
        else if (location>=size)
        {
            node<E> temp = new node<>();
            temp = head;
            for (int i = 0; i <size-1; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            temp.next = null;
            size--;
        }
        else
        {
            node<E> temp = new node<>();
            temp = head;
            for (int i = 0; i <location-1; i++) {
                temp = temp.next;
            }
            node<E>newNext = new node<>();
            newNext = temp.next.next;
            temp.next = newNext;
            size--;
        }
    }
}

public class Implementation_of_SinglyLL {
    public static void main(String[] args) {
        myLinkedList<Integer> linkedList = new myLinkedList<>();
        linkedList.insert(10,1);
        linkedList.insert(9,2);
        linkedList.insert(8,3);
        linkedList.insert(7,4);
        linkedList.insert(6,5);
//        System.out.println(linkedList.head.data);
//        System.out.println(linkedList.head.next.data);
//        System.out.println(linkedList.head.next.next.data);
//        System.out.println(linkedList.head.next.next.next.data);
//        System.out.println(linkedList.head.next.next.next.next.data);
        linkedList.printList();
        linkedList.delete(10);
        linkedList.printList();
    }
}