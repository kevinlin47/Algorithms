#include<iostream>
#include<climits>
#include<time.h>
#include<random>

//function prototype
int kadaneAlgo(int [],int);

int main()
{
    srand(time(NULL));

    //initialize int array
    int sampleArray[8];

    //add random values to the array
    for (int i=0;i<8;++i)
    {
        int randomNum=rand()%20+(-10);
        sampleArray[i]=randomNum;
    }

    std::cout<<"Sample array to use:"<<std::endl;

    //print array to user
    for (int i=0;i<8;++i)
    {
        std::cout<<sampleArray[i]<<" ";
    }

    std::cout<<"\n\nLargest sub-array sum = "<<kadaneAlgo(sampleArray,8);
    std::cout<<std::endl;

    return 0;

}

//@param int array, int size of array
//@return largest sub array sum
int kadaneAlgo(int a[], int size)
{
    //Max of sub array at iteration point
    int max_ending_here=0;

    //Largest sub array sum currently
    int max_so_far=INT_MIN;

    //loop through the whole array
    for (int i=0;i<size;++i)
    {
        //add array at index i to the current maximum at the iteration point
        max_ending_here+=a[i];

        //If the max ending here is larger than the current max, set max_so_far to max_ending here
        if (max_so_far<max_ending_here)
        {
            max_so_far=max_ending_here;
        }

        //set the max_ending_here to 0 if the sum at the iteration becomes zero
        if (max_ending_here<0)
        {
            max_ending_here=0;
        }
    }

    return max_so_far;
}
