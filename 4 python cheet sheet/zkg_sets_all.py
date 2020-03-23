
# set objects are an unordered collection of distinct hashable objects
# set is mutable (has no hash value)
# frozen set is immutable (has hash value)

# example iterable
list1 = [1, 2, 3]

# constructors
# set = set(iterable)
# frozenset = frozenset(iterable)
set1 = set(list1)
frozenset1 = frozenset(list1)
frozenset2 = frozenset(list1)

# returns length of set
lengthh = len(set1)

# You can see if a set contains or not an item
isContain = "string" in set1
isNotContain = "string" not in set1

# Return a shallow copy of the set
copy1 = set1.copy()

# Sets are disjoint if their intersection is the empty set
isDisjoint = set1.isdisjoint(frozenset1)

# Test whether every element in the set is in other
isSubset = set1.issubset(frozenset1)
isSuperset = set1.issuperset(frozenset1)

# Return a new set with elements from the set and all others
unionSet1 = set1.union(frozenset1)
unionSet2 = set1.union(frozenset1, frozenset2)

# Return a new set with elements common to the set and all others
intersectionSet1 = set1.intersection(frozenset1)
intersectionSet2 = set1.intersection(frozenset1, frozenset2)

# Return a new set with elements in the set that are not in the others
differenceSet1 = set1.difference(frozenset1)
differenceSet2 = set1.difference(frozenset1, frozenset2)

# Return a new set with elements in either the set or other but not both
symmetric_difference1 = set1.symmetric_difference(frozenset1)
