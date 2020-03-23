
print("\n# decorator in Python is a callable Python object that is used to "
      "modify a function, method or class definition.")

print("\n# decorator methods")

print("\n# basic example 1")
def our_decorator(func):
    def function_wrapper(x):
        print("Before calling " + func.__name__)
        res = func(x)
        print(res)
        print("After calling " + func.__name__)
    return function_wrapper
@our_decorator
def succ(n):
    return n + 1
succ(10)

print("\n# basic example 2, 3rd party modules")
from math import sin, cos
def our_decorator(func):
    def function_wrapper(x):
        print("Before calling " + func.__name__)
        res = func(x)
        print(res)
        print("After calling " + func.__name__)
    return function_wrapper
sin = our_decorator(sin)
cos = our_decorator(cos)
for f in [sin, cos]:
    f(3.1415)

print("\n# basic example 3, generic example")
from random import random, randint, choice
def our_decorator(func):
    def function_wrapper(*args, **kwargs):
        print("Before calling " + func.__name__)
        res = func(*args, **kwargs)
        print(res)
        print("After calling " + func.__name__)
    return function_wrapper
random = our_decorator(random)
randint = our_decorator(randint)
choice = our_decorator(choice)
random()
randint(3, 8)
choice([4, 5, 6])

print("\n# basic example 4, generic example, with inner return")
print("# count the number of times a function has been called")
def call_counter(func):
    def helper(*args, **kwargs):
        helper.calls += 1
        return func(*args, **kwargs)
    helper.calls = 0
    return helper
@call_counter
def mul1(x, y=1):
    return x * y + 1
mul1(3, 4)
mul1(4)
mul1(y=3, x=2)
print(mul1.calls)

print("\n# basic example 5, decorator with parameter, inner/outer decorator")
def greeting(expr):
    def greeting_decorator(func):
        def function_wrapper(x):
            print(expr + ", " + func.__name__ + " returns:")
            func(x)
        return function_wrapper
    return greeting_decorator
@greeting("καλημερα")
def foo(x):
    print(42)
foo("Hi")

print("\n# decorator classes")
