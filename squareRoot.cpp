#include<iostream>
#include<iomanip>

//Program Calculates the square root of a float number
//using The Newton-Raphson Method


 int main()
 {
    float toSquareRoot=0;
    float initialGuess=1;
    float result=initialGuess;
    float epsilon=.00001;

    std::cout<<"Enter number:" ;
    std::cin>>toSquareRoot;

    if (toSquareRoot<0)
    {
        std::cout<<"ERROR: Entered a negative number"<<std::endl;
        return 0;
    }

    while (toSquareRoot-(result*result)>epsilon || (result*result)-toSquareRoot>epsilon)
    {
            initialGuess=.5*(initialGuess+(toSquareRoot/initialGuess));
            result=initialGuess;


    }

    std::cout<<std::fixed<<std::setprecision(5)<<result<<std::endl;

 }
