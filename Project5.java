/*
  * For class: Data Structures/Pro. Dsgn. Lab - 2020F
 * Professor Chris Ferguson
 * 11/24/2020
 */
package project5;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author William "Cody" Hill 
 */
public class Project5 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        Tree tree1 = new Tree(); 
        FileOutputStream fileStream = new FileOutputStream("numbers.txt");
        PrintWriter outFS = new PrintWriter(fileStream);
        outFS.println(50);
        outFS.println(30);
        outFS.println(60);
        outFS.println(10);
        outFS.println(80);
        outFS.println(55);
        outFS.println(40);
        outFS.close();
        System.out.println("Reading numbers from file...");
        try {
        File numbers = new File("numbers.txt");
       // FileInputStream fileByteStream = new FileInputStream(numbers);
        Scanner inFS = new Scanner(numbers);
          
         while (inFS.hasNextInt()) {
             tree1.insert(inFS.nextInt());
         }
         
         inFS.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
         
         System.out.print("Here is the ordered BST of inserted numbers: ");
         tree1.inorder();
         System.out.println("\n");
       
         
         System.out.print("a. Number of nodes in tree: ");
         System.out.println(tree1.getCount());
         System.out.print("b. Height of the tree: ");
         System.out.println(tree1.findHeight());
         System.out.print("c. Maximum node value in tree: ");
         System.out.println(tree1.findMax());
         //System.out.print("c. Minimum node value in tree: ");
         //System.out.println(tree1.findMin());
         System.out.print("d. Added values of tree nodes: ");
         System.out.println(tree1.addTree());
         System.out.print("e. Average of the tree nodes: ");
         System.out.println(tree1.average());
         System.out.print("Enter value to search for: ");
         int userInp1 = scan.nextInt();
         Node resultNode = tree1.search(userInp1);
         System.out.print("f. Searching nodes for value " + userInp1 + ": ");
         if (resultNode == null) {
             System.out.println("Value not found");
         } else {
             System.out.println(resultNode + " found in tree!");
         }
         
         System.out.println("\nEnter a root node as a base: ");
         Node a = tree1.search(scan.nextInt());
         while (a == null) {
             System.out.println("\nEnter a root that exists within the BST node as a base: ");
             a = tree1.search(scan.nextInt());
         }
         System.out.println("\nEnter a node child that exists within the BST to search for: ");
         Node b = tree1.search(scan.nextInt());
         while (b == null) {
             System.out.println("\nEnter a root node as a base: ");
             b = tree1.search(scan.nextInt());
         }
         System.out.print("\ng. Is A an ancestor of B?: ");
         tree1.isAncestor(a, b);
        
         System.out.print("\nh. The highest full level is: ");
         System.out.print(tree1.highestFull());
        
     }
    
}
