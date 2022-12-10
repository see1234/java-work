import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        new HomeWork1();
    }
    public HomeWork1() {
        Task4();
    }
    public void Task1() {
        //Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scan.nextInt();
        int T = (n*(n+1))/2; //Формула треугольного числа
        System.out.println("Треугольное число: " + T);
        System.out.println("Факториал: " + factorial(n, 1));
        scan.close();
    }
    public void Task2() {
        //Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        printDeletions(1000);

    }
    public void Task3() {
        //Реализовать простой калькулятор
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число #1: ");
        int num1 = scan.nextInt();
        System.out.print("Введите число #2: ");
        int num2 = scan.nextInt();
        System.out.print("Введите операцию: ");
        String op = scan.next();
        switch(op) {
            case "*":
                System.out.println("Ответ: " + (num1*num2));
                break;
            case "/":
                System.out.println("Ответ: " + (num1/num2));
                break;
            case "+":
                System.out.println("Ответ: " + (num1+num2));
                break;
            case "-":
                System.out.println("Ответ: " + (num1-num2));
                break;
        }

        scan.close();

    }

    public void Task4() {
        String q = "2?";
        String w = "?5";
        String e = "69";
        int countq = q.length() - q.replace("?", "").length();
        int countw = w.length() - w.replace("?", "").length();
        int counte = e.length() - e.replace("?", "").length();
        String voprosq = "";
        for(int i = 0; i < countq; i++) {
            voprosq+="?";
        }
        String voprosw = "";
        for(int i = 0; i < countw; i++) {
            voprosw+="?";
        }
        String voprose = "";
        for(int i = 0; i < counte; i++) {
            voprose+="?";
        }
        for(int i = 0; i < countq * 10; i++) {
            for(int j = 0; j < countw * 10; j++) {


                if(Integer.parseInt(q.replace(voprosq, i + "")) + Integer.parseInt(w.replace(voprosw, j + "")) == Integer.parseInt(e)) {
                    System.out.println(q.replace(voprosq, i + "") + " + " + w.replace(voprosw, j + "") + " = " + e);

                }
            }
        }//дальше куча можно сделать, ну думаю оставлю на таком
    }
    public void printDeletions(int max) {
        int a = 0;
        for(int i = 2; i <= max; i++) {
            for(int j = 2; j < i; j++) {
                if (i % j == 0) {
                    a++;
                    break;
                }
            }
            if (a == 0) {
                System.out.print(i + " ");
            }
            else {
                a=0;
            }
        }

    }
    public int factorial(int n, int res) {
        if (n == 0) {
            return res;
        }
        res*=n--;
        return factorial(n, res);
    }
}
