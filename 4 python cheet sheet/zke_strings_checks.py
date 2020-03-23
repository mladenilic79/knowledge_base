
samp_string = "  This is a an very important string  "

# Returns True if characters are letters or numbers, Whitespace is false
isalphanumeric = samp_string.isalnum()

# Returns True if characters are letters
isalpha = samp_string.isalpha()

# Returns True if characters are numbers (Floats are False)
isnumeric = samp_string.isdigit()

# Returns True if characters are decimal
isdecimal = samp_string.isdecimal()

# Returns True if all are lowercase/uppercase
isAllLower = samp_string.islower()
isAllUpper = samp_string.isupper()

# Returns True if all are spaces
isSpaces = samp_string.isspace()

startsWith = samp_string.startswith("ring")
# str.startswith(prefix[, start[, end]])
endsWith = samp_string.endswith("ring")
# str.endswith(suffix[, start[, end]])
