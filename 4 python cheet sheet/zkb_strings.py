
# ---------- BASICS ----------

# Single or double quotes are both used for strings

# in double quotes backslash need to be used for escaping double quotes
samp_string = "This it's a very \" important string"
samp_string4 = """triple string can
                span multiple lines"""

# in single quotes backslash need to be used for escaping single quotes
samp_string2 = 'This it\'s a very " important string'
samp_string3 = '''triple string can 
                span multiple lines'''

# ---------- CONCATENATION ----------

# Join or concatenate strings
newString1 = "Green " + "Eggs"
newString2 = "Green " "Eggs"

# ---------- UNICODE ----------

# Computers assign characters with a number known as a Unicode
# A-Z have the numbers 65-90 and a-z 97-122

# You can get the Unicode code with ord()
print("A =", ord("A"))

# You can convert from Unicode with chr
print("65 =", chr(65))
