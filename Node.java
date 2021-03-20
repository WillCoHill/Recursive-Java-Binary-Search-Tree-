/*
 * For class: Data Structures/Pro. Dsgn. Lab - 2020F
 * Professor Chris Ferguson
 * 11/24/2020
 */
package project5;

/**
 *
 * @author William "Cody" Hill
 */
public class Node {
    public int data;
    public Node left, right;
    
    public Node(int dat) {
        data = dat;
        left = null;
        right = null;
    }
    
    public String toString () {
        String retString = "";
        retString += data;
        retString += " ";
        return retString;
    } 
}
