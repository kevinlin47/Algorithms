#Find a duplicated integer in a list of 101 integers
#going  from 0 to 99, there will be only one duplicate.

#Create a list for our integers
a=[]

#add numbers 0-99 into our list
for x in range (0,100):
    a.append(x)

# Assume the duplicate value is 19
a.append(19)

sum=0
sumOfList=0;

#sum the values from 0-99

for x in range(0,100):
    sum+=x

#sum the values in the list

for x in a:
    sumOfList+=x

#the difference between the sums will be the duplicate value
print("Duplicate value in list: ",sumOfList-sum)
