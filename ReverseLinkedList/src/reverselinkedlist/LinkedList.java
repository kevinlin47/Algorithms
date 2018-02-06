/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

/**
 *
 * @author Kevin Lin
 */
public class LinkedList {
    
    Node head=null;
    
    //adds new node to the front of the list
    public Node appendToHead(int d)
    {
        if (head==null)
        {
            Node newNode=new Node(d);
            head=newNode;
            return head;
        }
        else
        {   
            Node newNode=new Node(d);
            newNode.next=head;
            head=newNode;
            return head;
        }
    }
    
    //adds new node to the tail of the list
    public Node appendToTail(int d)
    {
        if (head==null)
        {
            Node newNode=new Node(d);
            head=newNode;
            return head;
        }
        else
        {   
            Node newNode=new Node(d);
            Node currPtr=head;
            
            while(currPtr.next!=null)
            {
                currPtr=currPtr.next;
            }
            
            currPtr.next=newNode;
            return head;
        }
    }
    
    //Function removes duplicates in linked list
    //@Params no arguments
    //@Returns head of list
    //Algoirthm has time complexity O(n)
    public Node removeDups()
    {   
        //create hashmap to track number of times a value appears in the list
        HashMap<Integer,Integer>freq=new HashMap();
        
        //temp reference to head
        Node currPtr=head;
        
        //follower pointer to currPtr
        Node prePtr=currPtr;
        
        while(currPtr!=null)
        {   
            //if the hashmap does not contain the data value of the current node
            //add it to the hashmap
            if (!freq.containsKey(currPtr.data))
            {
                freq.put(currPtr.data,0);
                
                //set follower pointer to point to currPtr
                prePtr=currPtr;
                
                //increment currPtr to next node in list
                currPtr=currPtr.next;
            }
            //if a duplicate is found, remove it
            else
            {   
                //set prePtr to poin to currPtr's next
                prePtr.next=currPtr.next;
                
                //increment currPtr to next node
                currPtr=currPtr.next;
            }
        }
        
        return head;
    }
    
    //Function returns the kth to last elment in a singly linked list
    //@Params integer value k
    //@Returns kth item from the back of the list
    //Algorithm time complexity is O(n), but requires O(n) space 
    public Node kToLast(int k) 
    {   
        //Create a array list to copy nodes from the list
        ArrayList<Node> copy=new ArrayList();
        
        //counter to track the size of the list
        int counter=0;
        
        //temporary pointer set to point to the same thing as head pointer
        Node currPtr=head;
        
        //while we have not reached the end of the list
        //increment counter
        //copy the current node into the array list
        //increment currPtr to point to the next node
        while(currPtr!=null)
        {
            ++counter;
            copy.add(currPtr);
            currPtr=currPtr.next;
        }
        
        //Check to see if k is larger than our list or k is zero
        if(counter<k || k==0)
        {
            System.out.println("k is too large or k was entered as 0");
            return null;
        }
        
        //find index of the kth element in the array list
        //We find this by subtracting the size of the list by k
        int index=counter-k;
        
        //return the node in the array list at the calculated index
        return copy.get(index);
    }
    
    //Function deletes a node from the list that is not the first or last node
    //Also you are only given access to the node to be deleted 
    //@Params Node to be deleted
    //@Returns nothing is returned, but the list is updated
    //Algorithm has time complexity O(1)
    public void deleteMiddleNode(Node toDel)
    {   
        if (toDel==null||toDel.next==null)
        {
            System.out.println("Invalid node");
        }
 
        toDel.data=toDel.next.data;
        toDel.next=toDel.next.next;
    }
    
    //Get the node at a specific index
    //going to assume that the passed index value is in bounds with the size
    //of the list, we could add a size data member if needed
    public Node getNode(int index)
    {
        if (index<0)
        {
            throw new IllegalArgumentException("Passed a negative index");
        }
        else
        {
            Node currPtr=head;
            
            for (int i=0;i<index;++i)
            {
                currPtr=currPtr.next;
            }
            
            return currPtr;
        }
    }
    
