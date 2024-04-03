def check_simple_digit(number):
    if number < 2:
        print("no")
        return
    for i in range(2, number // 2):
        if number % i == 0:
            print("no")
            break
    else:
        print("yes")

check_simple_digit(19)

# def is_prime(number, ):
#     if number
#     return (number - 1)