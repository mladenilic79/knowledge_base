
# ---------- CMD ----------

# py #enter python
# exit() or quit() #exit python

# ---------- CHECK PYTHON VERSION ----------
import sys
print(sys.version_info)

# ---------- COMMENTS ----------
# Single line comments are ignored by the interpreter
'''
So are multiline comments
'''

# ---------- IMPORTS/MODULES ----------
# you will create many modules in separate files. Modules also end with .py
# When you use import you access methods by referencing the module

# ————— aadd.py —————
def aadd(a, b):
    return a + b
# ————— End of aadd.py —————


# You can import by listing the file name minus the py
# import aadd

# Get access to functions by proceeding with the filename and then the function
# print("Sum :", aadd.aadd(1, 2))

# You can use from to copy specific functions from a module
# You can use from sum import * to import all functions
# You can import multiple functions by listing them separated by commas

# from aadd import aadd
# from aadd import *
# from aadd import aadd, mult

# We create an alias to avoid conflicts with methods with the same name
# from decimal import Decimal as D

# You don't have to reference the module name now
print("Sum :", aadd(1, 2))

# ---------- VARIABLES ----------
# Variable names start with a letter or _ and then can contain numbers
# Names are case sensitive so name is not the same as Name

# You can't use the following for variable names: and, del, from, not, while,
# as, elif, global, or, with, assert, else, if, pass, yield, break, except,
# import, print, class, exec, in, raise, continue, finally, is, return, def,
# for, lambda, try

# ---------- INPUT ----------
name = input('What is your name? ')

# input raw values and store them in variables & split using whitespace
num1, num2, num3 = input('Enter 3 numbers : ').split()

# eval() executes code in itself (for importing posible code)
num3 = eval(num3)

# ---------- OUTPUT ----------
print('Hello ', name)

# end="" means a newline won't be added (unlike println in java)
print('Hello ', name, end="")
print()  # add another print to interrupt previous end=""

# sep='' insert separator beetween strings (09-12-2016)
print('09', '12', '2016', sep='-')

# format() loads the variable values in order into the {} placeholders
print("{} + {} = {}".format(num1, num2, num3))

# optional positional & keywords arguments
print("{0} + {1} + {name} = {2}".format(num1, num2, num3, name="jim"))

# We can define how many decimals are printed
# being 2 here by putting :.2 before f
print("Rounded to 2 decimals : {:.2f}".format(2.4567))

# ---------- TYPE ----------
# You can use type to see the data type of a value
print(type(name))

# Convert strings into integers
num1, num2 = int(num1), int(num2)

# We can convert a string into a float
num1 = float(num1)

# Convert an int/float into a string
num_string = str(4.3)

# ---------- BASIC MATH ----------
sums = num1 + num2
difference = num1 - num2
product = num1 * num2
quotient = num1 / num2
# Use modulus on the values to find the remainder
remainder = num1 % num2

# Floating point numbers are numbers with decimal values
# Floats are precice up to 16 digits of precision

# rounding to closer at 2 decimal places
print("round(4.6) = ", round(4.6, 2))

# ---------- ACCURATE FLOATING POINT CALCULATIONS ----------
# The decimal module provides for more accurate floating point calculations
from decimal import Decimal as Dec

sumss = Dec(0)
sumss += Dec("0.05")
sumss -= Dec("0.03")
print("Sum = ", sumss)

# ---------- MATH ----------
import math

# rounding
print("ceil(4.4) = ", math.ceil(4.4))
print("floor(4.4) = ", math.floor(4.4))

# rounding number positive & negative closer to zero
print("trunc(4.2) = ", math.trunc(4.2))

# absolute value
print("fabs(-4.4) = ", math.fabs(-4.4))

# Return remainder of division
print("fmod(5,4) = ", math.fmod(5, 4))

# Factorial = 1 * 2 * 3 * 4
print("factorial(4) = ", math.factorial(4))

# Return x^y
print("pow(2,2) = ", math.pow(2, 2))

# Return the square root
print("sqrt(4) = ", math.sqrt(4))

# Return e^x
print("exp(4) = ", math.exp(4))

# Return the natural logarithm e * e * e ~= 20 so log(20) tells
# you that e^3 ~= 20
print("log(20) = ", math.log(20))

# You can define the base and 10^3 = 1000
print("log(1000,10) = ", math.log(1000, 10))

# You can also use base 10 like this
print("log10(1000) = ", math.log10(1000))

# We have the following trig functions
# sin, cos, tan, asin, acos, atan, atan2, asinh, acosh,
# atanh, sinh, cosh, tanh

# Convert radians to degrees and vice versa
print("degrees(1.5708) = ", math.degrees(1.5708))
print("radians(90) = ", math.radians(90))

# Special values
print("math.e = ", math.e)
print("math.pi = ", math.pi)

# ---------- RANDOM NUMBERS ----------
import random
# Generate a random integer between 1 and 50
rand_num = random.randrange(1, 51)

# ---------- OPERATORS ----------
# basic conditional operators
# If, else if (elif) and else

# Other conditional operators
# > : Greater than
# < : Less than
# >= : Greater than or equal to
# <= : Less than or equal to
# != : Not equal to

# Logical operators
# and : If both are true it returns true
# or : If either are true it returns true
# not : Converts true into false and vice versa

if (num1 >= 1) and (num2 <= 18):
    print("Important Birthday")
elif (num1 == 21) or (num2 == 50):
    print("Important Birthday")
elif not num1 < 65:
    print("Important Birthday")
else:
    print("Sorry Not Important")

# ---------- FOR LOOP ----------
llist = [2, 4, 6, 8, 10]
lllist = []

for i in llist:
    print("i = ", i)

# We can also have range define our list for us. range(10) will create a list
# starting at 0 and go up to but not include the value passed to it.
for i in range(10):
    print("i = ", i)

# We can define the starting and ending value for range
for i in range(2, 10):
    print("i = ", i)

# take various elements (every second element)
for i in range(0, len(name) - 1, 2):
    print("i ", i, name[i], name[i + 1])

# define with len()
for i in range(len(llist)):
    print(llist[i])
    lllist.append(i)

for char in name:
    print("char = ", char)

# ---------- THE WHILE LOOP ----------
# We can also continue looping as long as a condition is true with a while loop
# While loops are used when you don't know how many times you will have to loop

# The value we increment in the while loop is defined before the loop
i = 1
# Define the condition that while true we will continue looping
while i != rand_num:
    # You must increment your iterator inside the while loop
    i += 1

# ---------- BREAK AND CONTINUE ----------
i = 1
while i <= 20:
    # If number is even don't print it (skip rest of the code continue looping)
    if (i % 2) == 0:
        i += 1
        continue
    # If i equals 15 stop looping (get out of the loop)
    if i == 15:
        break
    i += 1

# ---------- DO WHILE LOOP - IMPLEMENTATION ----------
# By giving the while a value of True it will cycle until a break is reached
while True:
    guess = int(input("Guess a number between 1 and 3 : "))
    if guess == num1:
        print("You guessed it")
        break


# ---------- MAIN FUNCTION ----------
def main():
    print()


# All of the other function definitions are ignored and this calls for main()
main()

# if there is a code that you only want to run if it's a main file put at the
# end of file, because if imported __name__ will not be __main__
if __name__ == "__main__":
    main()


# ---------- FUNCTION BASICS ----------
# basic function
def add_numbers(num_1, num_2):
    # Return returns a value if needed else it will return none
    return num_1 + num_2


print("5 + 4 =", add_numbers(5, 4))

# rename/reassign function
add_two_numbers = add_numbers
print("5 + 4 =", add_two_numbers(5, 4))


# pass function into another function
def high_func(low_func, num4, num5):
    return low_func(num4, num5)


print("solution is: ", high_func(add_numbers, 4, 5))


# pass value & return value from another function
def get_func_mult_by_num(num):
    def mult_by(value):
        return num * value
    return mult_by