    //Function partitions the list around the integer value x
    //@Params intger x
    //@Returns head of the new list partitioned around the value x
    public Node partition(int x)
    {   
        //Check to see if list is empty
        if (head==null)
        {   
            System.out.println("List is empty");
            return head;
        }
        
        //Create temporary reference to head
        Node currPtr=head;
        
        //Create two linked lists one for values less than integer x
        //And one for values greater than or equal to x
        LinkedList lessThanX=new LinkedList();
        LinkedList greaterThanX=new LinkedList();
        
        //While we have not reached the end of the list
        //place the values into the respective linked lists created earlier
        while(currPtr!=null)
        {
            if (currPtr.data<x)
            {   
                lessThanX.appendToHead(currPtr.data);
                currPtr=currPtr.next;
            }
            else
            {
                greaterThanX.appendToHead(currPtr.data);
                currPtr=currPtr.next;
            }
        }
        
        //combine the two lists together
        concatLists(lessThanX,greaterThanX);
        
        //return the head node
        return head;
    }
    
    //function to print our linked list
    public void printList()
    {   
        Node currPtr=head;
        
        while(currPtr!=null)
        {
            System.out.print(currPtr.data+"->");
            currPtr=currPtr.next;
        }
        System.out.println("NULL");
    }
    
    //Function returns the head of the list
    public Node getHead()
    {
        return head;
    }
    
    //Function Combines two linked lists into one list
    //Helper function for our partition function
    public LinkedList concatLists(LinkedList one,LinkedList two)
    {   
        //get head pointer of the first list
        Node currPtr=one.getHead();
        
        //get to the last node in the first list
        while(currPtr.next!=null)
        {
            currPtr=currPtr.next;
        }
        
        //connect the last node to the head of the second list
        currPtr.next=two.getHead();
        
        //set head pointer to point to the combined list
        head=one.getHead();
        
        //Return the combined list
        return this;
    }
    
    //Function adds two numbers represented as linked lists, where each node contains
    //a single digit. The digits are stored in "reverse order", such that the 1's digit
    //is at the head of the list
    //@Params head node for each list, int carry value
    //@Returns LinkedList that is the sum of the two linked lists passed
    public Node sumLists(Node a,Node b,int carry)
    {   
        //Base Case
        if (a==null && b==null && carry==0)
        {
            return null;
        }
        
        //set value equal to the carry amount
        int value=carry;
        
        //if a is not null add the value of a to value
        if(a!=null)
        {
            value+=a.data;
        }
        
        //if b is not null add the value of b to value
        if (b!=null)
        {
            value+=b.data;
        }
        
        //create a new node with the value of the second digit
        Node result=new Node(value%10);
        
        if (a!=null || b!=null)
        {
            Node next=sumLists(a==null? null:a.next,b==null? null:b.next,value>=10? 1:0);
            result.next=next;
        }
        
        head=result;
        return head;
    }
    
    //Function checks to see if the list is a palindrome
    //@Params none
    //@Returns true if the list is a palindrome, false otherwise
    //Algorithm has time complexity O(n)
    public boolean isPalindrome()
    {   
        //We will use a stack to check if our list is a palindrome
        //So instantiate a stack using defque
        Deque<Integer> stack=new ArrayDeque<Integer>();
        
        //Create a temporary pointer equal to head
        Node currPtr=head;
        
        //place all node data into the stack
        while(currPtr!=null)
        {
            stack.addFirst(currPtr.data);
            currPtr=currPtr.next;
        }
        
        //iterate over the list and popping items off the stack
        //for comparison
        currPtr=head;
        
        while(currPtr!=null)
        {
            if (currPtr.data!=stack.peekFirst())
            {
                return false;
            }
            else
            {
                currPtr=currPtr.next;
                stack.removeFirst();
            }
        }
        
        return true;
    }
    
    //Function Reverses the list
    //@Param none
    //@Returns head of the list
    
    public Node reverseList()
    {
        Node currPtr=head;
        Node prePtr=null;
        Node nextPtr=null;
        
        while (currPtr!=null)
        {
            nextPtr=currPtr.next;
            currPtr.next=prePtr;
            prePtr=currPtr;
            currPtr=nextPtr;
        }
        
        head=prePtr;
        return head;
    }
 }
