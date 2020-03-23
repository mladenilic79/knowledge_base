
# Create a class that inherits from Exception
class animalNameError(Exception):
    pass

# raise & catch
try:
    dogName = input("What is your dogs name : ")
    if any(char.isdigit() for char in dogName):
        raise animalNameError
except animalNameError:
    print("Your dogs name can't contain a number")

# raise only
catName = input("What is your cat name : ")
if any(char.isdigit() for char in catName):
    raise animalNameError("Your cat name can't contain a number")
