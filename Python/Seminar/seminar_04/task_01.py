# input_string = "a a a b c a a d c d d"
input_string = input("Введите строку: ")
split_string = input_string.split(' ')

print(split_string)

for i in range(len(split_string)):
    if split_string[0: i].count(split_string[i]) != 0:
        print(f"{split_string[i]}_{split_string[0: i].count(split_string[i])}", end =' ')
    else:
        print(f"{split_string[i]}", end =' ')