generated_func = get_func_mult_by_num(5)
print("5 * 10 =", generated_func(10))  # nije mi jasno kako pasuje vrednost u
#  ovu funkciju

# can be embeded in data structures
listOfFuncs = [add_numbers, generated_func]
print("5 * 9 =", listOfFuncs[1](9))

# ---------- LOCAL / GLOBAL VARIABLES ----------
gbl_name = "Sally"
print(gbl_name)
# Any variable defined inside of a function is available only in that function
# You can't change a global variable even if it is passed into a function


# If you want to change global variable through function pass it back
def change_name():
    return "Mark"


gbl_name = change_name()


# or You can also use the global statement to change it
def change_name_2():
    global gbl_name  # declare global variable inside the function
    gbl_name = "Sammy"


change_name_2()


# ---------- RETURN MULTIPLE VALUES ----------
# You can return multiple values with the return statement
def mult_divide(num_1, num_2):
    return (num_1 * num_2), (num_1 / num_2)


mult, divide = mult_divide(5, 4)


# ---------- UNKNOWN NUMBER OF ARGUMENTS ----------
# We can receive an unknown number of arguments using the splat (*) operator
def sum_all(*args):
    sumsss = 0
    for m in args:
        sumsss += m
    return sumsss


# ---------- RECURSIVE FUNCTIONS ----------
# A function that refers to itself is a recursive function
def factorial(num):
    # recursive function must contain a condition when it ceases to call itself
    if num <= 1:
        return 1
    else:
        result = num * factorial(num - 1)
        return result


print(factorial(4))

# 1st : result = 4 * factorial(3) = 4 * 6 = 24
# 2nd : result = 3 * factorial(2) = 3 * 2 = 6
# 3rd : result = 2 * factorial(1) = 2 * 1 = 2


# ---------- EXAMPLE : FIBONACCI NUMBERS ----------
# To calculate Fibonacci numbers we sum the 2 previous values to calculate
# the next item in the list like this 1, 1, 2, 3, 5, 8 ...

# The Fibonacci sequence is defined by:
# Fn = Fn-1 + Fn-2
# Where F0 = 0 and F1 = 1

# print(fib(4))
# 1st : result = fib(3) + fib(2) : 3 + 2
# 2nd : result = (fib(2) + fib(1)) + (fib(1) + fib(0)) : 2 + 1
# 3rd : result = (fib(1) + fib(0)) + fib(0) : 1 + 0

