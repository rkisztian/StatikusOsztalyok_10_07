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

        private static final List<String> VEZ_nev = feltolt("files/veznev.txt");
        private static final List<String> NOI_KERESZT_nev = feltolt("files/noikernev.txt");
        private static final List<String> FERFI_KERESZT_nev = feltolt("files/ferfikernev.txt");

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

        public static char velKarakter(char min, char max){
            return (char) velEgesz(min, max);
        }

        public static String velVezeteknev(){
            return VEZ_nev.get(rnd.nextInt(VEZ_nev.size()));
        }


    /**
     * Véletlen keresztnevet generál a megadott paraméter alapján.
     * Paraméter értéktől függően férfi vagy női keresztnevet
     * @param nem A generált név neme. Igaz, ha férfi, Hamis, ha nő
     * @return Generált keresztnév.
     */
    public static String velKeresztnev(boolean nem){
        String keresztnev;
        if(nem){
            keresztnev = velFerfiKeresztnev();
            }else {
            keresztnev = velNoiKeresztnev();
        }
        return keresztnev;
        }

    private static String velNoiKeresztnev() {
        return  NOI_KERESZT_nev.get(rnd.nextInt(NOI_KERESZT_nev.size()));
    }

    private static String velFerfiKeresztnev() {
        return FERFI_KERESZT_nev.get(rnd.nextInt(FERFI_KERESZT_nev.size()));
    }


    /**
     * Véletlen nevet generál a megadott paraméter alapján.
     * Paraméter értéktől függően férfi vagy női nevet
     * @param nem A generált név neme. Igaz, ha férfi, Hamis, ha nő
     * @return Generált nev.
     */
    public static String velTeljesNev(boolean nem){
        return velVezeteknev() + " " + velKeresztnev(nem);
    }

}
