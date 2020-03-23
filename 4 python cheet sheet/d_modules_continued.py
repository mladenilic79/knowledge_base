
# You can import module by listing the file name minus the py
import c_modules
# When you use import you access methods by referencing the module & method
print("Sum :", c_modules.add(1, 2))

# when use from you specify which methods will be imported (one, more or all)
from c_modules import add
from c_modules import add, mult
from c_modules import *
# You don't have to reference the module name now
print("Sum :", add(1, 2))

# We create an alias to avoid conflicts with methods with the same name
from c_modules import add as a
print("Sum :", a(1, 2))
