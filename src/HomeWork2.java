
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.*;

public class HomeWork2 {
    Logger logger;

    public static void main(String[] args) {
        new HomeWork2();
    }
    public HomeWork2() {
        try {
            LogManager.getLogManager().readConfiguration(HomeWork2.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger = Logger.getLogger(HomeWork2.class.getName());
        logger.setLevel(Level.INFO);




        Task3();


    }
    public void Task1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("select * from students where ");

        //{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        String json = "[{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"},{\"nameff\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}]";
        //Как я понял мы изучаем Java Core,
        // и json нельзя использовать
        // А мапы можно)))

        for(String text : partJson(json)) {
            HashMap<String,String> map = new HashMap<String,String>();
            for(String spttext : text.split(",")) {

                String[] sp = spttext.split(":");
                if(!sp[1].equals("null")) {
                    map.put(sp[0], sp[1]);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            for (Map.Entry<String, String> key : map.entrySet()) {
                if (key.getKey() != null && key.getValue() != null) {
                    if(map.size() == i) {
                        stringBuilder.append(key.getKey()).append(" = '").append(key.getValue()).append("'");
                    }
                    else {
                        stringBuilder.append(key.getKey()).append(" = '").append(key.getValue()).append("' and ");
                    }
                    i+=1;
                }
            }
            System.out.println(stringBuilder.toString());
        }


    }
    public String[] partJson(String json) { //разделяет если будет такое [{name='123132'}, {name='1231234'}]
        String[] args = new String[json.split("\\{").length-1];

        json = json.replaceAll("[ \"\\[\\]]", "");
        for(int i = 1; json.split("\\{").length > i; i++) {
            args[i-1] = json.split("\\{")[i].replace("}", "");

        }
        return args;
    }
    public void Task2() {
        int[] numbers = { 423, 534, 634, 23412, 5342324, 53241 };
        int temp;
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j + 1];
                    logger.log(Level.INFO,Arrays.toString(numbers));
                    numbers[j + 1] = numbers[j];

                    logger.log(Level.INFO,"Заменяем: " + numbers[j + 1] + " на " + numbers[j]);
                    numbers[j] = temp;
                    logger.log(Level.INFO,Arrays.toString(numbers));
                    logger.log(Level.INFO,"Заменяем: " + numbers[j] + " на " + temp);
                    logger.log(Level.INFO,Arrays.toString(numbers));
                }
            }
        }
    }
    public void Task3() {
        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        for(String str : method(json))  {
            System.out.println(str);
        }
    }
    public String[] method(String json) {
        String[] res = new String[json.split("\\{").length-1];
        int i = 0;
        for(String text : partJson(json)) {
            HashMap<String,String> map = new HashMap<String,String>();
            StringBuilder stringBuilder = new StringBuilder("");
            for(String spttext : text.split(",")) {

                String[] sp = spttext.split(":");

                map.put(sp[0], sp[1]);
                if(sp[0].equals("фамилия")) {
                    stringBuilder.append("Студент " + sp[1] + " ");
                }
                else if(sp[0].equals("оценка")) {
                    stringBuilder.append("получил " + sp[1] + " ");
                }
                else if(sp[0].equals("предмет")) {
                    stringBuilder.append("по предмету " + sp[1] + " ");
                }
            }
            res[i] = stringBuilder.toString();
            i++;
        }
        return res;
    }
    public void Task4() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число #1: ");
        int num1 = scan.nextInt();
        System.out.print("Введите число #2: ");
        int num2 = scan.nextInt();
        System.out.print("Введите операцию: ");
        String op = scan.next();
        switch (op) {
            case "*":
                System.out.println("Ответ: " + (num1 * num2));
                logger.log(Level.INFO,"Ответ: " + (num1 * num2));
                break;
            case "/":
                System.out.println("Ответ: " + (num1 / num2));
                logger.log(Level.INFO,"Ответ: " + (num1 / num2));
                break;
            case "+":
                System.out.println("Ответ: " + (num1 + num2));
                logger.log(Level.INFO,"Ответ: " + (num1 + num2));
                break;
            case "-":
                System.out.println("Ответ: " + (num1 - num2));
                logger.log(Level.INFO,"Ответ: " + (num1 - num2));
                break;
        }
    }
}
