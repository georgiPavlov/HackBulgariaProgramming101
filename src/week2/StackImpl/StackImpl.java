package week2.StackImpl;

/**
 * Created by georgipavlov on 26.11.15.
 */
class StackImpl  implements StackInterface {

   private class Node{
       private  Object o;
       private Node next;

       private Node(){
           o=null;
           next=null;
       }
   }

    private Node head=null;
    private Node tail=null;



    @Override
    public void push(Object o) {
        if(HasObject(o)){
            System.out.println("This element is already in the stack");
            return;
        }
        Node newNode = new Node();
        newNode.o=o;
        newNode.next=head;
        head=newNode;
    }

    @Override
    public Object pop() {
        Node pop= head;
        head=head.next;
        return pop.o;
    }


    @Override
    public int length() {
        Node temp;
        int count=0;

        for (temp = head;temp != null; temp=temp.next) {
          count++;
        }
        return count;
    }

    @Override
    public void clear() {
        Node temp;
        for (temp = head;temp != null; temp=temp.next) {
            temp=temp.next;
        }
        head = temp;
    }

    @Override
    public boolean isEmpty() {

        if(head != null){
            return false;
        }
        return true;
    }

    public boolean HasObject(Object o){
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
