import os
import re

ppath = 'e:/music original/'

for oldname in os.listdir(ppath):
    print(oldname)
    regex = re.compile(r'[ ]+.mp3$')
    newname = regex.sub('.mp3', oldname)
    print(newname)
    oldfile = os.path.join(ppath, oldname)
    print(oldfile)
    newfile = os.path.join(ppath, newname)
    print(newfile)
    os.rename(oldfile, newfile)
