def fib(n):
    if (n<=1):
        return n

    else:
        return fib(n-1)+fib(n-2)

print("Enter n: ",end="")
n=int(input())

print(n,"-th fibonacci number = ",fib(n))
        
