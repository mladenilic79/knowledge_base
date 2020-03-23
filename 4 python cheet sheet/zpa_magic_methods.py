
# We can use magic methods to define how operators like +, -, *, /, ==, >, <,
# will work with our custom objects (operator overloading)

# __eq__ : Equal
# __ne__ : Not Equal
# __lt__ : Less Than
# __gt__ : Greater Than
# __le__ : Less Than or Equal
# __ge__ : Greater Than or Equal
# __add__ : Addition
# __sub__ : Subtraction
# __mul__ : Multiplication
# __div__ : Division
# __mod__ : Modulus
# __len__ : Length
# __repr__ : return description of an object
# __str__ : return description of an object but more readable
# __dict__ : returns namespace of an object or a class

# Magic methods can be overwritten
# def __repr__(self):
#     return # make custom return

# calling magic methods (put in main)
# print(repr(instance))
# print(str(instance))
# is the same as
# print(class1.__repr__())
# print(class1.__str__())
