

# try catch block
while True:
    try:
        number = int(input("Please enter a number : "))
        # break
    # You can catch multiple exceptions by separating them
    # with commas inside parentheses
    except (ValueError, IndexError, NameError):
        print("You didn't enter a number")
    # We can use as to access data and methods in the exception class
    except FileNotFoundError as ex:
        print("That file was not found")
        print(ex)
        print(ex.args)
    # except with pharenteses will explain the error
    except():
        print("An unknown error occurred")
    # except without pharentheses will not explain the error
    # If the exception wasn't caught above this will
    # catch all others (put exeptions in order)
    except:
        print("An unknown error occurred")
        raise
    # or
        raise Exception('unknown error')
    # else is only executed if no exception was raised
    else:
        print("You didn't raise an exception")
    finally:
        print("I execute no matter what")


# manually raising/throwing exceptions
x = 10
if x > 5:
    raise Exception
# or
    raise NameError('HiThere')
    raise Exception('x should not exceed 5. The value of x was: {}'.format(x))
