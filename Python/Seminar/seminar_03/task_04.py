numbers = [1, 3, 4, 6, 7, 8, 43, 65, 67]

shifted_numbers = []
shift = 19

if shift >= len(numbers):
    shift %= len(numbers)
    print(f"Смещение: {shift}")


for i in range(len(numbers)):
    shift_index = i + shift
    if shift_index >= len(numbers):
        shift_index -= len(numbers)
    shifted_numbers.insert(shift_index, numbers[i])
    print(shifted_numbers)