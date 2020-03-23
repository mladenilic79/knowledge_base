
# The decimal module provides for more accurate floating point calculations
from decimal import Decimal

num = Decimal(0)
num += Decimal("0.05")
num -= Decimal("0.03")

print(num)

num = 0
num += 0.05
num -= 0.03

print(num)
