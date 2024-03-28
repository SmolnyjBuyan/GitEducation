numbers = [2, 2, 2, 2, 2, 3, 4, 5]
print(len(set(numbers)))

counter = 1
for i in range(1, len(numbers)):
    for j in range(i , 0, -1):
        if numbers[i] == numbers[j - 1]:
            break
    else:
        counter += 1
    print(counter)

print(counter)

