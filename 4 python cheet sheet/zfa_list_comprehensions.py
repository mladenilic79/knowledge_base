
# A list comprehension executes an expression against an iterable
# list comprehension is surrounded by [] because it returns a list
# A list comprehension can act as map and filter on one line

rangeList = list(range(1, 11))
fixedList = [1, 2, 3, 4, 5]

# Perform an operation on each item in the list
listt = [x * 2 for x in rangeList]
listt2 = [x for x in range(1, 11) if x % 2 != 0]

# list of lists (multidimensional list)
multiList = [[m * 2, m * 3, m * 4] for m in fixedList]

# You can have multiple for loops as well
# Multiply all values in one list times all values in another
multipleFor = [x * y for x in range(1, 3) for y in range(11, 16)]

# You can put list comprehensions in list comprehensions
nestedComprehension = [x * 3 for x in [i * 2 for i in range(10)] if x % 4 == 0]
