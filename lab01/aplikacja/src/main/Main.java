package main;

import java.util.Scanner;
import obliczeniaP.Zipper;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.println("hello");

        String filesPath = "";
        String newPath = "";

        // todo zakoduj sciezke gdzie beda wyniki
        String path_for_zipPairs = "/zipPairs";

        // todo pokaz menu
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


                //zapisz zip

                break;
            case 2:

                System.out.print("Sciezka do zipa ktory mam sprawdzic: ");
                filesPath = sc.next();

                break;
        }



        // todo zrob zip
        //filesPath = sc.next();


        // todo zapisz zip

        // todo policz md5 dla zip

        // todo zapisz md5

        //---
        // todo porownaj obliczone md5 z odczytanym md5

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