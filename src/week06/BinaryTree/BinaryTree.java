package week06.BinaryTree;

/**
 * Created by georgipavlov on 07.01.16.
 */
public class BinaryTree<T extends Comparable<T>> {

    private static class BinaryTreeNode<T extends Comparable<T>>
    implements Comparable<BinaryTreeNode<T>>{
        T value;

        BinaryTreeNode<T> parent;
        BinaryTreeNode<T> leftChild;
        BinaryTreeNode<T> rightChild;
        int heightNode=0;
        int depthNode=0;

        public BinaryTreeNode(T value) {
            this.value = value;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "value=" + value +
                    '}';
        }


        @Override
        public int compareTo(BinaryTreeNode<T> o) {
            return this.value.compareTo(o.value);
        }

        @Override
        public boolean equals(Object o) {
            BinaryTreeNode<T> that = (BinaryTreeNode<T>) o;
            return this.compareTo(that)==0;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }

    private BinaryTreeNode<T> root;

    public BinaryTree(){
        this.root=null;
    }

    public void insert(T value){
        if(value == null){
            throw new IllegalArgumentException();
        }
        this.root = insert(value,null,root,0);
    }
    //-----------------------------------------------------------------------------
    public BinaryTreeNode<T> insert(T value,BinaryTreeNode<T> parentNode,BinaryTreeNode<T> node,int d){
        if(node == null){
            node = new BinaryTreeNode<>(value);
            node.parent = parentNode;
            node.depthNode=d;
            if(parentNode.heightNode <= node.heightNode){
              update(parentNode);
            }
        }else {
            int compareTo = value.compareTo(node.value);
            if(compareTo < 0){
                node.leftChild = insert(value,node,node.leftChild,d+1);
            }else if(compareTo > 0){
                node.rightChild = insert(value,node,node.rightChild,d+1);
            }else {
                throw new IllegalArgumentException();
            }
        }
        return node;
    }


    //--------------------------------------------------------------------------------

    int depth=0;
    private BinaryTreeNode<T> find(T value){
        BinaryTreeNode<T> node = this.root;
        depth=0;

        while(node != null){
            int compareTo = value.compareTo(node.value);
            if(compareTo < 0){
                node = node.leftChild;
                depth++;
            }else if(compareTo > 0){
                node = node.rightChild;
                depth++;
            }else {
                break;
            }
        }
        return node;
    }

    public void remove(T value){
        BinaryTreeNode<T> nodeToDelite = find(value);
        if(nodeToDelite == null){
            return;
        }
        remove(nodeToDelite);
    }

    public void remove(BinaryTreeNode<T> node){
        int hh;
        int dd;
        if(node.leftChild!= null && node.rightChild!= null){
            BinaryTreeNode<T> replacement = node.rightChild;
            while (replacement.leftChild != null){
                replacement = replacement.leftChild;
            }
            node.value = replacement.value;
            node = replacement;
        }

        BinaryTreeNode<T> theChild = node.leftChild != null ? node.leftChild : node.rightChild;

        if(theChild != null){
            theChild.parent = node.parent;

            if(node.parent == null){
                root = theChild;
            }else {
                if(node.parent.leftChild == node){
                    theChild.heightNode = node.heightNode;
                    theChild.depthNode = node.depthNode;
                    node.parent.leftChild = theChild;
                    //to DO BFS update
                }else {
                    node.parent.rightChild = theChild;
                    //to DO BFs update
                }
            }
        }else {
            if(node.parent == null){
                root = null;
            }else {
                if(node.parent.leftChild == null){
                    node.parent.leftChild = null;
                    //To do
                }else {
                    node.parent.rightChild = null;
                    //To do
                }
            }

        }
    }

    public String depthAndHeight(T value){
      BinaryTreeNode<T> node= find(value);
        String result = "depth: " + this.depth;
        maxHeight=0;
        DFS(0,node);
        return result + " Height: " + maxHeight;
    }

    int maxHeight=0;
    private void DFS(int i,BinaryTreeNode<T> node){
        if(node == null){
            if(maxHeight< i){
                maxHeight=i;
            }
            return;
        }
        if(node.leftChild != null){
            DFS(i+1,node.leftChild);
        }else if(node.rightChild != null){
            DFS(i+1,node.rightChild);
        }
        return;
    }

    public void update(BinaryTreeNode<T> node){
        node.heightNode++;
        if(node.parent != null){
          if(node.parent.heightNode >= node.heightNode ){
            update(node.parent);
          }
        }
    }




}
