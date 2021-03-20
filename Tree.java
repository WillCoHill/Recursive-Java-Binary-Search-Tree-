/*
 * For class: Data Structures/Pro. Dsgn. Lab - 2020F
 * Professor Chris Ferguson
 * 11/24/2020
 */
package project5;
import java.util.*;

/**
 *
 * @author William "Cody" Hill
 */
public class Tree {
    
    public Node root;
    
    public Tree() {
        root = null;
    }
    
    public void insert(int data) {
        
         root = insert(root, data);
         
     }
    
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
    
 
    public int getCount() { 
        return getCount(root); 
    } 
    
    public int getCount(Node node) { 
        if (node == null) {
            return 0; 
        }
        int count = 0;
        count++;
        count += getCount(node.left);
        count += getCount(node.right);
        return count;
    } 
  
    public int findHeight() {
        
        return findHeight(root); 
        
    }
    
    public int findHeight(Node root){
    
      if(root == null)
        return 0;

      if (findHeight(root.left) >= findHeight(root.right)) {
        return findHeight(root.left) + 1;
      } else {
        return findHeight(root.right) + 1;
      }
    }
    
    public int findMax() {
        return findMax(root);
    }
    
    public int findMax(Node node) { 
        if (node == null) 
            return Integer.MIN_VALUE; 
  
        int resolve = node.data; 
        int leftRes = findMax(node.left); 
        int rightRes = findMax(node.right); 
  
        if (leftRes > rightRes) 
            resolve = leftRes; 
        if (rightRes > resolve) 
            resolve = rightRes; 
        return resolve; 
    } 
    
    public int findMin() {
        return findMin(root);
    }
    
    public int findMin(Node node) { 
        Node current = node; 
  
        /* loop down to find the leftmost leaf */
        while (current.left != null) { 
            current = current.left; 
        } 
        return (current.data); 
    } 
    
    public int addTree() {
        return addTree(root);
    }
    
    public int addTree(Node root) {  
    if (root == null)  
        return 0;  
    return (root.data + addTree(root.left) +  
                       addTree(root.right));  
    } 
    
    public double average() {
        if (root != null)
          return (double)addTree() / (double)getCount();
        else
          return 0;
    }
    
    public Node search(int data2) {
        return search(root, data2);
    }
    
    public Node search(Node node, int data) { 
     
      if (node == null || node.data == data) 
          return node; 
  
      // Key is greater than root
      if (node.data < data /*&& node.right != null*/) 
         return search(node.right, data); 
  
      // Key is smaller than root 
      if (node.data > data /*&& node.left != null*/)
        return search(node.left, data); 
      else
         return null;
    }
    
    public void findParent(Node node,
                       int val, int parent) {
        if (node == null)
            return;
 
      // If current node is the required node
        if (node.data == val) {
        // Print its parent
        System.out.print(parent);
        } else {
          findParent(node.left, val, node.data);
          findParent(node.right, val, node.data);
        }
    }
    
    public void isAncestor(Node route, Node second) {
        Node temp = search(route, second.data);
        if (temp == second) {
            System.out.println(second + " is a child of " + route);
        } else {
            System.out.println(second + " is not a child of " + route);
        }
    }
    
    public int highestFull() {
       int max = findMax();
       int min = findMin();
       if (findHeight(search(max)) > findHeight(search(min))) {
           return findHeight(search(min)) + 1;
       } else {
           return findHeight(search(max)) + 1;
       }
    }
    
    
    public void inorder() {
         inorder(root);
     }
    
    private void inorder(Node step) {
         if (step != null) {
             inorder(step.left);
             System.out.print(step.data +" ");
             inorder(step.right);
         }
     }
}
