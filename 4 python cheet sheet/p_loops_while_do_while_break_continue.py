
# ---------- BASICS ----------
# The value we increment in the while loop is defined before the loop
i = 1
# Define the condition that while true we will continue looping
while i < 5:
    # You must increment your iterator inside the while loop
    i += 1
    print(i)

# ---------- BREAK AND CONTINUE ----------
i = 1
while i < 10:
    if (i % 2) == 1:
        i += 1
        continue
    if i == 8:
        break
    i += 1
    print(i)
else:
    print('if the loop is left by break, else statement will not be executed')

# ---------- DO WHILE LOOP - IMPLEMENTATION ----------
# By giving the while a value of True it will cycle until a break is reached
i = 1
while True:
    if i == 5:
        break
    i += 1
    print(i)
