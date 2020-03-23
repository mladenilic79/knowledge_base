
# Convert between string, int, float
int_type2, int_type3 = int("34"), int(3.5)
float_type2, float_type3 = float("23"), float(65)
string_type2, string_type3 = str(87), str(3.6)

# convert between int and hexadecimal, binary & octal string representations
hex_string = hex(33)
int_num_1 = int(hex_string, 16)
oct_string = oct(22)
int_num_2 = int(oct_string, 8)
bin_string = bin(99)
int_num_3 = int(bin_string, 2)

# convert between byte string and string
byte_string = b"Hallo"
string = byte_string.decode("UTF-8")
byte_string = string.encode("UTF-8")
