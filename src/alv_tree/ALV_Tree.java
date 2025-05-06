/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alv_tree;

/**
 *
 * @author admin
 */
public class ALV_Tree {

    private int size;
    public Node root;

    public ALV_Tree() {
        this.size = 0;
        this.root = null;
    }

    public int size() {
        return this.size;
    }

    // toasn tử 3 ngôi
    // cú pháp: condition ? value_if_true : value_if_fasle
    public int height(Node node) {
        return (node == null) ? 0 : node.height;
        // nếu cây null thì height = 0, k null thì trả về chiều cao
    }

    public ALV_Tree(int size, Node root) {
        this.size = size;
        this.root = root;
    }

    public void insert(int key) {
        this.root = insert(this.root, key);
    }

    private Node insert(Node node, int key) {
        if(node == null){
            this.size++;
            return new Node(key);
        }
        
        if(node.lessThan(key)){
            node.right = insert(node.right, key);
        }else {
            node.left = insert(node.left, key);
        }
        
        node.height = max(height(node.left), height(node.right) +1);
        int balance = getBalance(node);
        
        if(balance>1){
            // => right
            if(node.left.lessThan(key)){
                // left Rotation
                node.left = LeftRotation(node.left);
            }
            // right Rotation
            return RightRotation(node);
        }else if(balance < -1){
            //=> left
            if(node.right.greaterThan(key)){
                // right Rotation
                node.right = RightRotation(node.right);
            }
            // left Rotation
            return LeftRotation(node);
        }
        return node;
    }

    private int max(int key1, int key2) {
        if (key1 < key2) {
            return key2;
        } else {
            return key1;
        }
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    private Node LeftRotation(Node node) {
        if (node == null) {
            return null;
        }

        Node returnNode = node.right;
        node.right = returnNode.left;
        returnNode.left = node;

        node.height = max(height(node.left), height(node.right) - 1);
        returnNode.height = max(height(returnNode.left), height(returnNode.right) - 1);
        return returnNode;
    }

    private Node RightRotation(Node node) {
        if(node == null){
            return null;
        }
        
        Node returnNode = node.left;
        node.left = returnNode.right;
        returnNode.right = node;

        node.height = max(height(node.left), height(node.right) - 1);
        returnNode.height = max(height(returnNode.left), height(returnNode.right) - 1);
        return returnNode;
    }

    public void printPreOrder() {
        System.out.print("\n");
        System.out.println("size: " + this.size);
        System.out.print("\n");
        printPreOrder(this.root);
    }

    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }

        node.printInfo();
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    
    public void printInOrder(){
        
        System.out.println("size: " + this.size);
        
        printInOrder(this.root);
    }
    
    private void printInOrder(Node node){
         if (node == null) {
            return;
        }
         
         printPreOrder(node.left);
         node.printInfo();
         printPreOrder(node.right);
    }

}
