package pl.sdacademy.PaniOdHRVERII.scan;

import pl.sdacademy.PaniOdHRVERII.builder.AdditionalInformations;
import pl.sdacademy.PaniOdHRVERII.builder.Person;

import java.util.Scanner;

public class Scaner {

    public void Scaner() {
        int numberOfPersons;
        String firstname;
        String lastname;
        String sex;
        int height;
        String birthDate;
        String[] interests;


        System.out.println("Hello!\n Please write down the number of person which you like to add to your HR list: ");
        numberOfPersons = ScanInt();
        if (numberOfPersons == 0) {
            System.out.println("You would like to add no one to your list.\nHave a nice day.");
           // return null;
        }

        String[] arrayHR = new String[numberOfPersons];

        System.out.println("You would like to add " + numberOfPersons + ".\nLet's start!");

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("Person number " + i + 1);
            System.out.print("First name :");
            firstname = ScanString();
            System.out.print("Last name :");
            lastname = ScanString();
            System.out.println("Gender (f/m):");
            sex = ScanString();

            System.out.print("If you want to add some additional information's please press y :");
            if (ScanString() == "y") {
                System.out.println("");
                System.out.print("If you want to add height of the person please press y :");
                if (ScanString() == "y") {
                    System.out.println("");
                    System.out.println("Height of the person : ");
                    height = ScanInt();
                }

                System.out.println("");
                System.out.print("If you want to add birth date of the person please press y :");
                if (ScanString() == "y") {
                    System.out.println("");
                    System.out.println("Birth Date of the person : ");
                    birthDate = ScanString();
                }

                System.out.println("");
                System.out.print("If you want to add interests of the person please press y :");
                if (ScanString() == "y") {
                    interests = new String[1];
                    System.out.println("");
                    System.out.println("Interest of the person : ");
                    interests[1] = ScanString();
                    System.out.print("If you want to add more interests of the person please press y :");
                    while (ScanString() == "y") {
                        String interestsToCopy2;
                        System.out.println("");
                        System.out.println("Interest of the person : ");
                        interestsToCopy2 = ScanString();
                        interests = addElements(interests, interestsToCopy2);
                    }
                }
            }


        }
        //    return;
    }


 private int ScanInt(){
        Scanner newscanner = new Scanner(System.in);
        return newscanner.nextInt();
    }

    private String ScanString(){
        Scanner newscanner = new Scanner(System.in);
        return newscanner.nextLine();
    }
    private static String[] addElements(String[] source, String...
            newElements) {

        String newArray[]= new String[newElements.length+source.length];

        for (int i=0;i<source.length;i++)
        {
            newArray[i]= source[i];
        }

        for(int i=source.length; i<(newElements.length+source.length);i++)
            newArray[i] = newElements[i];

        return newArray;
    }
}

