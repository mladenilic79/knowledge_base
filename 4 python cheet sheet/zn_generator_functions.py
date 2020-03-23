
# A generator function returns a result when called
# They can be suspended and resumed during execution of your program to
# create results over time rather then all at once


# is this a prime number method
def is_prime(num):
    for i in range(2, num):
        if (num % i) == 0:
            return False
    return True


# This is the generator
def gen_primes(max_number):
    for num1 in range(2, max_number):
        if is_prime(num1):
            # yield is what makes this a generator
            # When called by next it will return the next result
            yield num1


# Create a reference to the generator
prime = gen_primes(50)

# Call next for each result
print("Prime :", next(prime))
print("Prime :", next(prime))
