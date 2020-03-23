
# example list
exampleList = [1, 2, 3, 4, 5]

# ---------- CREATING ----------

# constructors
dictionaryA = dict(one=1, two=2, three=3)
dictionaryB = {'one': 1, 'two': 2, 'three': 3}
dictionaryC = dict(zip(['one', 'two', 'three'], [1, 2, 3]))
dictionaryD = dict([('two', 2), ('one', 1), ('three', 3)])
dictionaryE = dict({'three': 3, 'one': 1, 'two': 2})
if dictionaryA == dictionaryB == dictionaryC == dictionaryD == dictionaryE:
    print()

# ---------- GENERAL METHODS ----------

# Dictionaries may print out in order created since they are unordered
# print(dictionaryA)

# dictionery length
dictLength = len(dictionaryA)

# returns shallow copy of a dictionary
newDictionary1 = dictionaryA.copy()

# returns copy with value set to specified
newDictionary2 = dict.fromkeys(exampleList, "default value")

# Update dictionary with data from other overwriting existing keys
dictionaryA.update(dictionaryD)

# zip method
a = ("John", "Charles", "Mike")
b = ("Jenny", "Christy", "Monica")
a = ["John", "Charles", "Mike"]
b = ["Jenny", "Christy", "Monica"]
zip_iterator_object = zip(a, b)
x = list(zip_iterator_object)
y = tuple(zip_iterator_object)
z = dict(zip_iterator_object)

# ---------- KEYS ----------

# returns all keys
keysList = list(dictionaryA)

# check for key
isKeyInDict1 = "one" in dictionaryA
isKeyInDict2 = "one" not in dictionaryA

# Add a new key value pair
dictionaryA['city'] = 'Pittsburgh'

# remove key from dictionary
del dictionaryA["three"]

# removes all items from dictionary
dictionaryB.clear()

# remove and returns value else returns default
item1 = dictionaryE.pop("two")
item2 = dictionaryE.pop("seven", "default value")

# remove and return key value pair (tuple)
tuplePair1 = dictionaryC.popitem()

# If key is in the dictionary, return its value. If not, insert key
# with a value of default and return default. default defaults to None
item3 = dictionaryD.setdefault("one")
item4 = dictionaryD.setdefault("four", "default value")

# ---------- VALUES ----------

# returns item
specifiedItem = dictionaryA["one"]

# returns value for specified key, else default
value1 = dictionaryA.get("one")
value2 = dictionaryA.get("seven", "default value")

# set new value for item
dictionaryA["one"] = 5

# ---------- DYNAMIC VIEWS ----------

# dynamic view on the dictionary’s entries, which means that
# when the dictionary changes, the view reflects these changes
keys1 = dictionaryA.keys()
values1 = dictionaryA.values()
items1 = dictionaryA.items()

# operation over views
lengthh = len(keys1)
isXInView = 1 in items1
iterator3 = iter(values1)
iterator4 = reversed(values1)
