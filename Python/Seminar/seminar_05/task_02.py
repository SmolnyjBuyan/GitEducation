input_grades = [1, 3, 3, 3, 4]

def change_maxgrades(grades):
    maximum = max(grades)
    minimum = min(grades)
    for i in range(len(grades)):
        if grades[i] == maximum:
            grades[i] = minimum
    return grades


print(change_maxgrades(input_grades))