import random

def mergesort(array, left, right):
    if left < right:
        middle = (left + right) // 2  # get middle index
        mergesort(array, left, middle)  # call merge sort of left half
        mergesort(array, middle + 1, right)  # call merge sort on right half
        merge(array, left, middle, right)  # merge the two halves

    return


def merge(array, left, middle, right):
    leftStart = left  # start of left array
    leftEnd = middle  # end of left array
    rightStart = middle + 1  # start of right array
    rightEnd = right  # end of right array

    tempArray = []

    while (leftStart <= leftEnd) and (rightStart <= rightEnd):
        if array[leftStart] > array[rightStart]:
            tempArray.append(array[rightStart])
            rightStart += 1
        else:
            tempArray.append(array[leftStart])
            leftStart += 1

    while leftStart <= leftEnd:  # copy anything leftover in the left array over
        tempArray.append(array[leftStart])
        leftStart += 1

    while rightStart <= rightEnd:  # copy anything leftover in the right array over
        tempArray.append(array[rightStart])
        rightStart += 1

    # copy temp arrary over to original array

    index = 0
    for x in range(left, right + 1):
        array[x] = tempArray[index]
        index += 1

    return


# create a test list
list = []

for i in range(0,10):
    list.append(random.randint(0, 99))

print('unsorted\n', list)

mergesort(list,0,len(list)-1)

print('\nsorted\n', list)
