
# Any variable defined inside of a function is available only in that function
# You can't change a global variable even if it is passed into a function
# If you want to change global variable in method use global statement

global_name = "Sally"

def change_name():
    global global_name  # declare global variable inside the function
    global_name = "Sammy"

change_name()
print(global_name)
