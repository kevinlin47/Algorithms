#include<iostream>
#include<math.h>

bool isPrime(int);

int main()
{
    int numCases=0;
    int test=0;

    std::cin>>numCases;
    std::cout<<"Test Cases"<<std::endl;

    for (int i=0;i<numCases;++i)
    {
        std::cin>>test;
        if (isPrime(test))
        {
            std::cout<<test<<" is prime"<<std::endl;
        }
        else
        {
            std::cout<<test<<" is not prime"<<std::endl;
        }
    }

}

//Function to check if a given integer is prime
//@Parameters integer
//@returns boolean
bool isPrime(int toCheck)
{
    //Calculate the square root of the number to check
    int loopLimit=sqrt(toCheck);

    //check if the number passed is 1
    if (toCheck==1)
    {
        return true;
    }

    //loop up to the calculated square root
    for (int i=2;i<=loopLimit;++i)
    {
        //if the number modulo i equals 0, then the number is not prime, and return false
        if (toCheck%i==0)
        {
            return false;
        }
    }

    //return false, since the loop ended
    return true;

}
