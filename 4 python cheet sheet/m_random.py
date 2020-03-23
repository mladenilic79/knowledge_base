
import random

# Generate a random integer between 1 and 50
rand_value = random.randrange(1, 51)
print(rand_value)

# generate a random number between 0 and 1
rand_value = random.random()
print(rand_value)

# pick value from list
listt = ["a", "b", "c"]
rand_value = random.choice(listt)
print(rand_value)