
print("# You can return multiple values with the return statement")
def mult_divide(num_1, num_2):
    a = num_1 * num_2
    b = num_1 / num_2
    tuplee = (a, b)
    return tuplee
tuplee = mult_divide(5, 4)
print(tuplee)
print()

print("# We can receive an unknown number of arguments using the splat (*) operator")
def print_all(*args):
    print(type(args))
    return args
print(print_all(3, 4, 5))
print(print_all([3, 4, 5]))
print(print_all((3, 4, 5)))
print(print_all(*[3, 4, 5]))
print(print_all(*(3, 4, 5)))
print()

print("# receive an unknown number of positional arguments using the double (**)")
def print_all(**kwargs):
    print(type(kwargs))
    return kwargs
print(print_all(jedan=3, dva=4, tri=5))
print()

print("# unpack with splat and double")
def print_all(a, b, x):
    print(a, b, x)
list = [1, 3, 5]
print_all(*list)
tuple = (1, 3, 5)
print_all(*tuple)
dict = {'a':'append', 'b':'block','x':'extract'}
print_all(*dict)
print_all(**dict)
