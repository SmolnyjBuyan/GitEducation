import random

N = int(input("Введите общее количество рассматриваемых дней: "))
max = 0
counter = 0

temperatures = [random.randint(-50, 51) for i in range(N)]
print(temperatures)

for i in temperatures:
    if i > 0:
        counter += 1
        if max < counter:
            max = counter
    else:
        counter = 0

print(max)
    