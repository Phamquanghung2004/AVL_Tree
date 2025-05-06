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
public class Main {
    public static void main(String[] args) {
        ALV_Tree avlTree = new ALV_Tree();
        avlTree.insert(100);
        avlTree.insert(200);
        avlTree.insert(300);
        avlTree.printPreOrder();
        avlTree.printInOrder();
    }
}