def fib(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        result = fib(n - 1) + fib(n - 2)
        return result


print(fib(4))


# ---------- FUNCTION ANNOTATIONS ----------
# It is possible to define the data types of attributes and the returned
# value with annotations, but they have no impact on how the function
# operates, but instead are for documentation

# define attribute types and annotation return type
def random_func(name: str, age: int, weight: float) -> str:
    print("Name :", name)
    print("Age :", age)
    print("Weight :", weight)
    return "{} is {} years old and weighs {}".format(name, age, weight)


print(random_func("Derek", 41, 165.5))

# You don't get an error if you pass bad data
# print(random_func(89, "Derek", "Turtle"))

# You can print the annotations
print(random_func.__annotations__)

# ---------- ANONYMOUS FUNCTIONS : LAMBDA ----------
# lambda is like def, but rather then assign the function to a name it just
# returns it. You can however assign a lambda function to a name.

# This is their format
# lambda arg1, arg2,... : expression using the args

# lambdas are used when you need a small function, but don't want to junk up
# your code with temporary function names that may cause conflicts

sum = lambda x, y: x + y
print("Sum :", sum(4, 5))

# Use a ternary operator to see if someone can vote
can_vote = lambda age: True if age >= 18 else False
print("Can Vote :", can_vote(16))

# Create a list of functions
powerList = [lambda x: x ** 2,
             lambda x: x ** 3,
             lambda x: x ** 4]
# Run each function on a value
for func in powerList:
    print(func(4))

# You can also store lambdas in dictionaires
attack = {'quick': (lambda: print("Quick Attack")),
          'power': (lambda: print("Power Attack")),
          'miss': (lambda: print("The Attack Missed"))}
attack['quick']()

# You could get a random dictionary as well
import random
# keys() returns an iterable so we convert it into a list
# choice() picks a random value from that list
attackKey = random.choice(list(attack.keys()))
attack[attackKey]()

# ---------- FORCE USER TO ENTER A VALUE / EXCEPTIONS ----------
# If we expect an error can occur surround potential error with try block
while True:
    try:
        number = int(input("Please enter a number : "))
        # break should be here
    # You can catch multiple exceptions by separating them
    # with commas inside parentheses
    # except (IndexError, NameError):
    except ValueError:
        print("You didn't enter a number")
    # We can use as to access data and methods in the exception class
    except FileNotFoundError as ex:
        print("That file was not found")
        # Print out further data on the exception
        print(ex.args)
    # If the exception wasn't caught above this will
    # catch all others (put exeptions in order)
    except:
        print("An unknown error occurred")
    # else is only executed if no exception was raised
    else:
        print("You didn't raise an exception")
    finally:
        print("I execute no matter what")
        break  # break should be in second line


# ---------- CUSTOM EXCEPTIONS ----------
# Create a class that inherits from Exception
class DogNameError(Exception):
    def __init__(self, *args, **kwargs):
        Exception.__init__(self, *args, **kwargs)


try:
    dogName = input("What is your dogs name : ")
    if any(char.isdigit() for char in dogName):
        # Raise your own exception
        raise DogNameError
        # You can raise the built in exceptions as well
        # raise NameError
except DogNameError:
    print("Your dogs name can't contain a number")

# ---------- STRINGS ----------
# Single or double quotes are both used for strings
samp_string = "This is a very important string"
samp_string2 = 'This is a very important string'

# Get the string length
print("Length :", len(samp_string))

# You can get a character by referencing an index
print(samp_string[0])

# Get the last character
print(samp_string[-1])

# Get the last character
print(samp_string[3 + 5])

# Get a slice by saying where to start and end
# The 4th index isn't returned
print(samp_string[0:4])

# Get everything starting at an index
print(samp_string[8:])

# Get everything ending at an index
print(samp_string[:4])

# Join or concatenate strings with +
print("Green " + "Eggs")

# Repeat strings with *
print("Hello " * 5)

# Computers assign characters with a number known as a Unicode
# A-Z have the numbers 65-90 and a-z 97-122

# You can get the Unicode code with ord()
print("A =", ord("A"))

# You can convert from Unicode with chr
print("65 =", chr(65))

# ---------- STRING METHODS ----------

# Delete whitespace on left/right/both
samp_string = samp_string.lstrip()
samp_string = samp_string.rstrip()
samp_string = samp_string.strip()

# Capitalize the 1st letter
print(samp_string.capitalize())
# Capitalize every letter
print(samp_string.upper())
# lowercase all letters
print(samp_string.lower())

# Turn a list into a string (separate items with the defined separator)
a_list = ["Bunch", "of", "random", "words"]
print(" ".join(a_list))

# Convert a string into a list
a_list_2 = samp_string.split()

# Count how many times a string occurs in a string
print("How many is :", samp_string.count("is"))

# Get index of matching string
print("Where is string :", samp_string.find("string"))

# Replace a substring
print(samp_string.replace("an ", "a kind of "))

# Returns True if characters are letters or numbers, Whitespace is false
print("Is z a letter or number :", samp_string.isalnum())

# Returns True if characters are letters
print("Is z a letter :", samp_string.isalpha())

# Returns True if characters are numbers (Floats are False)
print("Is 3 a number :", samp_string.isdigit())

# Returns True if all are lowercase/uppercase
print("Is z a lowercase :", samp_string.islower())
print("Is z a uppercase :", samp_string.isupper())

# Returns True if all are spaces
print("Is space a space :", samp_string.isspace())


# ---------- MAKE A isfloat FUNCTION ----------
def isfloat(str_val):
    try:
        # If the string isn't a float float() will throw a ValueError
        float(str_val)
        return True
    except ValueError:
        return False


# ---------- LISTS ----------
# By default the 1st item in a list has the index 0
# Python lists can grow in size and can contain data of any type
randList = ["string", 1.234, 28, "pera"]

# Create a list with range
oneToTen = list(range(10))

numList = []
for i in range(5):
    numList.append(random.randrange(1, 9))

# Combine lists
randList = randList + oneToTen

# Get the length
print("List Length :", len(randList))

# You can change a list item
randList[1] = "New String"

# Get the item with an index
print(randList[0])

# Slice a list to get 1st 3 items
first3 = randList[0:3]

# You can repeat a list item with *
print(first3[0] * 3)

# Cycle through the list and print the index
for i in first3:
    print("{} : {}".format(first3.index(i), i))

# You can see if a list contains an item
print("string" in first3)

# You can get the index of a matching item
print("Index of string :", first3.index("string"))

# Find out how many times an item is in the list
print("How many strings :", first3.count("string"))

# Append a value to the end of a list
first3.append("Another")

# Sort a list
numList.sort()

# Reverse a list
numList.reverse()

# Insert value at index: insert (index, value)
numList.insert(5, 10)

# Delete first occurrence of value
numList.remove(10)

# Remove and returns item at index (if index not supplied than last item(index))
numList.pop(2)

# ---------- LIST COMPREHENSIONS ----------
# A list comprehension executes an expression against an iterable
# Note that a list comprehension is surrounded by [] because it returns a list
# A list comprehension can act as map and filter on one line

# Perform an operation on each item in the list
print([2 * x for x in range(1, 11)])
print([x for x in range(1, 11) if x % 2 != 0])
print([i ** 2 for i in range(50) if i % 8 == 0])

# list of lists (multidimensional list)
print([[math.pow(m, 2), math.pow(m, 3), math.pow(m, 4)] for m in [1, 2, 3]])

# You can have multiple for loops as well
# Multiply all values in one list times all values in another
print([x * y for x in range(1, 3) for y in range(11, 16)])

# You can put list comprehensions in list comprehensions
print([x for x in [i * 2 for i in range(10)] if x % 8 == 0])
print([x for x in [random.randint(1, 1001) for i in range(50)] if x % 9 == 0])

# ---------- MULTIDIMENSIONAL LIST ----------
# list 10 x 10
listTable = [[0] * 10 for i in range(10)]
# Change a value in the multidimensional list
listTable[0][1] = 10
# Get the item in the multidimensional list
print(listTable[0][1])

# populate multidimensional list
for i in range(10):
    for j in range(10):
        listTable[i][j] = "{} : {}".format(i, j)
        # for multiplication table put here instead
        # listTable[i][j] = i * j
# print multidimensional list
for i in range(10):
    for j in range(10):
        print(listTable[i][j], end=" || ")
    print()

# another example of multidimensional list
multiList = [[1, 2, 3],
             [4, 5, 6],
             [7, 8, 9]]
# print 1. row
print(multiList[0])
# print 1. column
print([col[0] for col in multiList])
# print diagonal by incrementing 0, 0 -> 1, 1 -> 2, 2
print([multiList[i][i] for i in range(len(multiList))])

# put all elements in one list
d = [list(range(10)), [1, 3, 5, 7, 9], ['a', 'b', 'c']]
totalllist = []
for x in d:
    for y in x:
        totalllist.append(y)

# ---------- EXAMPLE : BUBBLE SORT ----------
numList = []
i = len(numList) - 1
while i > 1:
    j = 0
    while j < i:
        # Tracks the comparison of index values
        print("\nIs {} > {}".format(numList[j], numList[j + 1]))
        print()
        # If the value on the left is bigger switch values
        if numList[j] > numList[j + 1]:
            print("Switch")
            temp = numList[j]
            numList[j] = numList[j + 1]
            numList[j + 1] = temp
        else:
            print("Don't Switch")
        j += 1
        # Track changes to the list
        for k in numList:
            print(k, end=", ")
        print()
    print("END OF ROUND")
    i -= 1
for k in numList:
    print(k, end=", ")
print()

# ---------- MAP ----------
# Map allows us to execute a function on each item in a list
oneTo10 = range(1, 11)


# The function to pass into map
def dbl_num(num):
    return num * 2


# Pass in the function and the list to generate a new list
print(list(map(dbl_num, oneTo10)))

# You could do the same thing with a lambda
print(list(map((lambda x: x * 3), oneTo10)))

# You can perform calculations against multiple lists
bList = list(map((lambda x, y: x + y), [1, 2, 3], [1, 2, 3]))
print(bList)

# ---------- FILTER ----------
# Filter selects items from a list based on a function

# Print out the even values from a list
print(list(filter((lambda x: x % 2 == 0), range(1, 11))))

# ---------- REDUCE ----------
# Reduce receives list and returns single result (can be used instead of loop)
from functools import reduce

# Add up the values in a list
print(reduce((lambda x, y: x + y), range(1, 6)))

# ---------- TUPLES ----------
# A Tuple is like a list, but their values can't be changed
# Tuples are surrounded with parentheses instead of square brackets
myTuple = (1, 2, 3, 5, 8)

# Get a value with an index
print("1st Value :", myTuple[0])

# Get a slice from the 1st index up to but not including the 3rd
print(myTuple[0:3])

# Iterate through a tuple
for i in myTuple:
    print(i)

# Get the number of items in a Tuple
print("Tuple Length :", len(myTuple))

# Check if a value is in a Tuple
print("34 in Tuple :", 34 in myTuple)

# Get max and minimum value inside in a tuple
print("Min :", min(myTuple))
print("Max :", max(myTuple))

# Join or concatenate tuples
moreFibs = myTuple + (13, 21, 34)

# Convert a List into a Tuple
aList = [55, 89, 144]
aTuple = tuple(aList)

# Convert a Tuple into a List
aList = list(aTuple)

# ---------- DICTIONARIES ----------
# Dictionaries organize data based on use key / value pairs.
derekDict = {"fName": "Derek", "lName": "Banas", "address": "123 Main St"}

# Get a value with the key
print("May name :", derekDict["fName"])

# Dictionaries may not print out in order created since they are unordered
print(derekDict)

# Get the list of values
print(derekDict.values())

# Get the list of keys
print(derekDict.keys())

# converting dictionary to list of lists and list of tuples
c = []  # list of lists
d = []  # list of tuples
for i, j in derekDict.items():
    print(i, j)
    a = [j, i]
    b = (j, i)
    c.append(a)
    d.append(b)

# Loop through the dictionary keys
for i in derekDict:
    print(i)

for key in derekDict:
    print(key, derekDict[key])

# Change a value with the key
derekDict["address"] = "215 North St"

# Add a new key value
derekDict['city'] = 'Pittsburgh'

# Check if a key exists
print("Is there a city :", "city" in derekDict)

# Get gets a value associated with a key, if not returnst default
print(derekDict.get("mName", "Not Here"))

# Delete a key value
del derekDict["fName"]

# Delete all entries
derekDict.clear()

# ---------- ITERABLES & ITERATORS ----------
# iterable is is a stored sequence of values (list, tuple,..), an object with
# an __iter__ method which returns an iterator.
# An iterator is an object with a __next__ method which retrieves the next
# value from sequence of values

# you can only iterate once per iterator instanciation, to repeat you have to
# declare new instance of iter

# example 1
# Define a string or list or dict... and convert it into an iterator
sampStr = iter("Sample")
# take first element
print("Char :", next(sampStr))
# take second element
print("Char :", next(sampStr))

sampStr2 = reversed("Sample")
# take last element
print("Char :", next(sampStr2))

# example 2
# You can add iterator behavior to your classes
class Alphabet:
    def __init__(self):
        self.letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        self.index = -1

    # make iterator from object itself
    def __iter__(self):
        return self

    # return element
    def __next__(self):
        self.index += 1
        if self.index >= len(self.letters):
            raise StopIteration
        return self.letters[self.index]


alpha = Alphabet()

# iterate all
for letter in alpha:
    print(letter)

# iterate one by one
itr = iter(alpha)  # iter calls iter method from class above
print(next(itr))  # next calls next method from class above
print(next(itr))
print(next(itr))


# example 3
# Create a class that returns values from the Fibonacci sequence each time
# next is called
class FibGenerator:
    def __init__(self):
        self.first = 0
        self.second = 1

    def __iter__(self):
        return self

    def __next__(self):
        fibNum = self.first + self.second
        self.first = self.second
        self.second = fibNum
        return fibNum


fibSeq = FibGenerator()

for i in range(10):
    print("Fib :", next(fibSeq))

# ---------- GENERATOR FUNCTIONS ----------
# A generator function returns a result when called
# They can be suspended and resumed during execution of your program to
# create results over time rather then all at once
# We use generators when we want to big result set, but we don't want to slow
# down the program by creating it all at one time


# is this a prime number
def isprime(num):
    for i in range(2, num):
        if (num % i) == 0:
            return False
    return True


# This is the generator
def gen_primes(max_number):
    for num1 in range(2, max_number):
        if isprime(num1):
            # yield is what makes this a generator
            # When called by next it will return the next result
            yield num1


# Create a reference to the generator
prime = gen_primes(50)

# Call next for each result
print("Prime :", next(prime))
print("Prime :", next(prime))
print("Prime :", next(prime))

# ---------- GENERATOR EXPRESSIONS ----------
# Generator expressions look just like list comprehensions
# but they return results one at a time
# The are surrounded by parentheses instead of [ ]

double = (x * 2 for x in range(10))

# return one at a time
print("Double :", next(double))
print("Double :", next(double))

# You can iterate through all results as well
for num in double:
    print(num)

# ---------- HIGHER TYPE CONVERSIONS ----------

# combining two lists together
a = [1, 3, 5, 7, 9]
b = [5, 6, 7, 8, 9]
result = zip(a, b)
print(list(result))

# ---------- OOP ----------
# In object oriented programming we model real world objects be defining the
# attributes (fields) and capabilities (methods) that they have.
# A class is the template used to model these objects
# Getters and Setters are used to protect our objects from assigning bad
# fields or for providing improved output

class CClass:
    classvar = 0  # class(static) variable (public)

    # The init method is called to create an object
    # We give default values for the fields if none are provided
    def __init__(self, insvarprivate="Unknown", insvarpublic="Unknown",
                 insvarprotected="Unknown"):
        # self allows an object to refer to itself (instance)

        # We will take the values passed in and assign
        # them to the new objects fields (attributes)
        self.__insvarprivate = insvarprivate  # private, means nobody can
        # touch this from outside a class
        self._insvarprotected = insvarprotected  # protected by convention,
        # means don't touch this unless you are a subclass, otherwise the
        # same as public
        self.insvarpublic = insvarpublic  # public

        CClass.classvar += 1  # class/static variable usefull for counters

    # instance method / object method
    def instancemethod(self, randomvar):
        # instance variables
        print(self.__insvarprivate)
        print(self.insvarpublic)

        # static varibale that is unique to class
        # can be also redeclared separately in any instance
        print(self.classvar)

        # static/class variable unique to all instances
        print(CClass.classvar)

        # adding variable through instance method
        print(randomvar)
        # or
        self.randomvar = randomvar

    @classmethod
    # Static methods allow access without the need to initialize
    # a class. They should be used as utility methods, or when
    # a method is needed, but it doesn't make sense for the real
    # world object to be able to perform a task. They receives class as a
    # first argument
    def classmethod(cls, correctclassvar, classmethodvar, randomstring):

        # static/class variable unique to all instances
        # can also be used to retrive static counter from init method
        print(cls.classvar)

        # setting class variable (casting to int on input)
        correctclassvar = int(correctclassvar)
        cls.classvar = correctclassvar

        # variable instanciation inside class method
        cls.classmethodvar = classmethodvar

        # special case: creating new instance/object through class method ?????
        # x, y = randomstring.split()
        # return cls(x, y)

    # if there is no reference to instance or class use static method
    @staticmethod
    def sstaticmethod(day):
        if day == "Monday":
            return True

    # The getter method (access function in main like an argument without
    # parenthasis)
    @property
    def insvarprivate(self):
        # Put a __ before this private field
        return self.__insvarprivate

    # the setter method (access function in main like an argument without
    # parenthasis)
    @insvarprivate.setter
    def insvarprivate(self, insvarprivate):
        # Put a __ before this private field
        # put data checks in body here
        self.__insvarprivate = insvarprivate

    # the deleter method (access function in main like an argument without
    # parenthasis)
    @insvarprivate.deleter
    def insvarprivate(self):
        self.__insvarprivate = None

    # str magic method can be used to cast our object as a string
    # type(self).__name__ returns the class name
    def __str__(self):
        return "A {} is {} it is {}".format(type(self).__name__,
                                            self.insvarprivate,
                                            self.insvarpublic)


# ---------- INHERITANCE ----------
# a class can inherit all of the fields and methods from another class.
# That class is the subclass and the class we inherit from is the super class
# You can inherit from multiple classes by separating
# the classes with a comma in the parentheses
class SubClass(CClass):
    def __init__(self, insvarprivate="born alive",
                 insvarpublic="warm blooded",
                 instancevar4=True):
        # Call for the super class to initialize fields
        super().__init__(insvarprivate, insvarpublic)
        # or use:
        # CClass.__init__(self, insvarprivate, insvarpublic)
        # instanciate missing variable
        self.__instancevar4 = instancevar4

    # We can extend the subclasses (add setters & getters)
    @property
    def instancevar4(self):
        return self.__instancevar4

    @instancevar4.setter
    def instancevar4(self, instancevar4):
        self.__instancevar4 = instancevar4

    # Overwrite __str__
    # You can use super() to refer to the superclass
    def __str__(self):
        return super().__str__() + " and it is {} they nurse " \
                                   "their young".format(self.instancevar4)


# ---------- POLYMORPHISM ----------
# Polymorphism in Python works differently from other languages in that
# functions accept any object and expect that object to provide the
# needed method. if you call on a method for an object the method just needs
# to exist for that object to work. Polymorphism is a big deal in languages that
# are statically typed (type is defined at declaration) but because
# Python is dynamically typed (type defined when a value is assigned) it
# doesn't matter as much.
# asking for name & one random field in this example
def polymorphmethod(theobject):
    print(type(theobject).__name__, theobject.insvarprivate)


def main():

    print(CClass.classvar)
    CClass.classmethod("1", "b", "c")
    CClass.sstaticmethod("utorak")

    print(SubClass.classvar)
    SubClass.classmethod("1", "b", "c")
    SubClass.sstaticmethod("utorak")

    class1 = CClass("born alive")
    print(class1)  # Call __str__()
    print(class1.insvarprivate)
    print(class1.insvarpublic)
    print(class1.classvar)
    class1.instancemethod("randomvar")
    class1.classmethod("1", "b", "c")
    class1.sstaticmethod("utorak")

    subclass1 = SubClass()
    print(subclass1)  # Call __str__()
    print(subclass1.insvarprivate)
    print(subclass1.insvarpublic)
    print(subclass1.instancevar4)
    print(subclass1.classvar)
    subclass1.instancemethod("randomvar")
    subclass1.classmethod("1", "b", "c")
    subclass1.sstaticmethod("utorak")

    # inputing public
    randomvar2 = input("Enter appearance of the mammel : ")
    subclass1.insvarpublic = randomvar2

    # getting with property decorator
    print(subclass1.insvarprivate)

    # inputing with setter decorator
    randomvar3 = input("Enter appearance of the mammel : ")
    subclass1.insvarprivate = randomvar3

    # deleting with deleter decorator
    del subclass1.insvarprivate

    # polymorphism
    polymorphmethod(class1)
    polymorphmethod(subclass1)

    print(class1.instancemethod("randomvar"))
    # is same as (two ways to call for field and methods)
    print(CClass.instancemethod(class1, "randomvar"))

    # check if is instance
    print(isinstance(class1, CClass))
    # check if is subclass
    print(issubclass(SubClass, CClass))


main()

# ---------- EXAMPLE : WARRIORS BATTLE ----------
import random
import math


# Warriors will have names, health, and attack and block maximums
# They will have the capabilities to attack and block random amounts
class Warrior:
    def __init__(self, name="warrior", health=0, attkMax=0, blockMax=0):
        self.name = name
        self.health = health
        self.attkMax = attkMax
        self.blockMax = blockMax

    def attack(self):
        # Randomly calculate the attack amount
        # random() returns a value from 0.0 to 1.0
        attkAmt = self.attkMax * (random.random() + .5)
        return attkAmt

    def block(self):
        # Randomly calculate how much of the attack was blocked
        blockAmt = self.blockMax * (random.random() + .5)
        return blockAmt


# The Battle class will have the capability to loop until 1 Warrior dies
# The Warriors will each get a turn to attack each turn
class Battle:

    def startFight(self, warrior1, warrior2):
        # Continue looping until a Warrior dies switching back and
        # forth as the Warriors attack each other
        while True:
            if self.getAttackResult(warrior1, warrior2) == "Game Over":
                print("Game Over")
                break
            if self.getAttackResult(warrior2, warrior1) == "Game Over":
                print("Game Over")
                break

    # Make this method static because we don't need to use self
    @staticmethod
    def getAttackResult(warriorA, warriorB):

        warriorAAttkAmt = warriorA.attack()

        warriorBBlockAmt = warriorB.block()

        damage2WarriorB = math.ceil(warriorAAttkAmt - warriorBBlockAmt)

        warriorB.health = warriorB.health - damage2WarriorB

        print("{} attacks {} and deals {} damage".format(warriorA.name,
                                                         warriorB.name,
                                                         damage2WarriorB))

        print("{} is down to {} health".format(warriorB.name,
                                               warriorB.health))

        if warriorB.health <= 0:
            print("{} has Died and {} is Victorious".format(warriorB.name,
                                                            warriorA.name))
            return "Game Over"
        else:
            return "Fight Again"


def main():
    # Create 2 Warriors
    paul = Warrior("Paul", 50, 20, 10)
    sam = Warrior("Sam", 50, 20, 10)

    # Create Battle object
    battle = Battle()

    # Initiate Battle
    battle.startFight(paul, sam)


main()


# ---------- MAGIC METHODS ----------
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

# Magic methods can be overwritten (put in class)
# def __repr__(self):
#     return # make custom return

# calling magic methods (put in main)
# print(repr(instance))
# print(str(instance))
# print(dict(CClass))
# is the same as
# print(class1.__repr__())
# print(class1.__str__())
# print(CClass.__dict__)


class Time:
    def __init__(self, hour=0, minute=0, second=0):
        self.hour = hour
        self.minute = minute
        self.second = second

    # Magic method that defines the string format of the object
    def __str__(self):
        # :02d adds a leading zero to have a minimum of 2 digits
        return "{}:{:02d}:{:02d}".format(self.hour, self.minute, self.second)

    def __add__(self, other_time):

        new_time = Time()

        # ---------- PROBLEM ----------
        # How would you go about adding 2 times together?

        # Add the seconds and correct if sum is >= 60
        if (self.second + other_time.second) >= 60:
            self.minute += 1
            new_time.second = (self.second + other_time.second) - 60
        else:
            new_time.second = self.second + other_time.second

        # Add the minutes and correct if sum is >= 60
        if (self.minute + other_time.minute) >= 60:
            self.hour += 1
            new_time.minute = (self.minute + other_time.minute) - 60
        else:
            new_time.minute = self.minute + other_time.minute

        # Add the hours and correct if sum is > 24
        if (self.hour + other_time.hour) > 24:
            new_time.hour = (self.hour + other_time.hour) - 24
        else:
            new_time.hour = self.hour + other_time.hour

        return new_time


def main():
    time1 = Time(1, 20, 30)
    print(time1)

    time2 = Time(24, 41, 30)
    print(time1 + time2)


main()

# ---------- IO/FILES ----------

import os

# ---------- DIRS ----------

# Display current directory
print("Current Directory :", os.getcwd())

# List directory
print("List Directory :", os.listdir('D:/folder'))

# Loop through directory
for listedfiles in os.listdir('D:/folder'):
    print(listedfiles)

# Create a directory
os.mkdir("mydir")

# Change directories
os.chdir("mydir")

# move back 1 directory
os.chdir("..")

# Remove a directory
os.rmdir("mydir")

# ---------- FILES ----------

# You can create or use an already created file with open
# We start the code with with which guarantees the file
# will be closed if the program crashes
# open require mandatory closing of connection

# Text is stored using unicode where numbers represent all characters

# If you use w (write) for mode then the file is overwritten.
# If you use a (append) you add to the end of the file
# Both does not adds a newline \n

ffoldername = 'c:/ffolder/'
ffilename = 'mydata.txt'
ppath = 'c:/ffolder/' + ffilename
ppath = ffoldername + "mydata.txt"
ppath = ffoldername + ffilename
ppath = 'c:/ffolder/mydata.txt'

myFile = open(ppath, mode='a', encoding='utf-8')
myFile.write('ttext\nttext')

with open(ppath, mode="w", encoding="utf-8") as myFile:
    myFile.write("Some random text\nMore random text\nAnd some more")

# For reading do not provide a mode at all
with open(ppath, encoding="utf-8") as myFile:

    # We can read data in a few ways
    # 1. read() read everything into string (if optional parametar not provided)
    # 2. readline() reads one line up to newline (\n)
    # 3. readlines() returns a list of lines (\n included in each)

    # read() method
    print(myFile.read())

    # readline() method
    lineNum = 1
    # We'll use a while loop that loops until the dataread is empty
    while True:
        line = myFile.readline()
        # if there is no more lines of data to read
        if not line:
            break
        print("Line", lineNum, " :", line, end="")
        lineNum += 1

# Get the file name
print(myFile.name)

# Get the access mode of the file
print(myFile.mode)

# Find out if the file is closed
print(myFile.closed)

# Rename our file
os.rename("mydata.txt", "mydata2.txt")

# join path & filename in one string
pathname = os.path.join('D:/folder', "mydata.txt")

# Delete a file
os.remove(ppath + "mydata2.txt")

# ---------- EXAMPLE : ANALYZE THE FILE ----------
with open("mydata2.txt", mode="w", encoding="utf-8") as myFile:
    myFile.write("Some random text\nMore random text\nAnd some more")

# cycle through each line output the number of words and average word length
with open("mydata2.txt", encoding="utf-8") as myFile:
    lineNum = 1
    while True:
        line = myFile.readline()
        # line is empty so exit
        if not line:
            break
        # Put the words in a list using the space as the boundary between words
        wordList = line.split()
        # Get the number of words with len()
        print("Number of Words :", len(wordList))
        # Incremented for each character
        charCount = 0
        for word in wordList:
            for char in word:
                charCount += 1
        # Divide to find the answer
        avgNumChars = charCount / len(wordList)
        lineNum += 1

os.remove("mydata2.txt")

# ---------- LOGGING ----------
# make logs (this is just the basics)
import logging

# put log file location, and chose logging level (DEBUG, INFO, WARNING,
# ERROR, CRITICAL)
logging.basicConfig(filename='test.log', level=logging.DEBUG)

# can be used just as print
print("pera")
logging.debug("pera")

# ---------- THREADING ----------
import threading
import time
import random


# ---------- EXAMPLE1 ----------
# thread/function that will be started multiple times
def xthread(i):
    # print time at start moment
    print("Thread {} sleeps at {}"
          .format(i, time.strftime("%H:%M:%S", time.gmtime())))

    # sleep the thread 1 to 5 seconds
    randsleeptime = random.randint(1, 5)
    time.sleep(randsleeptime)

    # print time at wake moment
    print("Thread {} stops sleeping at {}"
          .format(i, time.strftime("%H:%M:%S", time.gmtime())))


# start 10 threads
for i in range(10):
    thread = threading.Thread(target=xthread, args=(i,))
    thread.start()

    # show number of thread that are currently executing
    print(threading.activeCount())

    # show all thread that are active at given time
    print(threading.enumerate())


# ---------- EXAMPLE2 ----------
# subclassing thread object
class CustThread(threading.Thread):

    # put name for identification
    def __init__(self, name):
        # initialize super class
        threading.Thread.__init__(self)
        self.name = name

    # this method executes automaticaly (run)
    def run(self):
        print("Thread {} sleeps at {}"
              .format(self.name, time.strftime("%H:%M:%S", time.gmtime())))
        randsleeptime = random.randint(1, 3)
        time.sleep(randsleeptime)
        print("Thread", self.name, "Execution Ends")


# create two threads
thread1 = CustThread("1")
thread2 = CustThread("2")

# start threads
thread1.start()
thread2.start()

# method for checking if thread is alive
print("Thread 1 Alive :", thread1.is_alive())
print("Thread 2 Alive :", thread2.is_alive())

# get names of threads
print("Thread 1 Name :", thread1.getName())
print("Thread 2 Name :", thread2.getName())

# wait for thread to exit
thread1.join()
thread2.join()

print("execution ends")


# ---------- EXAMPLE3 ----------
# subclassing thread object
class BankAccount(threading.Thread):

    acctBalance = 100

    # name of person requesting, and quantity of money requested
    def __init__(self, name, moneyRequest):
        threading.Thread.__init__(self)
        self.name = name
        self.moneyRequest = moneyRequest

    # run runs automaticaly (in thread class)
    def run(self):
        threadLock.acquire()
        BankAccount.getMoney(self)
        threadLock.release()

    @staticmethod
    def getMoney(customer):
        print("{} tries to withdrawal ${} at {}".format(customer.name,
              customer.moneyRequest,
              time.strftime("%H:%M:%S", time.gmtime())))

        if BankAccount.acctBalance - customer.moneyRequest > 0:
            BankAccount.acctBalance -= customer.moneyRequest
            print("New account balance is : ${}".
                  format(BankAccount.acctBalance))
        else:
            print("Not enough money in the account")
            print("Current balance : ${}".format(BankAccount.acctBalance))


# lock thread in advance
threadLock = threading.Lock()

doug = BankAccount("Doug", 1)
paul = BankAccount("Paul", 100)
sally = BankAccount("Sally", 50)

doug.start()
paul.start()
sally.start()

doug.join()
paul.join()
sally.join()

print("Execution Ends")

# ---------- REGULAR EXPRESSIONS ----------
import re

randStr = "The ape was at the apex Cat rat mat fat pat rat cat mat pat"

# You can compile a regex into pattern objects which provide additional methods
# "regex" is regular expression string: "ape" "ape." "[cr]at" ...
regex = re.compile("regex")

# ---------- matching ----------

# Search for string in the string
if re.search(regex, randStr):
    print("true")

# findall() returns a list of matches
matches = re.findall(regex, randStr)

# print result
print(matches)
# or
for i in matches:
    print(i)

# return number of matches
countNum = len(matches)

# finditer returns an iterator of matching objects
# You can use span to get the location
for i in re.finditer(regex, randStr):
    # Span returns a tuple
    locTuple = i.span()
    print(locTuple)
    # Slice the match out using the tuple values
    print(randStr[locTuple[0]:locTuple[1]])

# sub() replaces items that match the regex in the string
# with the string passed to sub
randStr = regex.sub("substitutionString", randStr)

# ---------- syntax ----------

# [ ]   : Match what is in the brackets
# [Aa]	: Represents 1 A or 1 a ??????????????????????????????????????
# [^ ]  : Match anything not in the brackets
# ( )   : Return surrounded submatch
# .     : Match any 1 character or space (except a newline)
# +     : Match 1 or more of what proceeds
# ?     : Match 0 or 1 of what proceeds
# *     : Match 0 or More of what proceeds
# *?, +?, or {n,}?    : Lazy match the smallest match
# \b    : Word boundary
# \B	: anything not a word boundary
# ^     : Beginning of String
# $     : End of String
# \n    : Newline
# \d    : Any 1 number
# \D    : Anything but a number (oposite of \d)
# \w    : Same as [a-zA-Z0-9_]
# \W    : Same as [^a-zA-Z0-9_] (oposite of \w)
# \s    : Same as [\f\n\r\t\v] (any space)
# \S    : Same as [^\f\n\r\t\v] (not any space, oposite of \s)
# {5}   : Match 5 of what proceeds the curly brackets
# {5,7} : Match values that are between 5 and 7 in length
# ($m)  : Allow ^ on multiline string
# |	    : or

# ---------- Solving Backslash Problems ----------
# Regex use the backslash to designate special characters
# and Python does the same inside strings which causes issues.

# Let's try to get "\\stuff" out of a string
randStr = "Here is \\stuff"

# This won't find it
print("Find \\stuff : ", re.search("\\stuff", randStr))

# This does, but we have to put in 4 slashes which is messy
print("Find \\stuff : ", re.search("\\\\stuff", randStr))

# You can get around this by using raw strings which
# don't treat backslashes as special
print("Find \\stuff : ", re.search(r"\\stuff", randStr))

# ---------- Matching Any Character ----------
# . matches any character, to match a period, Backslash the period.

randStr = "F.B.I. I.R.S. CIA"
print("Matches :", len(re.findall(".\..\..", randStr)))

# ---------- Matching Whitespace ----------
# We can match many whitespace characters
randStr = """This is a long
string that goes
on for many lines"""

# Remove newlines
regex = re.compile("\n")
randStr = regex.sub(" ", randStr)

# You can also match
# \b : Backspace
# \f : Form Feed
# \r : Carriage Return
# \t : Tab
# \v : Vertical Tab

# You may need to remove \r\n on Windows

# ---------- Matching whitespace on windows ----------
# On Windows newlines are some times \n and other times \r\n
# Create a regex that will grab each of the lines in this
# string, print out the number of matches and each line

longStr = '''Just some words
and some more\r
and more
'''
regex1 = re.compile(r"[\w\s]+[\r]?\n")
regex2 = re.compile("[\w\s]+[\r]?\n")

print("Matches :", len(re.findall(regex1, longStr)))
matches = re.findall(regex2, longStr)

# ---------- Greedy & Lazy Matching ----------
# Let's try to grab everything between first <name> tags
randStr = "<name>Life On Mars</name><name>Freaks and Geeks</name>"

# Because * is greedy (It grabs the biggest match possible)
# we can't get what we want, which is each individual tag match
regex = re.compile(r"<name>.*</name>")
matches = re.findall(regex, randStr)

# We want to grab the smallest match we use *?, +?, or {n,}? instead
# (adding ? make it lazy)
regex = re.compile(r"<name>.*?</name>")
matches = re.findall(regex, randStr)

# ---------- Word Boundaries ----------
# We use word boundaries to define where our matches start and end
randStr = "ape at the apex"

# this won't work
regex = re.compile(r"ape")

# \b matches the start or end of a word
regex = re.compile(r"\bape\b")
matches = re.findall(regex, randStr)

# ---------- String Boundaries ----------
# ^ : Matches the beginning of a string if outside of a [ ]
# $ : Matches the end of a string

# Grab everything from the start of the string to @
randStr = "Match everything up to @"
regex = re.compile(r"^.*[^@]")
matches = re.findall(regex, randStr)

# Grab everything from @ to the end of the line
randStr = "@ Get this string"
regex = re.compile(r"[^@\s].*$")
matches = re.findall(regex, randStr)

# Grab the 1st word of each line using the the multiline
# code which allows for the targeting of each line after
# a line break with ^
randStr = '''Ape is big
Turtle is slow
Cheetah is fast'''
regex = re.compile(r"(?m)^.*?\s")
matches = re.findall(regex, randStr)

# ---------- Subexpressions ----------
# Subexpressions are parts of a larger expression
# If you want to match for a large block, but only want to return part of it.
# To do that surround what you want with ( )

# Get just the number minus the area code
randStr = "My number is 412-555-1212"
regex = re.compile(r"412-(.*)")
matches = re.findall(regex, randStr)

# ---------- Multiple Subexpressions ----------
# You can have multiple subexpressions as well
# Get both numbers that follow 412 separately
randStr = "My number is 412-555-1212"
regex = re.compile(r"412-(.*)-(.*)")
matches = re.findall(regex, randStr)
print("Matches :", len(matches))
print(matches[0][0])
print(matches[0][1])

# ---------- Back References ----------
# A back reference allows you to to reuse the expression that proceeds it

# Grab a double word
randStr = "The cat cat fell out the window"

# Match a word boundary, 1 or more characters followed
# by a space if it is then followed by the same
# match that is surrounded by the parentheses
regex = re.compile(r"(\b\w+)\s+\1")
matches = re.findall(regex, randStr)

# ---------- Back Reference Substitutions ----------
# Replace the bold tags in the link with no tags
randStr = "<a href='#'><b>The Link</b></a>"

# Regex matches bold tags and grabs the text between
# them to be used by the back reference
regex = re.compile(r"<b>(.*?)</b>")

# Replace the tags with just the text between them
# (substitute regex with r"\1" in string
randStr = re.sub(regex, r"\1", randStr)

# ---------- Another Back Reference Substitution ----------
# Receive this string
randStr = "412-555-1212"

# Match the phone number using multiple subexpressions
regex = re.compile(r"([\d]{3})-([\d]{3}-[\d]{4})")

# Output (412)555-1212
randStr = re.sub(regex, r"(\1)\2", randStr)

# ---------- links ----------
# Receive a string like this
randStr = "https://www.youtube.com http://www.google.com"

# Grab the URL and then provide the following output
# using a back reference substitution
# <a href='https://www.youtube.com'>www.youtube.com</a>
# <a href='https://www.google.com'>www.google.com</a>

regex = re.compile(r"(https?://([\w.]+))")
randStr = re.sub(regex, r"<a href='\1'>\2</a>\n", randStr)

# ---------- Look Ahead ----------
# A look ahead defines a pattern to match but not return
# You define the expression to look for but not return like this (?=expression)

randStr = "One two three four"
# Grab all letters and numbers of 1 or more separated
# by a word boundary but don't include it
regex = re.compile(r"\w+(?=\b)")
matches = re.findall(regex, randStr)

# ---------- Look Behind ----------
# look behind looks for what is before the text to return, but doesn't return it
# It is defined like (?<=expression)

randStr = "1. Bread 2. Apples 3. Lettuce"
# Find the number, period and space, but only return
# the 1 or more letters or numbers that follow
regex = re.compile(r"(?<=\d.\s)\w+")
matches = re.findall(regex, randStr)

# ---------- Look Ahead & Behind ----------
randStr = "<h1>I'm Important</h1> <h1>So am I</h1>"
# Use the look behind, get 1 or more of anything, and use the look ahead
# use lazy here
regex = re.compile(r"(?<=<h1>).+?(?=</h1>)")
matches = re.findall(regex, randStr)

# ---------- Negative Look Ahead & Behind ----------
# These are used to look for text that doesn't match the pattern
# (?!expression) : Negative Look Ahead
# (?<!expression) : Negative Look Behind

randStr = "8 Apples $3, 1 Bread $1, 1 Cereal $4"
# Grab the total number of grocery items by ignoring the $
regex = re.compile(r"(?<!\$)\d+")
matches = re.findall(regex, randStr)

# ---------- OR CONDITIONAL ----------
# You can use | to define the matches you'll except
randStr = "1. Dog 2. Cat 3. Turtle"
regex = re.compile(r"\d\.\s(Dog|Cat)")
matches = re.findall(regex, randStr)

# ---------- GROUP ----------
# We can use group to retrieve parts of regex matches

inputquestion = input("Enter your birthday (mm-dd-yyyy) : ")
bdRegex = re.search(r"(\d{1,2})-(\d{1,2})-(\d{4})", inputquestion)

print("You were born on", bdRegex.group())
print("Birth Month", bdRegex.group(1))
print("Birth Day", bdRegex.group(2))
print("Birth Year", bdRegex.group(3))

# ---------- NAMED GROUPS ----------
# You can also assign names to matches
randStr = "December 21 1974"
regex = r"^(?P<month>\w+)\s(?P<day>\d+)\s(?P<year>\d+)"
matches = re.search(regex, randStr)

print("Month :", matches.group('month'))
print("Day :", matches.group('day'))
print("Year :", matches.group('year'))

# ---------- MATCH OBJECT FUNCTIONS ----------
# There are functions that provide more information on your matches
match = re.search(r"\d{2}", "The chicken weighed 13 lbs")

# Print the match
print("Match :", match.group())

# Print the start and ending index of the match
print("Span :", match.span())

# Print starting index of the match
print("Match :", match.start())

# Print the ending index of the match
print("Match :", match.end())

# ---------- EXAMPLE1 ----------
# Find all of the following email addresses
randStr = "d+b@aol.com a_1@yahoo.co.uk A-100@m-b.INTERNATIONAL"

regex = re.compile(r"[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+")
matches = re.findall(regex, randStr)

# ---------- EXAMPLE2 ----------
# Find all of the following phone numbers and then print them
randStr = "14125551212 4125551212 (412)5551212 412 555 1212 412-555-1212 " \
          "1-412-555-1212"

regex = re.compile(
    r"((1?)(-| ?)(\()?(\d{3})(\)|-| |\)-|\) )?(\d{3})(-| )?(\d{4}|\d{4}))")
matches = re.findall(regex, randStr)

for i in matches:
    print(i[0].lstrip())

# ---------- SQLITE ----------
import sqlite3


# run query through function
def printquery():
    try:
        result = theCursor.execute(
            "SELECT id, FName, LName, Age, Address, HireDate FROM Employees")
        # You receive a list of lists that hold the result
        for row in result:
            print("ID :", row[0])
            print("FName :", row[1])
            print("LName :", row[2])
            print("Age :", row[3])
            print("Address :", row[4])
            print("HireDate :", row[6])
    except sqlite3.OperationalError:
        print("The Table Doesn't Exist")
    except:
        print("Couldn't Retrieve Data From Database")


# connect() will open an SQLite database, or if it
# doesn't exist it will create it
# The file appears in the same directory as this Python file
db_conn = sqlite3.connect('test.db')

# A cursor is used to traverse the records of a result
theCursor = db_conn.cursor()

# Get SQLite version
theCursor.execute('SELECT SQLITE_VERSION()')
# fetchone() returns one result
print("SQLite Version :", theCursor.fetchone())

# execute() executes a SQL command
# commit() (and commit also)

# Undo the last commit()
db_conn.rollback()

# create table
try:
    db_conn.execute(
        "CREATE TABLE Employees(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT "
        "NULL, FName TEXT NOT NULL, LName TEXT NOT NULL, Age INT NOT NULL, "
        "Address TEXT, Salary REAL, HireDate TEXT);")
    db_conn.commit()

except sqlite3.OperationalError:
    print("Table couldn't be Created")

# You can delete a table if it exists like this
db_conn.execute("DROP TABLE IF EXISTS Employees")
db_conn.commit()

# Retrieve table column names
theCursor.execute("PRAGMA TABLE_INFO(TableName)")
# fetchall() returns all remaining rows of a query result as a list
rowNames = [nameTuple[1] for nameTuple in theCursor.fetchall()]
print(rowNames)

# You can add a new column to a table with ALTER
try:
    db_conn.execute(
        "ALTER TABLE Employees ADD COLUMN 'Image' BLOB DEFAULT NULL")
    db_conn.commit()
except sqlite3.OperationalError:
    print("Table couldn't be Altered")

# To insert data into a table we use INSERT INTO
# followed by the table name and the item name
# and the data to assign to those items
db_conn.execute(
    "INSERT INTO Employees (FName, LName, Age, Address, Salary, HireDate)"
    "VALUES ('Derek', 'Banas', 41, '123 Main St', '500,000', date('now'))")
db_conn.commit()

# You can update a value in a table by referencing
# something unique like the ID or anything else
# with the UPDATE command
try:
    db_conn.execute("UPDATE Employees SET Address = '121 Main St' WHERE ID=2")
    db_conn.commit()
except sqlite3.OperationalError:
    print("Database couldn't be Updated")

# Delete matching data from the database by
# referencing the table name and something unique
try:
    db_conn.execute("DELETE FROM Employees WHERE ID=2")
    db_conn.commit()
except sqlite3.OperationalError:
    print("Data couldn't be Deleted")

# run query through function above
printquery()

# Get the total number of rows
theCursor.execute('SELECT COUNT(*) FROM Employees')
numOfRows = theCursor.fetchall()
print("Total Rows :", numOfRows[0][0])

# Use the dictionary cursor to retrieve data in a dictionary (??unclear)
with db_conn:
    db_conn.row_factory = sqlite3.Row
    theCursor = db_conn.cursor()
    theCursor.execute("SELECT * FROM Employees")
    rows = theCursor.fetchall()
    for row in rows:
        print("{} {}".format(row["FName"], row["LName"]))

# Write data to File (makes text representaiton of db, can be used to
# recreate & repopulate db (??unclear)
with open('dump.sql', 'w') as f:
    # iterdump() returns an iterator to dump the database in SQL format
    for line in db_conn.iterdump():
        f.write('%s\n' % line)

# Closes the database connection
db_conn.close()

# ---------- TKINTER ----------

# Test to see if TkInter is working
# import tkinter
# tkinter._test()

from tkinter import *
from tkinter import ttk # for alternative styling
from tkinter import messagebox

boolVar = True
strVar = "pera"
intVar = 3
dblVar = 8

# root is the main window that surrounds your interface
# This creates a Tk object
root = Tk()

# You can define the size of the window and the
# position on the screen with
# widthxheight+xoffset+yoffset
root.geometry("400x400+300+300")

# You can make it so the window isn't resizable
root.resizable(width=False, height=False)

# Give your app a title
root.title("First GUI")

# Frame widgets surround other widgets
frame = Frame(root)

# ---------- TKINTER: MULTIPLE COMPONENTS  ----------
# Some of the different Widgets : Button, Label,
# Canvas, Menu, Text, Scale, OptionMenu, Frame,
# CheckButton, LabelFrame, MenuButton, PanedWindow,
# Entry, ListBox, Message, RadioButton, ScrollBar,
# Bitmap, SpinBox, Image

# ---------- TKINTER: PACK GEOMETRY MANAGER  ----------
# Pack positions widgets by allowing them to define their position (Top,
# Right, Bottom, Left) and their fill direction (X, Y, BOTH, NONE) inside of
# a box

# Label(frame, text="A Bunch of Buttons").pack()
# Button(frame, text="B1").pack(side=LEFT, fill=Y)
# Button(frame, text="B2").pack(side=TOP, fill=X)
# Button(frame, text="B3").pack(side=RIGHT, fill=X)
# Button(frame, text="B4").pack(side=LEFT, fill=X)
#
# label = Label(frame, textvariable="labelText")
# button = Button(frame, text="Click Me")
# label.pack()
# button.pack()
#
# frame.pack()


# ---------- TKINTER: FUNCTIONS ----------
def get_sum(event):  # event=None can be also
    # Get the value stored in the entries
    num1 = int(Entry1.get())

    # Delete the value in the entry
    Entry1.delete(0, "end")

    # Insert value into the entry
    Entry1.insert(0, sum)


# You can open message boxes
def open_msg_box():
    messagebox.showwarning("Event Triggered", "Button Clicked")


# Quits the TkInter app when called
def quit_app():
    root.quit()


# ---------- TKINTER: GRID GEOMETRY MANAGER ----------
# The Grid manager is the most useful using a series of rows and columns for
# laying out widgets. Each cell can only hold 1 widget, but a widget can cover
# multiple cells.

# rows start at 0, 1, ...
# columns start at 0, 1, ...
# sticky defines how the widget expands (N, NE, E, SE, S, SW, W, NW)
# padx and pady provide padding around the widget above and below it

Label1 = Label(root, text="First Name")
Label1.grid(row=0, sticky=W, padx=4)
# update label
Label1['text'] = 'Konvertovano: {:.1f} eura'.format(num1)

Entry1 = Entry(root, width=50)
Entry1.grid(row=0, column=1, sticky=E, pady=4)
# delete entry
Entry1.delete(0, END)

Button1 = Button(root, text="Submit")
Button1.grid(row=3)
# When the left mouse button is clicked call the function get_sum
Button1 = ttk.Button(frame, textvariable=num1,
                     command=open_msg_box, accelerator="command-H")
# accelerator is used to show a shortcut
# OSX, Windows and Linux use the following options
# Command-O, Shift+Ctrl+S, Command-Option-Q with the
# modifiers Control, Ctrl, Option, Opt, Alt, Shift,
# and Command
Button1.bind("<Button-1>", get_sum)
Button1.unbind("<Button-1>")

Radio1 = Radiobutton(root, text="Dmg", value=4)
Radio1.grid(row=5, column=0, sticky=W)

Check1 = Checkbutton(root, text="Free Shipping",
                     variable=boolVar)
Check1.grid(row=2, column=1, sticky=W)
# When the left mouse button is clicked call the function bind_button
Check1.bind("<Button-1>", get_sum())

# You can also disable and enable widgets
Button1['state'] = 'disabled'
Button1['state'] = 'normal'

# ---------- TKINTER: GETTERS AND SETTERS ----------
# there are TkInter variables you can use with Widgets to set and get values
strVar = StringVar()
intVar = IntVar()
dblVar = DoubleVar()
boolVar = BooleanVar()

# Set the default values with set()
strVar.set("Enter String")
intVar.set("Enter Integer")
dblVar.set("Enter Double")
boolVar.set(True)

print("String :", strVar.get())
print("Integer :", intVar.get())
print("Double :", dblVar.get())
print("Boolean :", boolVar.get())

# ---------- TKINTER: STYLING WIDGETS ----------
# Color option names are here http://wiki.tcl.tk/37701
# For the font list the font family, px and font style
style = ttk.Style()
# You can change the theme style for your applications
# This shows you all the themes for your OS
print(ttk.Style().theme_names())
# Show theme in use
print(ttk.Style().theme_use())
# Change the theme for every widget (always set one by default)
ttk.Style().theme_use('clam')
# master style override is with "."
style.configure(".", foreground="midnight blue",
                font="Times 20 bold italic", padding=20)
# Ttk widget names : TButton, TCheckbutton, TCombobox,
# TEntry, TFrame, TLabel, TLabelframe, TMenubutton,
# TNotebook, TProgressbar, TRadiobutton, TScale,
# TScrollbar, TSpinbox, Treeview
# You can see current style settings like this
print(style.lookup('TButton', 'font'))
print(style.lookup('TButton', 'foreground'))
print(style.lookup('TButton', 'padding'))

# ---------- TKINTER: MENU BARS ----------

# Create the menu object
the_menu = Menu(root)

# Create a pull down menu that can't be removed
file_menu = Menu(the_menu, tearoff=0)

# Add items to the menu that show when clicked
# compound allows you to add an image
# Call for the function to execute when clicked
file_menu.add_command(label="Quit", command=quit_app)
# Add a horizontal bar to group similar commands
file_menu.add_separator()
# Add the pull down menu to the menu bar
the_menu.add_cascade(label="File", menu=file_menu)

# Bind the shortcut to the function
root.bind('<Command-A>', open_msg_box)
root.bind('<Command-a>', open_msg_box)

# Display the menu bar
root.config(menu=the_menu)

# This keeps the root window visible and your program running
root.mainloop()