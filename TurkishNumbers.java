import java.util.Scanner;

/**
 * This class converts three sized digit numbers to Turkish word.
 * Support minus also.
 * @author Sercan TIRNAVALI
 * @version 1.0
 * @since 2024-02-13
 */
public class TurkishNumbers {
    public static void main(String[] args) {

        System.out.println("Üç basamaklı bir sayı giriniz:");
        Scanner scanner = new Scanner(System.in);
        int input  = scanner.nextInt();
        while(input > 999 || input < -999){
            System.out.println("3 basamaklı bir sayı giriniz.");
            input  = scanner.nextInt();
        }
        var result = ConvertNumberToTurkish(input);
        System.out.println(result);
    }

    public static String ConvertNumberToTurkish(int number){
        StringBuilder sb = new StringBuilder();
        number = number % 1000;
        if(number < 0 ){
            sb.append("eksi");
            number= Math.abs(number);
        }
        int hundreds = number / 100;
        int tens = (number % 100) / 10;
        int units = number - hundreds*100 - tens*10;
        //sb.append(hundreds).append(tens).append(units);

        switch (hundreds){
            case 0 -> sb.append("");
            case 1 -> sb.append("yüz");
            default -> sb.append( NumberToString( hundreds)).append("yüz");
        }
        sb.append(TensToString(tens));
        sb.append(NumberToString(units));
        return sb.toString();

    }

    private static String NumberToString(int number){
        String s;
        switch(number){
            case 1 ->  s = "bir";
            case 2 -> s = "iki";
            case 3 -> s = "üç";
            case 4 -> s = "dört";
            case 5 -> s= "beş";
            case 6 -> s = "altı";
            case 7 -> s = "yedi";
            case 8 -> s = "sekiz";
            case 9 -> s = "dokuz";
            default -> s = "sıfır";
        }
        return s;
    }

    private static String TensToString(int number){
        String s;
        switch(number){
            case 1 ->  s = "on";
            case 2 -> s = "yirmi";
            case 3 -> s = "otuz";
            case 4 -> s = "kırk";
            case 5 -> s= "elli";
            case 6 -> s = "atmış";
            case 7 -> s = "yetmiş";
            case 8 -> s = "seksen";
            case 9 -> s = "doksan";
            default -> s = "";
        }
        return s;
    }
}
