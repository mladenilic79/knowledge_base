
listt = [1, 2, 3, 4]

# for each

for i in listt:
    print("i = ", i)
else:
    print('if the loop is left by break, else statement will not be executed')

for char in "pero":
    print("char = ", char)

# for classic

# We can also have range define our list for us. range(10) will create a list
# starting at 0 and go up to but not include the value passed to it.
for i in range(4):
    print("i = ", i)

# define with len()
for i in range(len(listt)):
    print("j =", listt[i])

# with starting value
for i in range(2, 6):
    print("k = ", i)

# with step
for i in range(0, len(listt) - 1, 2):
    print("l =", i, listt[i])
