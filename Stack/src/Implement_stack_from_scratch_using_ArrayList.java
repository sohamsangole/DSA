import java.util.ArrayList;

interface myStackInterface<E>
{
    boolean isEmpty();
    int size();
    void push(E e);
    E pop();
    E top();

}

class myStack<E> implements myStackInterface<E>
{
    ArrayList<E> a = new ArrayList<E>();

    private static int t = -1;

    @Override
    public boolean isEmpty() {
        return t==-1;
    }

    @Override
    public int size() {
        return t+1;
    }

    @Override
    public void push(E e) {
        a.add(e);
        t++;
    }

    @Override
    public E pop() {
        E data;
        if (t>-1)
        {
            data = a.get(t);
            a.remove(t);
            t--;
        }
        else
        {
            data = null;
            System.out.println("Stack is Empty");
        }
        return data;
    }

    @Override
    public E top() {
        return a.get(t);
    }
    public void display(){
        System.out.println(a.toString());
    }
}
public class Implement_stack_from_scratch_using_ArrayList {
    public static void main(String[] args) {
        myStack<Integer> m1 = new myStack<>();
        m1.push(10);
        m1.push(9);
        m1.push(8);
        m1.push(7);
        m1.display();
        System.out.println(m1.size());
        m1.pop();
        m1.display();
        m1.pop();
        m1.pop();
        m1.pop();
        System.out.println(m1.size());
        m1.pop();
        m1.display();
        m1.push(10);
    }
}
