import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String option;
        String menu = "Selecciona una opción:\n1) Calcular salario mensual de un trabajador \n2) Calcular salario semanal de un trabajador \n3) Calcular salario anual de un trabajador \n0) Salir";
        Scanner console = new Scanner(System.in);
        int daily;
        System.out.println("------B I E N V E N I D O------");
        do {
            System.out.println(menu);
            System.out.print(">> ");
            option = console.nextLine();
            switch (option){
                case "1":
                    daily = check();
                    monthly(daily);
                    break;
                case "2":
                    daily = check();
                    weekly(daily);
                    break;
                case "3":
                    daily = check();
                    yearly(daily);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Tu opción  \"" + option + " \" no es válida, inténtalo de nuevo.");
            }
        } while (!option.equals("0"));
        System.out.print("Saliendo...");
    }
    public static int check(){
        Scanner console = new Scanner(System.in);
        System.out.println("Digita el salario diario del trabajador: ");
        System.out.print(">> ");
        int daily = console.nextInt();
        console.nextLine();
        while(daily < 0){
            System.out.println("Digita un valor mayor a 0");
            System.out.print(">> ");
            daily = console.nextInt();
            console.nextLine();
        }
        return daily;
    }

    public static void monthly(int daily){
        int salary = (daily*30);
        System.out.println("El salario mensual del trabajador es: " + salary);
    }

    public static void weekly(int daily){
        int salary = (daily*7);
        System.out.println("El salario semanal del trabajador es: " + salary);
    }

    public static void yearly(int daily){
        int salary = (daily*360);
        System.out.println("El salario anual del trabajador es: " + salary);
    }
}