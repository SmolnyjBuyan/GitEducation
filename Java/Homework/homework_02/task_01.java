// Дана строка sql-запроса:

// select * from students where "

// Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные (параметры) для фильтрации приведены в виде json-строки в примере ниже.
// Если значение null, то параметр не должен попадать в запрос.

// Напишите свой код в методе answer класса Answer. Метод answer принимает на вход два параметра:

// String QUERY - начало SQL-запроса String PARAMS - JSON с параметрами

// Пример: Строка sql-запроса:

// select * from students where 

// Параметры для фильтрации:

// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

// Результат:

// select * from students where name='Ivanov' and country='Russia' and city='Moscow'

public class task_01 {

    public static void main(String[] args) {
        String QUERY = "select * from students where ";
        String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        
        System.out.println(Answer.answer(QUERY, PARAMS));
    }
}

class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS) {
        StringBuilder sb = new StringBuilder(QUERY);
        String mask = PARAMS.replace("{", "")
                            .replace("}", "")
                            .replace("\"", "")
                            .replace(" ", "");
        
        String[] data = mask.split(",");
        String[][] dataDict = new String[data.length][data[0].split(":").length];

        for (int i = 0; i < data.length; i++) {
            dataDict[i] = data[i].split(":");
        }

        int counter = 0;
        for (int i = 0; i < dataDict.length; i++) {
            if (!dataDict[i][1].equals("null")){
                counter++;
            }
        }

        String[] result = new String[counter];

        for (int i = 0; i < result.length; i++) {
            if (!dataDict[i][1].equals("null")) {
                result[i] =  String.format("%s='%s'", dataDict[i][0], dataDict[i][1]);
            }
        }

        sb.append(String.join(" and ", result));
        return sb;
    }
}