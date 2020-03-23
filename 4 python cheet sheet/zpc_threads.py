
import threading
import time
import random


# ---------- EXAMPLE1 ----------
# function that will be started multiple times
def xthread(i):
    # print time at start moment
    print("Thread {} sleeps at {}"
          .format(i, time.strftime("%H:%M:%S", time.gmtime())))

    # sleep the thread 1 to 5 seconds
    random_sleep_time = random.randint(1, 5)
    time.sleep(random_sleep_time)

    # print time at wake moment
    print("Thread {} stops sleeping at {}"
          .format(i, time.strftime("%H:%M:%S", time.gmtime())))

# start 10 threads
for i in range(10):
    thread = threading.Thread(target=xthread, args=(i,))
    thread.start()

    # show number of thread that are currently executing
    print(threading.activeCount())

    # show all thread that are active at given time
    print(threading.enumerate())


# ---------- EXAMPLE2 ----------
# subclassing thread object
class CustThread(threading.Thread):

    # put name for identification
    def __init__(self, name):
        # initialize super class
        threading.Thread.__init__(self)
        self.name = name

    # this method executes automaticaly (run)
    def run(self):
        print("Thread {} sleeps at {}"
              .format(self.name, time.strftime("%H:%M:%S", time.gmtime())))

        randsleeptime = random.randint(1, 3)
        time.sleep(randsleeptime)

        print("Thread {} stops sleeping at {}"
              .format(i, time.strftime("%H:%M:%S", time.gmtime())))

# create two threads
thread1 = CustThread("1")
thread2 = CustThread("2")

# start threads
thread1.start()
thread2.start()

# method for checking if thread is alive
print("Thread 1 Alive :", thread1.is_alive())
print("Thread 2 Alive :", thread2.is_alive())

# get names of threads
print("Thread 1 Name :", thread1.getName())
print("Thread 2 Name :", thread2.getName())

# wait for thread to exit
thread1.join()
thread2.join()

print("execution ends")


# ---------- EXAMPLE3 ----------
# subclassing thread object and with thread lock
class BankAccount(threading.Thread):

    acctBalance = 100

    # name of person requesting, and quantity of money requested
    def __init__(self, name, moneyRequest):
        threading.Thread.__init__(self)
        self.name = name
        self.moneyRequest = moneyRequest

    # run runs automaticaly (in thread class)
    def run(self):
        threadLock.acquire()
        BankAccount.getMoney(self)
        threadLock.release()

    @staticmethod
    def getMoney(customer):
        print("{} tries to withdrawal ${} at {}".format(customer.name,
              customer.moneyRequest,
              time.strftime("%H:%M:%S", time.gmtime())))

        if BankAccount.acctBalance - customer.moneyRequest > 0:
            BankAccount.acctBalance -= customer.moneyRequest
            print("New account balance is : ${}".
                  format(BankAccount.acctBalance))
        else:
            print("Not enough money in the account")
            print("Current balance : ${}".format(BankAccount.acctBalance))


# lock thread in advance
threadLock = threading.Lock()

doug = BankAccount("Doug", 1)
paul = BankAccount("Paul", 100)
sally = BankAccount("Sally", 50)

doug.start()
paul.start()
sally.start()

doug.join()
paul.join()
sally.join()

print("Execution Ends")
