
# Filter selects items from a list based on a function

# list
oneTo10 = list(range(1, 11))
print(oneTo10)

# Print out the even values from a list
evenList = list(filter((lambda x: x % 2 == 0), oneTo10))
print(evenList)
