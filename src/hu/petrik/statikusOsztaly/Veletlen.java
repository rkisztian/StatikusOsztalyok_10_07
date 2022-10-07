package hu.petrik.statikusOsztaly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {

        private Veletlen(){}

        private static final Random rnd = new Random();

        private static final List<String> VEZ_nev = feltolt("file/veznev.txt");
        private static final List<String> NOI_KERESZT_nev = feltolt("file/noikernev.txt");
        private static final List<String> FERFI_KERESZT_nev = feltolt("file/ferfikernev.txt");

        private static List<String> feltolt(String fajlnev){
            List<String> lista = new ArrayList<>();
            try {
                Scanner  file = new Scanner(new File(fajlnev));
                while (file.hasNext()){
                    lista.add(file.nextLine());
                }
                file.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return lista;
        }

        public static int velEgesz(int min, int max){
            if (min > max){
                throw new IllegalArgumentException("'min' must be <= 'max'");
            }
            return rnd.nextInt(max - min + 1) + min;
        }

}
