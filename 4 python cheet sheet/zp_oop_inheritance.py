
# a class can inherit all of the fields and methods from another class
# That class is the subclass and the class we inherit from is the super class
# You can inherit from multiple classes by separating them with a comma

from zo_oop_base_class import MainClass

class SubClass(MainClass):

    def __init__(self,
                 instance_variable_private="born alive",
                 instance_variable_public="warm blooded",
                 instance_variable_added=True):

        # Call for the super class to initialize fields
        super().__init__(instance_variable_private, instance_variable_public)
        # or use:
        # MainClass.__init__(self, instance_variable_private, instance_variable_public)

        # instanciate missing variable
        self.__instance_variable_added = instance_variable_added

    # We can extend the subclasses (add setters & getters)
    @property
    def instance_variable_added(self):
        return self.__instance_variable_added

    @instance_variable_added.setter
    def instance_variable_added(self, instance_variable_added):
        self.__instance_variable_added = instance_variable_added

    # Overwrite __str__ (to string like method)
    # You can use super() to refer to the superclass
    def __str__(self):
        return super().__str__() + " and it is {} they nurse " \
                                   "their young".format(self.instance_variable_added)

subClass = SubClass()

# setter
subClass.instance_variable_added = "simovic"
# getter
print(subClass.instance_variable_added)

# check if is subclass
is_this_a_subclass = issubclass(SubClass, MainClass)
print(is_this_a_subclass)