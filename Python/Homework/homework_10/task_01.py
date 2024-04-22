import random
import pandas as pd

lst = ['robot'] * 10
lst += ['human'] * 10
random.shuffle(lst)
data = pd.DataFrame({'whoAmI':lst})
data.head()
print(data)

def one_hot_view(dataframe, column):
    values = list(set(dataframe[column]))
    rows = list(dataframe[column])
    one_hot = []
    one_hot_temp = []
    for row in rows:
        for value in values:
            if row == value:
                one_hot_temp.append(1)
            else:
                one_hot_temp.append(0)
        one_hot.append(one_hot_temp)
        one_hot_temp = []

    df = pd.DataFrame(one_hot, columns=values)
    return df

print(one_hot_view(data, 'whoAmI'))
