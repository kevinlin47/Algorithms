from random import randint

myList=[]

for x in range(0,10):
    a=randint(0,99)
    myList.append(a)

print("Unsorted Array:")
print(myList)

#Insertion sort algorithm

for x in range(1,len(myList)):
    j=x
    while j>0 and myList[j]<myList[j-1]:
        temp=myList[j]
        myList[j]=myList[j-1]
        myList[j-1]=temp
        j-=1

print("Sorted Array")
print(myList)
