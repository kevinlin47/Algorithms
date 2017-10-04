#include<iostream>

//Function evaluates a polynomial represented as an array using the Horner Method
//@Parameters integer array representing the polynomial, int n, denotes highest power, int x to evaluate
//@Returns value of polynomial evaluated with x
int horner(int poly[],int n,int x);

int main()
{
    int n=4;
    int x=2;

    int *poly=new int[n];

    //represent y(x)=6x^3+3x^2+5x+4 as a test
    poly[0]=6;
    poly[1]=3;
    poly[2]=5;
    poly[3]=4;

    //display result of y(2)
    std::cout<<horner(poly,n,x)<<std::endl;
}

int horner(int poly[],int n,int x)
{
    int result=poly[0]; //initialize result

    for (int i=1;i<n;++i)
    {
        result=result*x+poly[i];
    }

    return result;

}
