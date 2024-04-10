# numbers = [1, 2, 3, 5, 8, 15, 23, 38]

# for e in numbers:
#     if e % 2 == 0:


# numbers = [1, 2, 3, 5, 8, 15, 23, 38]
# res = map(int, numbers)
# res = filter(lambda x: x % 2 == 0, res)
# res = list(map(lambda x: (x, x * x), res))
# print(res)

# import random
# numbers = [random.randint(1,100) for i in range(10)]
# print(numbers)
# is_odd = lambda number: False if number % 2 else True

# arr = list(filter(is_odd, numbers))
# print(arr)

# numbers = [2, 4, 6, 8, 10, 12]
# carbons = [58, 46, 34, 22, 10, 8]
# union = []
# print(list(zip(numbers,carbons)))
# for num1, num2 in zip(numbers, carbons):
#     union.append(num1 + num2)
# print(union)

from math import factorial

numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
factorials = list(map(factorial, numbers))
print(factorials)