/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commoninbotharray;

import static java.lang.reflect.Array.set;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kevin Lin
 */
public class CommonInBothArray {

    /**
     * @param args the command line arguments
     */
    
    //Function returns number of common integers in two arrays
    //@Param two integer arrays 
    //@Return number of integers contained in both arrays
    public static int numCommonIntegers(int a[], int b[])
    {
        
        Set<Integer> setA=new HashSet();
        Set<Integer> setB=new HashSet();
        
        for (int i=0;i<a.length;++i)
        {
            setA.add(a[i]);
        }
        
        for (int j=0;j<b.length;++j)
        {
            setB.add(b[j]);
        }
        
        Set<Integer> setIntersection=setA;
        setIntersection.retainAll(setB);
        
        return setIntersection.size();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
