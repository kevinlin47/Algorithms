/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpath;
import java.util.ArrayList;


/**
 *
 * @author Kevin Lin
 */
public class ShortestPath {

    
    //function to calculate shortest path from origin to vertix 
    //paramaters the adjacency matrix, and the weight array
    public void shortestPath(double graph[][],double weight[]) 
    {   
        //initialize every weight to 0
        for (int i=0;i<weight.length;++i) 
        {
            weight[i]=0;
        }
        
        //create vertexSet, set first entry to 0 for the origin vertex
        ArrayList<Integer> vertexSet=new ArrayList<Integer>();
        vertexSet.add(0);
        
        //copy over the first row weight values from the graph 
        //into the weight array, keeping the first entry 0 for the vertex
        for (int v=1;v<weight.length;++v)
        {
            weight[v]=graph[0][v];
           
        }
        
        
        //loop through length of weight array-1 times
        for (int j=1;j<weight.length;++j)
        {   
            double smallest=0; //hold current smallest weight
            int indexSmallest=0; //index of current smallest vertex
            boolean inSet=true; 
            
            
            while (inSet==true)
            {
                for (int i=1;i<weight.length;++i)
                {    
                        smallest=weight[i];
                        indexSmallest=i;
                    
                    
                    
                    for (int x=i+1;x<weight.length;++x)
                    {
                         
                         
                        //current smallest is larger and vertex x
                        //is not in the vertex set, change the smallest 
                        //to the value at index x in the weight array
                        if (smallest>weight[x] && !vertexSet.contains(x))
                        {
                            smallest=weight[x];
                            indexSmallest=x;

                        }
                    }
                    
                    //if the current smallest vertex is not in the 
                    //vertex set, add it in, and break from while loop
                    if (!vertexSet.contains(indexSmallest))
                    {   
                        vertexSet.add(indexSmallest);

                        inSet=false;
                        break;
                    }
                }   
                //safe check to make sure you don't loop forever
                    if(vertexSet.size()==weight.length)
                    {
                        inSet=false;
                    }
            }
            
            
            //check the weight of u for all u not in the vertex set
            //if the weight at u is larger than the path from the 
            //current smallest to u, then set weight at u to this value
            for (int u=0;u<weight.length;++u)
            {
                if (!vertexSet.contains(u))
                {
                    if (weight[u]>(weight[indexSmallest]+graph[indexSmallest][u]))
                    {
                        weight[u]=weight[indexSmallest]+graph[indexSmallest][u];
                    }
                }
            }
        }
        
    }
    
    //helper function to display the graph
    public void printGraph(double graph[][])
    {   
        double inf=Double.POSITIVE_INFINITY;
        
        for (int i=0;i<7;++i)
        {
            for (int j=0;j<7;++j)
            {   
                if (graph[i][j]==inf)
                {
                    System.out.print("\u221E"+" ");
                }
                
                else
                {
                    System.out.print((int)graph[i][j]+" ");
                }
                
            }
            System.out.println();
        }
    }
    
    //helper function to desplay the smallest weight from the origin 
    //to each vertex
    public void printWeight(double weight[])
    {   
        System.out.println("\nPrinting shortest weight from origin to weight[x]: ");
        
        for (int i=0;i<weight.length;++i)
        {       
                
               System.out.println("weight["+i+"] = "+(int)weight[i]+" ");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double graph[][]=new double [7][7]; //initialize nxn array for graph
        double weight[]=new double [7]; //array to hold weight of origin 
                                       //to each vertex
        
        for (int i=0;i<7;++i) //initialze every entry to infinity
        {
            for (int j=0;j<7;++j)
            {
                graph[i][j]=Double.POSITIVE_INFINITY;
            }
        }
        
        //set the graph values for the graph in figure 20-39 of textbook
        graph[0][1]=2;
        graph[0][2]=4;
        graph[0][3]=6;
        graph[1][2]=5;
        graph[1][4]=3;
        graph[2][3]=2;
        graph[2][4]=2;
        graph[3][2]=1;
        graph[3][4]=5;
        graph[3][5]=3;
        graph[4][2]=3;
        graph[4][5]=5;
        graph[4][6]=1;
        graph[5][4]=1;
        graph[6][5]=2;
        
        
        ShortestPath test=new ShortestPath();
        System.out.println("Graph of figure 20-39\n");
        test.shortestPath(graph, weight); 
        test.printGraph(graph);
        test.printWeight(weight);



    }
    
}
