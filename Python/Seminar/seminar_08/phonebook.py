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
    secondname = input("Введите фамилию: ").strip()
    firstname = input("Введите имя: ").strip()
    surname = input("Введите отчество: ").strip()
    phonenumber = input("Введите номер телефона: ").strip()
    contact = {'secondname': secondname, 'firstname': firstname, 'surname': surname, 'phonenumber': phonenumber}

    return contact


def check_data(contact):
    contact = (";".join(contact.values())) + '\n'
    
    with open('phonebook.txt', 'r', encoding="utf-8") as file:
        for line in file:
            if line == contact:
                return True
    
    return False


def add_new_contact():
    contact = ask_data()

    if check_data(contact):
        print("Такой контакт уже существует!")
        return
    else:
        with open('phonebook.txt', 'a', encoding="utf-8") as file:
            for value in list(contact.values())[:-1]:
                file.write(f"{value};")
            file.write(list(contact.values())[-1] + '\n')


def write_file(table, name='phonebook.txt'):
    with open(name, 'w', encoding="utf-8") as file:
        for row in table:
            file.write(';'.join(row) + '\n')


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
    target_contact = []
    table = create_table()

    print_table(table)
    index = int(input("\nВведите порядковый номер контакта: ").strip())
    target_contact.append(table.pop(index - 1))

    write_file(target_contact, name=f'{'_'.join(target_contact[0][:-1])}.txt')


def delete_contact():
    table = create_table()
    
    print_table(table)
    index = int(input("\nВведите порядковый номер контакта: ").strip())
    print()
    table.pop(index - 1)

    write_file(table)


def change_contact():
    target_contact = []
    table = create_table()

    print_table(table)
    index = int(input("\nВведите порядковый номер контакта: ").strip())
    print()

    target_contact.append(table.pop(index - 1))
    print_table(target_contact)

    print("\nЗаполните данные заново")
    target_contact = ask_data()
    table.insert(index - 1, list(target_contact.values()))

    write_file(table)


def main():
    file = open('phonebook.txt', 'a')
    file.close()

    isStop = None
    while isStop != 0:
        print(f"\nГлавное меню:\n1 Посмотреть контакты \n2 Добавить контакт \n3 Поиск \n4 Скопировать контакт в визитную карточку \n5 Удалить контакт \n6 Изменить контакт \n0 Выход")
        isStop = int(input("\n>>> ").strip())
        print()
        if isStop == 1:
            print_table(create_table())
        elif isStop == 2:
            add_new_contact()
        elif isStop == 3:
            print_table(create_table(input("Поиск: ").lower().strip()))
        elif isStop == 4:
            copy_contact()
        elif isStop == 5:
            delete_contact()
        elif isStop == 6:
            change_contact()
        elif isStop == 7:
            check_data()
        input("\nНажмите Enter чтобы продолжить")


main()

