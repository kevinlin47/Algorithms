/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Lin
 */
public class BubbleSort {
    
    //@param integer array
    //@return sorted array 
    public void bubbleSort(int toSort[])
    {
        int size=toSort.length-1;
        
        //iterate through the whole array-1
        for (int i=0;i<toSort.length-1;++i)
        {   
            for (int j=0;j<size;++j)
            {   
                //If the value index j is larger than the value at j+1
                //swap them
                if (toSort[j]>toSort[j+1])
                {
                    int temp=toSort[j];
                    toSort[j]=toSort[j+1];
                    toSort[j+1]=temp;
                }
                else
                {
                    //Do nothing
                }
                
            }
            //decrement size, because one less comparison is needed
            --size;
        }
    }
    
    public static void main (String [] args)
    {   
        //Initialze integer array
        int array[]=new int [10];
        
        //Add random values from 1 to 99 into the array
        for (int i=0;i<array.length;++i)
        {
            array[i]=(int)(Math.random()*99)+1;
        }
        
        //Print array to sort
        for (int i=0;i<array.length;++i)
        {
            System.out.print(array[i]+" ");
        }
        
        //print new line
        System.out.println("");
        
        //create instance to call instance method
        BubbleSort bubble=new BubbleSort();
        //callc bubble sort function on the array
        bubble.bubbleSort(array);
        
        //Print sorted array
        for (int i=0;i<array.length;++i)
        {
            System.out.print(array[i]+" ");
        }
    }
}
