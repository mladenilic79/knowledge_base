
# basic function, argument and default argument
def add_numbers(num_1, num_2=1, num_3=1):

    # docstring first string inside method that can be called with
    # method_name.__doc__
    """ this is docstring """

    # Return returns a value if needed else it will return none
    return num_1 + num_2 + num_3

# call method
print("add numbers ", add_numbers(1))
print("add numbers ", add_numbers(1, 2))
print("add numbers ", add_numbers(1, 2, 3))
print("add numbers ", add_numbers(1, num_3=5))
# call docstring
print("docstring: " + add_numbers.__doc__)

# rename/reassign function
add_two_numbers = add_numbers
