# Заполните массив элементами арифметической прогрессии. Её первый элемент a1,
# разность d и количество элементов n будет задано автоматически.
# Формула для получения n-го члена прогрессии: an = a1 + (n-1) * d.

# Пример

# На входе:

# a1 = 2
# d = 3
# n = 4

# На выходе:

# 2
# 5
# 8
# 11

a1 = 2
d = 3
n = 4

def find_arithmetic_progression(first_number, difference, count_numbers):
    for i in range(1, count_numbers + 1):
        print(first_number + (i - 1) * difference)
    
find_arithmetic_progression(a1, d, n)

