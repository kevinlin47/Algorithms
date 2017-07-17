#include<iostream>
#include<random>
#include<time.h>
#include<vector>

//function prototype
void quickSort(std::vector<int>&,int,int);

int main()
{
    srand(time(NULL));
    std::vector<int> toSort(6);

    //fill vector with random values
    for (int i=0;i<toSort.size();++i)
    {
        toSort[i]=rand()%99+1;
    }

    std::cout<<"Unsorted Vector"<<std::endl;

    for (int i=0;i<toSort.size();++i)
    {
        std::cout<<toSort[i]<<" ";
    }

    std::cout<<"\n\nSorted Vector"<<std::endl;

    quickSort(toSort,0,toSort.size()-1);

    for (int i=0;i<toSort.size();++i)
    {
        std::cout<<toSort[i]<<" ";
    }

}

//function sorts (ascending order) a given integer vector using quick sort algorithm
//@parameters integer vector,vector index starting point, vector index ending point
void quickSort(std::vector<int> &toSort,int left,int right)
{
        //choose the pivot as the middle value in the vector
        int pivot=toSort[(left+right)/2];

        //place value of left and right, int two temp integer variables
        //to preserve these values
        int i=left;
        int j=right;

        //partition the vector around the chosen pivot value
        while(i<=j)
        {
            //find index of integer greater than pivot
            while(toSort[i]<pivot)
            {
                ++i;
            }

            //find index of integer less than the pivot
            while(toSort[j]>pivot)
            {
                --j;
            }

            //if i is less than j, then a number is out of place, and a swap is performed
            if (i<=j)
            {
                int temp=toSort[i];
                toSort[i]=toSort[j];
                toSort[j]=temp;
                ++i;
                --j;
            }
        }

            //sort left side
            if (left<j)
            {
                quickSort(toSort,left,j);
            }

            //sort right side
            if (i<right)
            {
                quickSort(toSort,i,right);
            }
}

