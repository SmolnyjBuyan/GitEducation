numbers = [0, -1, 5, 2, 3]
counter = 0
comparison_of_numbers = []

for i in range(1, len(numbers)):
    if numbers[i] > numbers[i - 1]:
        counter += 1
        comparison_of_numbers.append(f'{numbers[i - 1]} < {numbers[i]}')

print(counter, comparison_of_numbers)
