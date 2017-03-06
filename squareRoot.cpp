#include<iostream>
#include<iomanip>

//Program Calculates the square root of a float number
//using The Newton-Raphson Method


 int main()
 {
    float toSquare=0;
    float initialGuess=1;
    float result=initialGuess;
    float epsilon=.00001;

    std::cout<<"Enter number:" ;
    std::cin>>toSquare;

    while (toSquare-(result*result)>epsilon || (result*result)-toSquare>epsilon)
    {
            initialGuess=.5*(initialGuess+(toSquare/initialGuess));
            result=initialGuess;


    }

    std::cout<<std::fixed<<std::setprecision(5)<<result<<std::endl;

 }
