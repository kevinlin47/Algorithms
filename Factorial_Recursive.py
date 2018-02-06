#function to calculate factorial of n using recursion
def fact(n):
    if n==1 or n==0:
        return 1
    else:
        return n*fact(n-1)

#Get user input
n=int(input("Enter number to calculate:"))

print(fact(n))
