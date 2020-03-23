
# this do not apply to frozenset just to set

# example sequences and sets
list1 = [1, 2, 3]
set1 = set(list1)
set2 = set(list1)
set3 = set(list1)

# Update the set, adding elements from all others
updatedSet = set1.update(set2, set3)

# Update the set, keeping only elements found in it and all others
updatedSetIntersection = set1.intersection_update(set2, set3)

# Update the set, removing elements found in others
updatedSetDifference = set1.difference_update(set2, set3)

# Update the set, keeping only elements found in either set, but not in both
updatedSetSymmetricDifference = set1.symmetric_difference_update(set2)

# Add element elem to the set
set1.add("pera")

# Remove element elem from the set
set1.remove(3)

# Remove element elem from the set
set1.discard(2)

# Remove and return an arbitrary element from the set
element1 = set1.pop()

# Remove all elements from the set
set1.clear()
