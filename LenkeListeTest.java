import java.util.Arrays;
import java.util.ArrayList;

class LenkeListeTest {
    public static ArrayList<String> kontrollbeholder = new ArrayList<>();

    public static void main(String[] args) {
        LenkeListe<String> sb = new LenkeListe<>();
        test(sb.tom(), true, "om listen er tom");
        System.out.println();

        String kristian = "Kristian";
        test(sb.inneholder(kristian), false, 
             "om listen inneholder 'Kristian'");
        verboseLeggTil(sb, kristian);
        test(sb.inneholder(kristian), true, 
             "om listen inneholder 'Kristian'");
        test(sb.tom(), false, 
             "om listen er tom");
        skrivUtKontrollbeholder();
        test(verboseFjernMinste(sb) == kristian, true,
             "om 'Kristian' var minst i listen");
        test(sb.inneholder(kristian), false, 
             "om listen inneholder 'Kristian'");
        System.out.println();

        test(sb.tom(), true, 
             "om listen er tom");
        System.out.println();

        String stm = "Stein Michael";
        verboseLeggTil(sb, stm);
        verboseLeggTil(sb, kristian);
        skrivUtKontrollbeholder();
        test(verboseFjernMinste(sb) == kristian, true,
             "om 'Kristian' var minst i listen");
        System.out.println();

        String gard = "Gard";
        String malin = "Malin";

        verboseLeggTil(sb, kristian);
        verboseLeggTil(sb, gard);
        verboseLeggTil(sb, malin);
        test(sb.inneholder(kristian), true, 
             "om listen inneholder 'Kristian'");
        test(sb.tom(), false, 
             "om listen er tom");
        System.out.println();

        skrivUtKontrollbeholder();
        test(verboseFjernMinste(sb) == gard, true,
             "om 'Gard' var minst i listen");
        test(verboseFjernMinste(sb) == kristian, true,
             "om 'Kristian' var minst i listen");
        test(verboseFjernMinste(sb) == malin, true,
             "om 'Malin' var minst i listen");
        test(verboseFjernMinste(sb) == stm, true,
             "om 'Stein Michael' var minst i listen");
        System.out.println();

        skrivUtKontrollbeholder();
        test(verboseFjernMinste(sb) == null, true,
             "om null var minst i listen");
        test(sb.tom(), true, 
             "om listen er tom");        
    }

    public static void test(boolean faktisk, boolean forventet, String mld) {
        if (faktisk == forventet){
            System.out.printf("Tester %-50s: %-5b   OK\n", 
                               mld, faktisk);
        } else {
            System.out.printf("Tester %-50s: %-5b   FEIL\n", 
                              mld, faktisk);
        }
    }

    public static void verboseLeggTil(LenkeListe<String> sb, String s) {
        System.out.printf("*** Legger til '%s'\n", s);
        sb.leggTil(s);

        kontrollbeholder.add(s);
        kontrollbeholder.sort((a, b) -> a.compareTo(b));
    }

    public static String verboseFjernMinste(LenkeListe<String> sb) {
        System.out.printf("*** Fjerner minste: ");
        String minste = sb.fjernMinste();
        if (minste == null) {
            System.out.printf("null\n");
        } else {
            System.out.printf("'%s'\n", minste);
        }

        String kontrollMinste;
        if (kontrollbeholder.size() > 0) {
            kontrollMinste = kontrollbeholder.remove(0);
        } else {
            kontrollMinste = null;
        }

        if (kontrollMinste != minste) {
            if (kontrollMinste == null) {
                System.out.printf("FEIL: Forventet null\n");
            } else {
                System.out.printf("FEIL: Forventet '%s'\n", kontrollMinste);
            }
        }
        
        return minste;
    }

    public static void skrivUtKontrollbeholder() {
        System.out.println("*** Listen skal vaere "
                           + Arrays.toString(kontrollbeholder.toArray()));
    }
}