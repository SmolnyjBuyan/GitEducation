# Даны два неупорядоченных набора целых чисел (может быть, с повторениями). Выдать без повторений в порядке возрастания все те числа, которые встречаются в обоих наборах.
# На вход подается 2 числа через пробел: n m
# n - кол-во элементов первого множества.
# m - кол-во элементов второго множества.
# Затем подаются элементы каждого множества через пробел в виде строки. ! Писать input() не надо

# На входе:
# var1 = '5 4' # количество элементов первого и второго множества
# var2 = '1 3 5 7 9' # элементы первого множества через пробел
# var3 = '2 3 4 5' # элементы второго множества через пробел

# На выходе:
# 3 5

var1 = '5 5'
var2 = '10 20 30 40 50'
var3 = '10 20 30 40 50'

var2 = var2.split()
var3 = var3.split()

var2 = [int(i) for i in var2]
var3 = [int(i) for i in var3]

first_numbers = set(var2)
second_numbers = set(var3)


cross_numbers = sorted(set.intersection(first_numbers, second_numbers))

# print(first_numbers)
# print(second_numbers)
# print(cross_numbers)

for i in cross_numbers:
    print(i, end = " ")