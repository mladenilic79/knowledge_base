
# Map allows us to execute a function on each item in a list

# list
oneTo10 = list(range(1, 11))
print(oneTo10)

# The function to pass into map
def dbl_num(num):
    return num * 2

# Pass in the function and the list to generate a new list
newList = list(map(dbl_num, oneTo10))
print(newList)

# You could do the same thing with a lambda
newList = list(map((lambda x: x * 2), oneTo10))
print(newList)

# You can perform calculations against multiple lists
bList = list(map((lambda x, y: x + y), [1, 2, 3], [1, 2, 3]))
print(bList)
