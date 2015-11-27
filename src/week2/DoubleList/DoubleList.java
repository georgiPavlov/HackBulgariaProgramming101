package week2.DoubleList;

/**
 * Created by georgipavlov on 26.11.15.
 */
public class DoubleList implements DoubleListInterfase{

    public class Node{
        protected   int o;
        protected Node right;
        protected Node left;

        public Node(){
            o=0;
            right=null;
            left=null;
        }
    }

    protected Node head=null;
    protected Node tail=null;


    @Override
    public void add(int o) {
        Node newNode = new Node();
        newNode.o=o;
        newNode.left=head;
        newNode.right=null;
        head=newNode;

        if(tail == null){
            tail=newNode;
            return;
        }
        Node tailNode;
        for (tailNode = tail; tailNode.right != null  ; tailNode = tailNode.right) {}
        tailNode.right = newNode;
    }

    public void print(){
        System.out.println(tail.o);
        System.out.println(tail.right.o);
        System.out.println(tail.right.right.o);

    }

    @Override
    public int size() {
        if(head == null){
            return 0;
        }
        Node temp =head;
        Node temp2 =tail;
        int count=0;
        boolean endOfLoop=false;
        do{
            if(temp == temp2){
                count++;
                break;
            }
            if(temp.left == temp2 ){
                endOfLoop=true;
            }
            count+=2;
            temp=temp.left;
            temp2=temp2.right;
        }while(!endOfLoop);
        return count;
    }

    @Override
    public void clear() {
       head=null;
        tail=null;

    }

    @Override
    public boolean isEmpty() {
        if(head==null){return true;}
        return false;
    }

    @Override
    public int get(int elementIndex) {
        int count1=this.size()-1;
        int count2=0;
        boolean endOfLoop=false;


        Node temp =head;
        Node temp2 =tail;
        do{
            if(temp.left == temp2 ){
                endOfLoop=true;
            }
            if(count1 == elementIndex || count2 == elementIndex){
                return count1 ==elementIndex ? temp.o : temp2.o;
            }
            if(temp == temp2){break;}

            temp=temp.left;
            temp2=temp2.right;
                count2++;
                count1--;
        }while(!endOfLoop);
        System.out.println("element not found");
        return -1;
    }

    @Override
    public int getHead() {
        return head.o;
    }

    @Override
    public int getTail() {
        return tail.o;
    }

    @Override
    public void remove(int elementIndex) {
        int count1=this.size()-1;
        int count2=0;
        Node temp =head;
        Node temp2 =tail;
        boolean endOfLoop=false;
        if(elementIndex == count1){
            head=temp.left;
            if(head!= null){
                head.right=null;
            }
            return;
        }else if(elementIndex == count2){
            tail=temp2.right;
            if(tail!= null){
                tail.left=null;
            }
            return;
        }

        do{
            if(temp.left == temp2 ){
                endOfLoop=true;
            }
            if(count1 == elementIndex || count2 == elementIndex){
                if(count1 == elementIndex){
                    temp.right.left=temp.left;
                    temp.left.right=temp.right;
                    return;
                }else {
                    temp2.right.left=temp2.left;
                    temp2.left.right=temp2.right;
                    return;
                }
            }
            if(temp == temp2){break;}

            temp=temp.left;
            temp2=temp2.right;
            count2++;
            count1--;
        }while(!endOfLoop);
        System.out.println("element not found");


    }

    public int getPop(){
        if(head== null){
            System.out.println("No elements");
            return -1;
        }
        Node node =head;
        head.left.right=null;
        head=head.left;
        return node.o;
    }



}
