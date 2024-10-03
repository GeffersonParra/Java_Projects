import java.util.ArrayList;
import java.lang.Math.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String option;
        String menu = "Selecciona una opción:\n1) Sumar números\n2) Restar números\n3) Multiplicar números \n4) Dividir números \n5) Potenciar números \n6) Calcular la raíz cuadrada de un número\n0) Salir";
        Scanner console = new Scanner(System.in);
        int total;
        int firstNum;
        int secondNum;
        int counter;
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("------B I E N V E N I D O------");
        do {
            System.out.println(menu);
            System.out.print(">> ");
            option = console.nextLine();
            switch (option){
                case "1":
                    counter = 1;
                    do{
                        System.out.println("Digita el " + counter + "° número a sumar, para salir, presiona 0");
                        System.out.print(">> ");
                        firstNum = console.nextInt();
                        console.nextLine();
                        numbers.add(firstNum);
                        counter++;
                    }while (firstNum != 0);
                    sum(numbers);
                    numbers.clear();
                    break;
                case "2":
                    counter = 1;
                    System.out.println("Digita el número al cuál se le va a restar (Minuendo)");
                    System.out.print(">> ");
                    firstNum = console.nextInt();
                    do{
                        System.out.println("Digita el " + counter + "° número a restar (Sustraendo), para salir, presiona 0");
                        System.out.print(">> ");
                        secondNum = console.nextInt();
                        console.nextLine();
                        numbers.add(secondNum);
                        counter++;
                    }while (secondNum != 0);
                    substract(numbers, firstNum);
                    numbers.clear();
                    break;
                case "3":
                    System.out.println("Digita el primer número a multiplicar");
                    System.out.print(">> ");
                    firstNum = console.nextInt();
                    console.nextLine();
                    System.out.println("Ahora digita el segundo");
                    secondNum = console.nextInt();
                    console.nextLine();
                    total = firstNum * secondNum;
                    System.out.println("El resultado de la multiplicación entre " + firstNum + " y " + secondNum + " es igual a: " + total);
                    break;
                case "4":
                    System.out.println("Digita el dividendo");
                    System.out.print(">> ");
                    firstNum = console.nextInt();
                    console.nextLine();
                    System.out.println("Ahora digita el divisor");
                    System.out.print(">> ");
                    secondNum = console.nextInt();
                    console.nextLine();
                    while (secondNum == 0){
                        System.out.println("No es posible realizar una división entre cero, digita de nuevo el divisor");
                        System.out.print(">> ");
                        secondNum = console.nextInt();
                        console.nextLine();
                    }
                    double totalDouble = (double) firstNum/secondNum;
                    System.out.println("El resultado de la división entre " + firstNum + " y " + secondNum + " es igual a: " + totalDouble);
                    break;
                case "5":
                    System.out.println("Digita la base");
                    System.out.print(">> ");
                    firstNum = console.nextInt();
                    console.nextLine();
                    System.out.println("Ahora digita el exponente");
                    secondNum = console.nextInt();
                    console.nextLine();
                    power(firstNum, secondNum);
                    break;
                case "6":
                    System.out.println("Digita el número del cuál quieres conocer la raíz cuadrada");
                    System.out.print(">> ");
                    firstNum = console.nextInt();
                    console.nextLine();
                    while (firstNum < 0){
                        System.out.println("No es posible calcular la raíz cuadrada de un número negativo, vuelve a ingresarlo");
                        System.out.print(">> ");
                        firstNum = console.nextInt();
                        console.nextLine();
                    }
                    total = (int) Math.sqrt(firstNum);
                    System.out.println("La raiz cuadrada de " + firstNum + " es igual a " + total);
                    break;
                default:
                    System.out.println("Tu opción  \"" + option + " \" no es válida, inténtalo de nuevo.");
            }
        } while (!option.equals("0"));
        System.out.print("Saliendo...");
    }

    public static void sum(ArrayList<Integer> numbers){
        int total = 0;
        for (Integer number : numbers){
            total += number;
        }
        System.out.println("La suma de los números que has escrito es igual a: " + total);
    }

    public static void substract(ArrayList<Integer> numbers, int firstNum){
        for (Integer number : numbers){
            firstNum -= number;
        }
        System.out.println("El resultado de la resta es igual a: " + firstNum);
    }

    public static void power(int firstNum, int secondNum){
        int total = 1;
        for(int i = 0; i < secondNum; i++){
            total *= firstNum;
        }
        System.out.println(firstNum + " elevado a " + secondNum + " es igual a " + total);
    }
}