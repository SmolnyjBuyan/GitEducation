# Дан массив, состоящий из целых чисел. Напишите
# программу, которая в данном массиве определит
# количество элементов, у которых два соседних и, при
# этом, оба соседних элемента меньше данного. Сначала
# вводится число N — количество элементов в массиве
# Далее записаны N чисел — элементы массива. Массив
# состоит из целых чисел.

# Ввод:             Ввод:
# 5                 5
# 1 2 3 4 5         1 5 1 5 1
# Вывод:            Вывод:
# 0                    2

def input_array(length):
    return [int(input(f"Введите {i+1} элемент массива: ")) for i in range(length)]

def compare_elements(array):
    count = 0
    for i in range(1, len(array)-1):
        if array[i - 1] < array[i] > array[i + 1]:
            count+=1
    return count


arr1 = input_array(int(input("Введите длину массива: ")))
print(arr1)
print(compare_elements(arr1))