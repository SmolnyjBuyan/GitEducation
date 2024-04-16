# Создать телефонный справочник с
# возможностью импорта и экспорта данных в
# формате .txt. Фамилия, имя, отчество, номер
# телефона - данные, которые должны находиться
# в файле.
# 1. Программа должна выводить данные
# 2. Программа должна сохранять данные в
# текстовом файле
# 3. Пользователь может ввести одну из
# характеристик для поиска определенной
# записи(Например имя или фамилию
# человека)
# 4. Использование функций. Ваша программа
# не должна быть линейной

import pandas as pd


def ask_data():
    secondname = input("Введите фамилию: ")
    firstname = input("Введите имя: ")
    surname = input("Введите отчество: ")
    phonenumber = input("Введите номер телефона: ")
    contact = {'secondname': secondname, 'firstname': firstname, 'surname': surname, 'phonenumber': phonenumber}

    return contact


def add_new_contact():
    contact = ask_data()

    with open('phonebook.txt', 'a', encoding="utf-8") as file:
        for value in list(contact.values())[:-1]:
            file.write(f"{value};")
        file.write(list(contact.values())[-1] + '\n')


def create_table(mask=None):
    table = []

    with open('phonebook.txt', 'r', encoding="utf-8") as file:
        if mask != None:
            for line in file:
                if mask in line.lower():
                    table.append(line.strip().split(";"))
        else:
            for line in file:
                table.append(line.strip().split(";"))

    return table


def print_table(table):
    df = pd.DataFrame(table, columns = ['Фамилия', 'Имя', 'Отчество', 'Номер телефона'])
    df.index = range(1, len(table) + 1)
    print(df)


def copy_contact():
    table = create_table()
    print_table(table)
    
    index = int(input("Введите порядковый номер контакта: "))
    with open(f'{'_'.join(table[index - 1][:-1])}.txt', 'w', encoding="utf-8") as file:
        file.write(' '.join(table[index - 1]))


def delete_contact():
    table = create_table()
    print_table(table)

    index = int(input("Введите порядковый номер контакта: "))
    table.pop(index - 1)
    with open('phonebook.txt', 'w', encoding="utf-8") as file:
        for row in table:
            file.write(';'.join(row) + '\n')


def main():
    isStop = None
    while isStop != 0:
        print()
        print(f"Главное меню:\n1 Посмотреть контакты \n2 Добавить контакт \n3 Поиск \n4 Скопировать контакт в визитную карточку \n5 Удалить контакт \n0 Выход")
        isStop = int(input(">>> "))
        print()
        if isStop == 1:
            print_table(create_table())
        elif isStop == 2:
            add_new_contact()
        elif isStop == 3:
            print_table(create_table(input("Поиск: ").lower()))
        elif isStop == 4:
            copy_contact()
        elif isStop == 5:
            delete_contact()
        input("\nНажмите Enter чтобы продолжить")


main()

