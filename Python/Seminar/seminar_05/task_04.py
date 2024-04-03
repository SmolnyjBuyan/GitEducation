def print_numbers(length):
    if length == 0:
        return
    number = int(input("Введите число: "))
    print_numbers(length - 1)
    print(number, end = " ")

print_numbers(4)