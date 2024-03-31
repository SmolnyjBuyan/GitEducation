i = 0
max = 0

while True:
    number = int(input(f"Введите {i + 1} число последовательности: "))
    if number == 0:
        break
    elif number < 0:
        print("Число должно быть неотрицательным")
        continue
    else:
        if number > max:
            max = number
    i+=1

print(f"Максимальное число: {max}")