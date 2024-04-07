# Два различных натуральных числа n и m называются
# дружественными, если сумма делителей числа n
# (включая 1, но исключая само n) равна числу m и
# наоборот. Например, 220 и 284 – дружественные числа.
# По данному числу k выведите все пары дружественных
# чисел, каждое из которых не превосходит k. Программа
# получает на вход одно натуральное число k, не
# превосходящее 105
# . Программа должна вывести все
# пары дружественных чисел, каждое из которых не
# превосходит k. Пары необходимо выводить по одной в
# строке, разделяя пробелами. Каждая пара должна быть
# выведена только один раз (перестановка чисел новую
# пару не дает).

# Ввод:     Вывод:
# 300       220 284

k = 300

def calculate_sum_of_denominators(number):
    sum = 0
    for i in range(1, number // 2 + 1):
        if number % i == 0:
            sum = sum + i
    return sum

def is_amicable(first_number, second_number):
    if calculate_sum_of_denominators(first_number) == second_number \
        and calculate_sum_of_denominators(second_number) == first_number:
        return True
    else:
        return False
        
def find_amicable_numbers(last_number):
    for i in range(1, last_number):
        for j in range(i + 1, last_number):
            if is_amicable(i, j):
                print(i, j)


find_amicable_numbers(k)