
# iterable is is a stored sequence of values (list, tuple,..), an object with
# an __iter__ method which returns an iterator.
# An iterator is an object with a __next__ method which retrieves the next
# value from sequence of values
# you can only iterate once per iterator instanciation, to repeat you have to
# declare new instance of iter

list1 = ["string", 1.234, 28, "pera"]
tuple1 = (1, "pera", 3, 5, 8)
range1 = range(10)
string1 = "This is a very important string"
set1 = set(list1)
frozenset1 = frozenset(list1)
dict1 = dict(one=1, two=2, three=3)

# all data structurs looping in the same way
for i in list1:
    print(i)
for i in tuple1:
    print(i)
for i in range1:
    print(i)
for i in string1:
    print(i)
for i in set1:
    print(i)

# looping dict
for key in dict1:
    print(key, dict1[key])
for i, j in dict1.items():
    print(i, j)

# for creating iterator use iter or reversed
iterList1 = iter(list1)
iterList2 = reversed(list1)

# all data structures iterate the same
iterTuple = iter(tuple1)
iterRange = iter(range1)
iterString = iter(string1)
iterSet = iter(set1)
iterSetF = iter(frozenset1)
iterDict1 = iter(dict1)
# or
iterDict2 = iter(dict1.keys())

# call, returns default value instead of error if given
nextElement1 = next(iterList1)
nextElement2 = next(iterList1, "default value")
