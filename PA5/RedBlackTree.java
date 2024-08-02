

public class RedBlackTree {

    //======================================================================
    //|static defines                                                      
    //======================================================================
    static final int BLACK = 1;
    static final int RED = 0;
    private static final int NEGATIVE_RED = -1;
    private static final int DOUBLE_BLACK = 2;

    //======================================================================
    //|Inner class Node                                                     
    //======================================================================
    static class Node
    {
        public Comparable data;
        public Node left;
        public Node right;
        public Node parent;
        public int color;
        
        public void addNode(Node node){
            if(this.left == null){
                setLeftChild(node);
            }
            else if(this.right == null){
                setRightChild(node);
            }
            else{
                //error
            }
        }

        /**
        Sets the left child and updates its parent reference.
        @param child the new left child
        */
        public void setLeftChild(Node child)
        {
        // Insert your code here
            this.left = child;
        }

        /**
        Sets the right child and updates its parent reference.
        @param child the new right child
        */
        public void setRightChild(Node child)
        {
        // Insert your code here
            this.right = child;
        }

    }

    //======================================================================
    //|RBT Attributes                                                    
    //======================================================================
    private Node root;

    //======================================================================
    //|RBT Methods                                                 
    //======================================================================
    //Override toString so that it actually prints
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    inOrderTraversal(root, sb);
    return sb.toString();
    }

    private void inOrderTraversal(Node node, StringBuilder sb) {
        if(node != null){
            sb.append(node.data);
            sb.append(" ");
            inOrderTraversal(node.left, sb);
            inOrderTraversal(node.right, sb);
        }
        return;
    }

    // public void addNode(Node node, Node target){
        
    // }

    public void add(Comparable obj) {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        newNode.color = RED;
        if (root == null) { root = newNode; }
        else { 
            //identify the correct parent of the new node
            Node currentNode = this.root;
            while(currentNode != null){
                newNode.parent = currentNode;
                if(newNode.data.compareTo(currentNode.data) == -1){
                    currentNode = currentNode.left;
                }
                else{
                    currentNode = currentNode.right;
                }
            }
            
            //identify which side the new node should be on
            if(newNode.data.compareTo(newNode.parent.data) == -1){
                newNode.parent.left = newNode;
            }
            else{
                newNode.parent.right = newNode;
            }

            //color?

        }
        fixAfterAdd(newNode);
    }

    /**
    * Updates the parents links when a node is replaced.
    * Also updates the root reference if the root is replaced.
    *
    * @param toBeReplaced the node that is to be replaced
    * @param replacement the node that replaces that node
    */

    //Task 3
    private void replaceWith(Node toBeReplaced, Node replacement){
        replacement.parent = toBeReplaced.parent;
        replacement.left = toBeReplaced.left;
        replacement.right = toBeReplaced.right;

        if(toBeReplaced.parent == null){
            this.root = replacement;
        }
        else if(toBeReplaced.parent.left == toBeReplaced){
            toBeReplaced.parent.left = replacement;
        }
        else{
            toBeReplaced.parent.right = replacement;
        }

        if(toBeReplaced.left != null){
            toBeReplaced.left.parent = replacement;
        }
        if(toBeReplaced.right != null){
            toBeReplaced.right.parent = replacement;
        }
    }

    /**
    * Restores the tree to a red-black tree after a node has been
    added.
    *
    * @param newNode the node that has been added
    */
    //Task 4

    private void fixAfterAdd(Node newNode) {
        while((newNode != this.root) && (newNode.parent.color == RED)){
            if(newNode.parent == newNode.parent.parent.left){
                Node temp = newNode.parent.parent.right;
                if(temp.color == RED){
                    newNode.parent.color = BLACK;
                    temp.color = BLACK;
                    newNode.parent.parent.color = RED;
                    newNode = newNode.parent.parent;
                }
                else{
                    if(newNode == newNode.parent.right){
                        newNode = newNode.parent;
                        rotateLeft(newNode);
                    }
                    newNode.parent.color = BLACK;
                    newNode.parent.parent.color = RED;
                    rotateRight(newNode.parent.parent);
                }
            }
            else{
                Node temp = newNode.parent.parent.left;
                if(temp.color == RED){
                    newNode.parent.color = BLACK;
                    temp.color = BLACK;
                    newNode.parent.parent.color = RED;
                    newNode = newNode.parent.parent;
                }
                else{
                    if(newNode == newNode.parent.left){
                        newNode = newNode.parent;
                        rotateRight(newNode);
                    }
                    newNode.parent.color = BLACK;
                    newNode.parent.parent.color = RED;
                    rotateLeft(newNode.parent.parent);
                }
            }
        }
        this.root.color = BLACK;
    }

    /**
    * Fixes a violation.
    *
    * @param child the child with a red parent
    */

    private void fixDoubleRed(Node child) {
    }

    //Need to Create rotate functions to fix the double reds
    private void rotateLeft(Node node) {
        node.right = node.right.left;
        if(node.right.left != null){
            node.right.left.parent = node;
        }
        node.right.parent = node.parent;
        if(node.parent == null){
            this.root = node.right;
        }
        else if(node == node.parent.left){
            node.parent.left = node.right;
        }
        else{
            node.parent.right = node.right;
        }
        node.right.left = node;
        node.parent = node.right;
    }

    private void rotateRight(Node node) {
        node.left = node.left.right;
        if(node.left.right != null){
            node.left.right.parent = node;
        }
        node.left.parent = node.parent;
        if(node.parent == null){
            this.root = node.left;
        }
        else if(node == node.parent.right){
            node.parent.right = node.left;
        }
        else{
            node.parent.left = node.left;
        }
        node.left.right = node;
        node.parent = node.left;
    }

    public static void testFromBook()
    {
        RedBlackTree t = new RedBlackTree();
        t.add(1);
        t.add(2);
//        t.add(3);
        // t.add("d");
        // t.add("E");
        System.out.println(t.toString());
    }

    public static void main(String[] args){
        testFromBook();
    }
}