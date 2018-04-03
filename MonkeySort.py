import random

def isSorted(data):
    for i in range(0,len(data)-1):
        if data[i]>data[i+1]:
            return False
    return True

def monkeysort(data):
    while not isSorted(data):
        random.shuffle(data)

data=[1,19,3,27,1995,5]

monkeysort(data)
print(data)
    
