# Напишите функцию f, которая на вход принимает два числа a и b, и возводит число a в целую степень b с помощью рекурсии.
# Функция не должна ничего выводить, только возвращать значение.

def f(a, b):
    if b == 1:
        return a
    return f(a, b - 1) * a

print(f(5, 5))