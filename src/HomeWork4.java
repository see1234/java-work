import java.util.*;

public class HomeWork4 {
   public static void main(String[] args) {
       Task3();
   }

    public static void Task1() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0; i < 10; i++) {
            linkedList.add(new Random().nextInt(100));
        }
        System.out.println(linkedList);
        reverse(linkedList);
        System.out.println(linkedList);

    }
    public static void Task2() {
        Queue<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0; i < 10; i++) {
            linkedList.add(new Random().nextInt(100));
        }
        System.out.println(linkedList);
        enqueue((LinkedList<Integer>) linkedList, 10);
        System.out.println(linkedList);
        System.out.println(dequeue((LinkedList<Integer>) linkedList, 10));
        System.out.println(linkedList);
        System.out.println(first((LinkedList<Integer>) linkedList, 10));
    }
    public static void Task3() {
        //Реализовать простой калькулятор
        Scanner scan = new Scanner(System.in);
        int num1 = 0;
        boolean exit = true;
        System.out.println("Система отката слово 'откат'");
        Stack<Integer> calc = new Stack<Integer>();
        calc.push(0);
        while(exit) {
            String op = "";
            while(true) {

                System.out.print("Введите операцию (*,/,+,-,откат,exit): ");

                op = scan.next();
                if (op.equals("*") || op.equals("/") || op.equals("+") || op.equals("-") || op.equals("откат") || op.equals("exit")) {
                   break;
                }
            }
            int num2;
            if(num1 == 0) {
                System.out.print("Введите число: ");
                num1 = scan.nextInt();
            }
            switch (op) {

                case "*":

                    System.out.print("Введите число: ");
                    num2 = scan.nextInt();
                    num1=(num1 * num2);

                    System.out.println("Ответ: " + num1);
                    calc.push(num1);
                    break;
                case "/":

                    System.out.print("Введите число: ");
                    num2 = scan.nextInt();
                    num1=(num1 / num2);
                    System.out.println("Ответ: " + num1);
                    calc.push(num1);
                    break;
                case "+":

                    System.out.print("Введите число: ");
                    num2 = scan.nextInt();
                    num1=(num1 + num2);
                    System.out.println("Ответ: " + num1);
                    calc.push(num1);
                    break;
                case "-":

                    System.out.print("Введите число: ");
                    num2 = scan.nextInt();
                    num1=(num1 - num2);
                    System.out.println("Ответ: " +  num1);
                    calc.push(num1);
                    break;
                case "exit":
                    scan.close();
                    exit = false;
                    break;
                case "откат":
                    System.out.println("Удаленное число: " +  calc.pop());
                    num1 = calc.get(calc.size()-1);
                    break;
            }
        }


    }
    public static void enqueue(LinkedList<Integer> list, int number) {
        list.addLast(number); // какой то питон
    }
    public static int dequeue(LinkedList<Integer> list, int number) {
        return list.removeFirst(); // опять питон
    }
    public static int first(LinkedList<Integer> list, int number) {
        return list.getFirst(); // еще один питон
    }
    public static void reverse(LinkedList list) {
        Object tempVar;
        for (int i=0, mid=list.size()>>1, j=list.size()-1; i<mid; i++, j--) {
             tempVar = list.get(i);
             list.set(i, list.get(j));
             list.set(j, tempVar);
        }
    }


}
