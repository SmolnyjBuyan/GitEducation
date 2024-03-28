watermelon_count = int(input("Введите количество арбузов: "))
watermelon_weights = []

for i in range(watermelon_count):
    weight = int(input(f"Масса {i + 1} арбуза: "))
    watermelon_weights.append(weight)

max_weight = watermelon_weights[0]
min_weight = watermelon_weights[0]

for i in range(1, watermelon_count):
    if (watermelon_weights[i] > max_weight):
        max_weight = watermelon_weights[i]
    if (watermelon_weights[i] < min_weight):
        min_weight = watermelon_weights[i]


print(f"Вес самого тяжелого арбуза: {max_weight}")
print(f"Вес самого легкого арбуза: {min_weight}")


