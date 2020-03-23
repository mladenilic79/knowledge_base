
class MainClass:

    # self allows an object to refer to itself (instance)

    # public class/static variable
    class_variable = 0

    # The init method is called to create an object
    # We give default values for the fields if none are provided
    def __init__(self,
                 instance_variable_private="private",
                 instance_variable_public="public",
                 instance_variable_protected="protected"):

        # private, means nobody can touch this from outside a class
        self.__instance_variable_private = instance_variable_private

        # protected by convention, means don't touch this unless
        # you are a subclass, otherwise the same as public
        self._instance_variable_protected = instance_variable_protected

        # public
        self.instance_variable_public = instance_variable_public

        # class/static variables usefull for counters
        MainClass.class_variable += 1

        print("class created")

    # public instance/object method
    def instance_method(self, random_variable):

        # access instance variables
        print(self.__instance_variable_private)
        print(self._instance_variable_protected)
        print(self.instance_variable_public)

        # static/class variable unique to class / to all instances
        print(MainClass.class_variable)

        # static varibale can be also redeclared separately in any instance
        print(self.class_variable)

        # accessing rangom variable
        print(random_variable)

        # adding instance variable through instance method
        self.random_variable = random_variable

    # private method (all else the same as public method)
    def __private_instance_method(self, random_variable):

        print(random_variable)

    @classmethod
    # Static methods allow access without the need to initialize a class
    # They receives class as a first argument
    def class_method(cls, set_class_variable, new_class_variable, random_variable):

        # accessing class/static variable
        print(cls.class_variable)

        # setting class variable
        cls.class_variable = set_class_variable

        # new class variable instantiation inside class method
        cls.new_class_variable = new_class_variable

        # creating new instance/object through class method
        new_object = cls(random_variable)
        return new_object

    # if there is no reference to instance or class use static method
    @staticmethod
    def static_method(set_class_variable, new_class_variable, random_variable):

        # access class variable
        print(MainClass.class_variable)

        # setting class variable
        MainClass.class_variable = set_class_variable

        # set new class variable
        MainClass.new_class_variable = new_class_variable

        # creating new instance/object through static method
        new_object = MainClass(random_variable)
        return new_object

    # getter (access function in main like an argument without parenthasis)
    @property # is @property just a synthatic sugar ?????????????
    def instance_variable_private(self):
        # Put a __ before this private field
        return self.__instance_variable_private

    # getter.. same as:
    # def instance_variable_private(self):
    #     return self.__instance_variable_private
    # instance_variable_private = property(instance_variable_private)

    # setter (access function in main like an argument without parenthasis)
    @instance_variable_private.setter # is @name.setter just a synthatic sugar ?????????????
    def instance_variable_private(self, instance_variable_private):
        # put data checks in body here
        # Put a __ before this private field
        self.__instance_variable_private = instance_variable_private

    # deleter (access function in main like an argument without parenthasis)
    @instance_variable_private.deleter # is @name.deleter just a synthatic sugar ?????????????
    def instance_variable_private(self):
        # Put a __ before this private field
        self.__instance_variable_private = None

    # str magic method can be used to cast our object as a string
    # type(self).__name__ returns the class name
    def __str__(self):
        return "A {} is {} it is {}".format(type(self).__name__,
                                            self.instance_variable_private,
                                            self.__instance_variable_private,
                                            self._instance_variable_protected,
                                            self.instance_variable_public)


mainClass = MainClass()

# direct access to attributes
print(mainClass.instance_variable_public)

# getter
print(mainClass.instance_variable_private)
# setter
mainClass.instance_variable_private = "perovic"

# methods
mainClass.instance_method("random variable")
mainClass.class_method(3, "random var 2", "random var 3")
mainClass.static_method(3, "random var 2", "random var 3")

# calling to string
print(mainClass)

# check if is instance
print(isinstance(mainClass, MainClass))

# two ways to call for field and methods
print(mainClass.instance_method("random variable"))
print(MainClass.instance_method(mainClass, "random variable"))
