#function calculates factorial of n using iteration
def fact(n):
    result=n;
    for x in range(1,n):
        result=result*(n-1)
        n=n-1

    return result

#Get user input
n=int(input("Enter number to calculate:"))

print(fact(n),end='')
        
