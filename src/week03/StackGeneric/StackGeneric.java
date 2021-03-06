package week03.StackGeneric;

/**
 * Created by georgipavlov on 30.11.15.
 */
public class StackGeneric<T>  implements GenericStackInterface <T> {

    private class Node{
            private  T o;
            private Node next;

            private Node(){
                o=null;
                next=null;
            }
        }

        private Node head=null;
        private Node tail=null;


    @Override
    public void push(T o) {
        if(HasObject(o)){
            System.out.println("This element is already in the stack");
            return;
        }
        Node newNode = new Node();
        newNode.o=o;
        newNode.next=head;
        head=newNode;
    }

    public T pop() {
            Node pop= head;
            head=head.next;
            return pop.o;
        }



        public int length() {
            Node temp;
            int count=0;

            for (temp = head;temp != null; temp=temp.next) {
                count++;
            }
            return count;
        }


        public void clear() {
            head = null;
        }


        public boolean isEmpty() {

            if(head != null){
                return false;
            }
            return true;
        }

        public boolean HasObject(T o){
            Node temp;
            boolean result =false;
            for (temp = head;temp != null; temp=temp.next) {
                if(temp.o.equals(o)){
                    return true;
                }
            }
            return false;
        }



}
