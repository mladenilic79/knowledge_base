
# sequence examples (lists in this case)
variousList = ["string", 1.234, 28, "pera"]
oneToTen = list(range(10))

# You can change a list item
variousList[0] = "New String"

# slice of s from i to j is replaced by the contents of the iterable t
# oneToTen[1:3] = t
# s[i:j:k] = t

# Append a value to the end of a sequence
variousList.append("Another")

# Insert value at index: insert (index, value)
variousList.insert(5, 10)

# delete elements
del oneToTen[1:2]
oneToTen[1:2] = []

# Delete first occurrence of value
oneToTen.remove(8)

# Remove and returns item at index
# (if index not supplied than last item(index))
itemm = variousList.pop(2)

# remove all items from sequence
randomSequence = [1, 2, 3]
randomSequence.clear()
randomSequence = [1, 2, 3]
del randomSequence[:]

# Reverse a list
variousList.reverse()

# updates s with its contents repeated n times
variousList *= 2

# extends s with the contents of t
variousList.extend(oneToTen)
variousList += oneToTen
