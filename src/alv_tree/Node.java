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
public class Node {
    int key;
    int height;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;                
    }
    
   
    
    public void printInfo(){
        System.out.println(this.key + this.height);
    }
    
    
      public boolean lessThan(int valua){
        return this.key < valua;
    }
    
    public boolean greaterThan(int valua){
        return this.key > valua;
    }
    
    public boolean equal(int key){
        return this.key == key;
    }
    
}
    
    

