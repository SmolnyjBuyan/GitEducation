# Требуется найти в массиве list_1 самый близкий по значению элемент к заданному числу k и вывести его.
# Считать, что такой элемент может быть только один. Если значение k совпадает с этим элементом - выведите его.

# Пример:

# list_1 = [1, 2, 3, 4, 5]
# k = 6
# 5

list_1 = [0, 3, 4, 5, 7, -10]
k = 1

min_difference_index = 0
for i in range(1, len(list_1)):
    if abs(k - list_1[i]) < abs(k - list_1[min_difference_index]):
        min_difference_index = i

print(list_1[min_difference_index])
