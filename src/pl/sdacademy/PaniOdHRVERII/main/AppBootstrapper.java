package pl.sdacademy.PaniOdHRVERII.main;

import pl.sdacademy.PaniOdHRVERII.builder.AdditionalInformations;
import pl.sdacademy.PaniOdHRVERII.builder.Person;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AppBootstrapper {
    public static void start() throws FileNotFoundException {



        Person Zbigniew = new Person.Builder("Zbigniew","Coś ","Tak")
                .additionalInformations(
                        new AdditionalInformations.Builder()
                                .height(120)
                                .intrests("coś tam","coś tam")
                                .build())
                .build();

        Person Anna = new Person.Builder("Anna","lalla","Tak")
                .additionalInformations(
                        new AdditionalInformations.Builder()
                                .height(120)
                                .intrests("coś tam","coś tam","jakoś tam")
                                .build())
                .build();

        Person Karol = new Person.Builder("Karol","Yes","Tak")
                .additionalInformations(
                        new AdditionalInformations.Builder()
                                .height(120)
                                .birthDate("10-01-2000")
                                .intrests("cośtam")
                                .build())
                .build();



        System.out.println(Zbigniew.toString());

        System.out.println(Anna.toString());

        System.out.println(Karol.toString());

        Save("HRfile",Zbigniew.toString(),Karol.toString(),Anna.toString());

    }

    private static void Save(String Name,String... person) throws FileNotFoundException {
        Name+=".txt";
        PrintWriter zapis;
        zapis = new PrintWriter(Name);
        for (int i=0;i<person.length;i++) {
            zapis.println(person[i]);
        }
        zapis.close();
    }
}
