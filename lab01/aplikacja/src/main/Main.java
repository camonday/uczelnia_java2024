package main;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import obliczeniaP.Zipper;
import obliczeniaP.Checker;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        //System.out.println("hello");

        String filesPath = "";
        String newPath = "";

        // done zakoduj sciezke gdzie beda wyniki
        String path_for_zipPairs = "/zipPairs";

        // done pokaz menu
        switch(useMenu()){
            case 1:
                // odbierz sciezke tego co masz zapakowac
                System.out.print("Sciezka do folderu/pliku ktory mam spakowac: ");
                filesPath = sc.next();
                newPath = path_for_zipPairs;
                //zrob zip
                try {
                    Zipper zipper = new Zipper(filesPath,newPath);
                } catch (Exception e){
                    System.out.println(e.getMessage());

                }
                break;
            case 2:

                System.out.print("Sciezka do folderu z zipem ktory mam sprawdzic: ");
                filesPath = sc.next();

                if(Checker.checkMD5(filesPath)){
                    System.out.println("Klucze sie zgadzają");
                }
                else{
                    System.out.println("Klucze się nie zgadają - plik został naruszony");
                }

                break;
        }

        return;
    }

    static int useMenu(){
        int response;

        System.out.println("---ZIPPER---");
        System.out.println("podaj opcje:");
        System.out.println("\t1. Spakuj plk lub folder");
        System.out.println("\t2. Sprawdź paczkę");
        System.out.print("Opcja: ");


        response = sc.nextInt();

        return response;
    }

}