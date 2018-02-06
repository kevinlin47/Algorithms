/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

/**
 *
 * @author Kevin Lin
 */
public class ReverseLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Create a test linked list from 1 to 5
        LinkedList myList=new LinkedList();
        
        for (int i=1;i<=5;++i)
        {
            myList.appendToTail(i);
        }
        
        //print original list
        myList.printList();
        
        //call our reverse list method
        myList.reverseList();
        
        //display the reversed list
        myList.printList();
    }
    
}
