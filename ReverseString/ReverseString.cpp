#include<iostream>
#include<string>
#include<stack>

int main()
{
    //string variable
    std::string sampleString;

    //stack to reverse the string easily
    std::stack <char>flip;

    //prompt user to enter a string
    std::cout<<"Enter string: ";

    //receive string input from user
    std::getline(std::cin,sampleString);


    //push each char in the string into the stack
    for (int i=0;i<sampleString.size();++i)
    {
        flip.push(sampleString[i]);
    }

    for (int i=0;i<sampleString.size();++i)
    {
        //display char at the top of the stack (LIFO)
        std::cout<<flip.top();

        //remove char at the top of the stack
        flip.pop();
    }

    return 0;

}
