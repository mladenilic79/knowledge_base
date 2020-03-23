
# Reduce receives list and returns single result (can be used instead of loop)
from functools import reduce

# list
oneTo10 = list(range(1, 11))
print(oneTo10)

# Add up the values in a list
result = reduce((lambda x, y: x + y), oneTo10)
print(result)
