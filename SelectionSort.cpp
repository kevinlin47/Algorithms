#include<iostream>
#include<random>
#include<time.h>
#include<vector>

std::vector<int> selectionSort(std::vector<int>); //function prototype, for selection sort
void print(std::vector <int>); //function prototype for array printing

int main()
{
    std::vector <int>toSort(10); //declare integer vector size 10
    srand(time(NULL)); //seed using clock time

    //fill vector with random numbers
    for (int i=0;i<10;++i)
    {
        int randomNumber=rand()%99+1;
        toSort[i]=randomNumber;
    }

    //display random unsorted vector to user
    std::cout<<"Unsorted:"<<std::endl;
    print(toSort);

    std::cout<<"\nSorted:"<<std::endl;
    //assign returned sorted vector to a new vector
    std::vector<int>sorted=selectionSort(toSort);

    //print sorted vector
    print(sorted);

    return 0;

}

//printing vector function
//@param int vector
//@return none
void print(std::vector<int> toSort)
{
    for (int i=0;i<toSort.size();++i)
    {
        std::cout<<toSort[i]<<" ";
    }

}

//Selection Sort function
//@param int vector
//@return sorted vector
std::vector<int> selectionSort(std::vector<int> toSort)
{
    int min=0; //create variable to hold min value index in vector

    //nested for loops, we loop vector size -1 because we need one less comparison
    for (int i=0;i<toSort.size()-1;++i)
    {
        min=i; //set min number index i
        for (int j=i+1;j<toSort.size();++j)
        {
            if (toSort[min]>toSort[j])
            {
                min=j;
            }
        }
        //swap the smallest number with the number at index i
        int temp=toSort[i];
        toSort[i]=toSort[min];
        toSort[min]=temp;
    }

    return toSort;


}
