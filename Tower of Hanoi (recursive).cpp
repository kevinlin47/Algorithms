#include<iostream>
#include<string>

using namespace std;

int moves=0; //Global variable to keep track of the amount of moves.
int call=0;  //Global variable to keep track the number of function calls;
void solveTower(int n,string source, string destination, string spare); //function prototype.

int main()
{
    string source="Pole A";
    string destination="Pole B";
    string spare="Pole C";
    int n; //Number of disks.

    cout<<"Enter number of disks:  "; //Asks the user for the number of disks.
    cin>>n;

    solveTower(n,source,destination,spare); //Solves the tower using the desired number of disks.
    cout<<"Number of moves required for "<<n<<" disks is "<<moves<<endl; //displays the number of moves required to solve the tower
                                                                         //for a specific number of disks.
    cout<<"The amount of function calls: "<<call+1; //displays number of times function was called.
}

void solveTower(int n,string source, string destination, string spare)
{

    if (n==1) //base case.
    {
        cout<<"Move top disk from "<<source<<" to "<<destination<<endl; //Display actions required to solve.
        ++moves;
    }

    else
    {
    solveTower(n-1,source,spare,destination);
    ++call;
    solveTower(1,source,destination,spare);
    ++call;
    solveTower(n-1,spare,destination,source);
    ++call;
    }

}
