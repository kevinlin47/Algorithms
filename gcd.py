def gcd(a,b):
    x=a
    y=b

    while y!=0:
        r=x%y
        x=y
        y=r

    return x

print(gcd(81,27))
print(gcd(65,8))
print(gcd(56,49))
