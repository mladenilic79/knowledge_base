
import os

# example data for windows/linux

# windows

# linux
directory_path = '/home/mmm/Desktop'
file_path = '/test.txt'
full_path = directory_path + file_path
# or with method and no double slash
full_path_2 = os.path.join('/home/mmm/Desktop', 'test.txt')

# ---------- DIRS ----------

# Display current directory
current_working_directory = os.getcwd()
print(current_working_directory)

# List directory
list_of_files_in_current_working_directory = os.listdir(directory_path)
print(list_of_files_in_current_working_directory)

# Loop through directory
for files in os.listdir(directory_path):
    print(files)

# Create a directory inside current working directory
os.mkdir("mydir")

# Change directories to specified path
os.chdir("mydir")

# move back 1 directory
os.chdir("..")

# Remove a directory
os.rmdir("mydir")

# ---------- READ / WRITE ----------

# create or use an already created file with open, which requires closing
# with with guarantees the file will be closed if the program crashes
# Text is stored using unicode where numbers represent all characters

# If you use w (write) for mode then the file is overwritten.
# If you use a (append) you add to the end of the file

# encoding optional
# mode is optional for reading

# write
myFile = open(full_path, mode='a', encoding='utf-8')
myFile.write('ttext\nttext')
myFile.close()

# read
myFile = open(full_path, encoding='utf-8')
for line in myFile:
    print(line)
myFile.close()

# with write
with open(full_path, mode="w", encoding="utf-8") as myFile:
    myFile.write("Some random text\nMore random text\nAnd some more")

# with read, For reading do not provide a mode at all
with open(full_path, encoding="utf-8") as myFile:

    # We can read data in a few ways

    # 1. basic
    for line in myFile:
        print(line)

    # 2. read() read everything into string or number of characters provided
    read_string = myFile.read()
    read_string = myFile.read(10)
    print(read_string)

    # 3. readline() reads one line up to newline (\n)
    lineNum = 1
    while True:
        line = myFile.readline()
        # if there is no more lines of data to read
        if not line:
            break
        print("Line", lineNum, " :", line, end="")

        wordList = line.split()
        print(wordList)

        lineNum += 1

    # 4. readlines() returns a list of lines (\n included in each)
    line_list = myFile.readlines()
    print(line_list)

# ---------- FILES ----------

# Get the file name
print(myFile.name)

# Get the access mode of the file
print(myFile.mode)

# Find out if the file is closed
print(myFile.closed)

# Rename our file
os.rename(full_path, full_path_2)

# Delete a file
os.remove(full_path_2)
