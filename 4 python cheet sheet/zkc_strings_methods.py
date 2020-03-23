
samp_string = "  This is a an very important string  "

# ---------- MODIFICATION ----------

# Delete whitespace on left/right/both
leftStrip = samp_string.lstrip()
rightStrip = samp_string.rstrip()
bothStrip = samp_string.strip()

# Capitalize the 1st letter, all upper or all lower
capitalize = samp_string.capitalize()
upper = samp_string.upper()
lower = samp_string.lower()
title = samp_string.title()

justString1 = samp_string.ljust(50, "k")
justString2 = samp_string.rjust(50, " ")

# ---------- SUBSTRING ----------

# Count how many times a string occurs in a string
countStrin = samp_string.count("is")

# Get first / last index of matching string (raises error on failure)
indexOfString1 = samp_string.index("string")
indexOfString2 = samp_string.rindex("string")

# Get first / last index of matching string (ne error on failure)
indexOfString3 = samp_string.find("string")
indexOfString4 = samp_string.rfind("string")

# Replace a substring
newString = samp_string.replace("an ", "a kind of ")
