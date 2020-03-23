
# Generator expressions look just like list comprehensions
# but they return results one at a time
# The are surrounded by parentheses instead of [ ]

double = (x * 2 for x in range(10))

# return one at a time
print("Double :", next(double))
print("Double :", next(double))
