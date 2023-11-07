import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Rules> creerReglesMaladies() {
        List<Rules> reglesMaladies = new ArrayList<Rules>();

        // Création de tous les symptômes

            Symptome COURBATURE = new Symptome("courbatures");
            Symptome FATIGUE = new Symptome("fatigue");
            Symptome FIEVRE = new Symptome("fièvre");
            Symptome TOUX = new Symptome("toux");
            Symptome SUEURS_FROIDES = new Symptome("sueurs froides");
            Symptome MALAISE = new Symptome("malaise");
            Symptome FRAGILE = new Symptome("fragile");
            Symptome VIEUX = new Symptome("vieux");
            Symptome CONTACT = new Symptome("contact");
            Symptome MAUX_DE_TETE = new Symptome("maux de tête");
            Symptome PRESSION_ELEVEE = new Symptome("pression arterielle élevée");
            Symptome BON_MEDECIN = new Symptome("bon médecin");
            Symptome GRIPPE = new Symptome("grippe");
            Symptome COVID = new Symptome("covid");
            Symptome COMPLICATIONS_GRIPPE = new Symptome("complications grippale");
            Symptome COMPLICATIONS_COVID = new Symptome("complications covid");

        // Création des différentes listes de symptômes pour chaque maladies

            List<Symptome> symptomesGrippe1 = new ArrayList<Symptome>();
                symptomesGrippe1.add(COURBATURE);
                symptomesGrippe1.add(FATIGUE);
                symptomesGrippe1.add(FIEVRE);
            List<Symptome> symptomesGrippe2 = new ArrayList<Symptome>();
                symptomesGrippe1.add(MAUX_DE_TETE);
                symptomesGrippe1.add(FIEVRE);
            List<Symptome> symptomesCovid1 = new ArrayList<Symptome>();
                symptomesGrippe1.add(GRIPPE);
                symptomesGrippe1.add(TOUX);
            List<Symptome> symptomesMalaise = new ArrayList<Symptome>();
                symptomesGrippe1.add(FATIGUE);
                symptomesGrippe1.add(SUEURS_FROIDES);
            List<Symptome> symptomesFragile = new ArrayList<Symptome>();
                symptomesGrippe1.add(VIEUX);
            List<Symptome> symptomesComplicationGrippe = new ArrayList<Symptome>();
                symptomesGrippe1.add(GRIPPE);
                symptomesGrippe1.add(MALAISE);
            List<Symptome> symptomesComplicationCovid = new ArrayList<Symptome>();
                symptomesGrippe1.add(COVID);
                symptomesGrippe1.add(MALAISE);
                symptomesGrippe1.add(PRESSION_ELEVEE);

        // Création des différentes règles pour chaque maladies 

            Rules rule_grippe_1 = new Rules(symptomesGrippe1, GRIPPE);
            Rules rule_grippe_2 = new Rules(symptomesGrippe2, GRIPPE);
            Rules rule_covid_1 = new Rules(symptomesCovid1, COVID);
            Rules rule_malaise = new Rules(symptomesMalaise, MALAISE);
            Rules rule_fragile = new Rules(symptomesFragile, FRAGILE);

            reglesMaladies.add(rule_grippe_1);
            reglesMaladies.add(rule_grippe_2);

        return reglesMaladies;
    }
    public static void main(String[] args) throws Exception {

        List<Rules> regles = creerReglesMaladies();
        
        List<Symptome> symptomesPatient = new ArrayList<>();
            symptomesPatient.add(new Symptome("TRISTESSE"));
            symptomesPatient.add(new Symptome("PERTE_INTERET"));
            symptomesPatient.add(new Symptome("FATIGUE_SEVERE"));
            symptomesPatient.add(new Symptome("PERTE_APPETIT"));
            symptomesPatient.add(new Symptome("TROUBLE_SOMMEIL"));
            symptomesPatient.add(new Symptome("PENSEES_SUICIDAIRES"));
            symptomesPatient.add(new Symptome("TROUBLE_PERSONNALITE"));
            symptomesPatient.add(new Symptome("IMPULSIF"));


        Personne p1 = new Personne("P1", 20, symptomesPatient);

        for (Rules r : regles) {
            // if (r.evaluer(p1.get_symptomesDuPatient())) System.out.println("Le patient a : " + r.get_maladieDiagnostique().getNomMaladie());
        }

    }

    
    
}