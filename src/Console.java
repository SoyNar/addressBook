import java.util.Scanner;

public class Console {

    private  final Scanner sc = new Scanner(System.in);

    public String readText(String message){
        System.out.println(message);
        return sc.nextLine().trim();

    }

    public int readNumber(String message)
    {
        while (true){
            System.out.println(message);
            try {
                return  Integer.parseInt(sc.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Ingrese numero valido");
            }
        }

    }
}
