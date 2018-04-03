import random

def isSorted(data):
    for i in range(0,len(data-1)):
        if data[i]>data[i+1]:
            return False
    return True


    
