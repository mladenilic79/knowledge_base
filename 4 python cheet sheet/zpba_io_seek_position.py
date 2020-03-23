
file = open('/home/mmm/Desktop/mouse_speed.txt')

# tell returns current position of reader
a = file.tell()
print('check position: ', a)

# read reads string
a = file.read(10)
print('read something: \n' + a)

a = file.tell()
print('check position: ', a)

# move position of reader
a = file.seek(2)
print('move position to: ', a)

a = file.tell()
print('check position: ', a)

# or move relative based on current position
a = file.seek(file.tell() +5)
print('move position to: ', a)

a = file.tell()
print('check position: ', a)
