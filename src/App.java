import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Rules> creerReglesMaladies() {
        List<Rules> reglesMaladies = new ArrayList<Rules>();

        // Création de tous les symptômes

            Symptome COURBATURE = new Symptome("COURBATURE",1);
            Symptome FATIGUE = new Symptome("FATIGUE",1);
            Symptome FIEVRE = new Symptome("FIEVRE",1);
            Symptome TOUX = new Symptome("TOUX",1);
            Symptome SUEURS_FROIDES = new Symptome("SUEURS_FROIDES",1);
            Symptome MALAISE = new Symptome("MALAISE",2);
            Symptome FRAGILE = new Symptome("FRAGILE",2);
            Symptome VIEUX = new Symptome("VIEUX",1);
            Symptome MAUX_DE_TETE = new Symptome("MAUX_DE_TETE",1);
            Symptome PRESSION_ELEVEE = new Symptome("PRESSION_ELEVEE",1);
            Symptome PAS_BON_MEDECIN = new Symptome("PAS_BON_MEDECIN",1);
            Symptome GRIPPE = new Symptome("GRIPPE",2);
            Symptome COVID = new Symptome("COVID",2);
            Symptome CONTACT_COVID = new Symptome("CONTACT_COVID",1);
            Symptome COMPLICATIONS = new Symptome("COMPLICATIONS",3);
            Symptome MORT = new Symptome("MORT",4);

        // Création des différentes listes de symptômes pour chaque maladies

            List<Symptome> symptomesGrippe1 = new ArrayList<Symptome>();
                symptomesGrippe1.add(COURBATURE);
                symptomesGrippe1.add(FATIGUE);
                symptomesGrippe1.add(FIEVRE);
            List<Symptome> symptomesGrippe2 = new ArrayList<Symptome>();
                symptomesGrippe2.add(MAUX_DE_TETE);
                symptomesGrippe2.add(FIEVRE);
            List<Symptome> symptomesCovid1 = new ArrayList<Symptome>();
                symptomesCovid1.add(GRIPPE);
                symptomesCovid1.add(TOUX);
            List<Symptome> symptomesCovid2 = new ArrayList<Symptome>();
                symptomesCovid2.add(CONTACT_COVID);
            List<Symptome> symptomesMalaise = new ArrayList<Symptome>();
                symptomesMalaise.add(FATIGUE);
                symptomesMalaise.add(SUEURS_FROIDES);
            List<Symptome> symptomesFragile = new ArrayList<Symptome>();
                symptomesFragile.add(VIEUX);
            List<Symptome> symptomesComplicationGrippe = new ArrayList<Symptome>();
                symptomesComplicationGrippe.add(GRIPPE);
                symptomesComplicationGrippe.add(MALAISE);
            List<Symptome> symptomesComplicationCovid = new ArrayList<Symptome>();
                symptomesComplicationCovid.add(COVID);
                symptomesComplicationCovid.add(MALAISE);
                symptomesComplicationCovid.add(PRESSION_ELEVEE);
            List<Symptome> symptomesMort1 = new ArrayList<Symptome>();
                symptomesMort1.add(COVID);
                symptomesMort1.add(FRAGILE);
            List<Symptome> symptomesMort2 = new ArrayList<Symptome>();
                symptomesMort2.add(VIEUX);
                symptomesMort2.add(MALAISE);
            List<Symptome> symptomesMort3 = new ArrayList<Symptome>();
                symptomesMort3.add(COMPLICATIONS);
                symptomesMort3.add(PAS_BON_MEDECIN);

        // Création des différentes règles pour chaque maladies 

            int numero = 1;

            Rules rule_grippe_1 = new Rules(symptomesGrippe1, GRIPPE, 1, numero++);
            Rules rule_grippe_2 = new Rules(symptomesGrippe2, GRIPPE, 1, numero++);
            Rules rule_covid_1 = new Rules(symptomesCovid1, COVID, 2, numero++);
            Rules rule_covid_2 = new Rules(symptomesCovid2, COVID, 2, numero++);
            Rules rule_malaise = new Rules(symptomesMalaise, MALAISE, 1, numero++);
            Rules rule_fragile = new Rules(symptomesFragile, FRAGILE, 1, numero++);
            Rules rule_complications_1 = new Rules(symptomesComplicationCovid, COMPLICATIONS, 2, numero++);
            Rules rule_complications_2 = new Rules(symptomesComplicationGrippe, COMPLICATIONS, 2, numero++);
            Rules rule_mort_1 = new Rules(symptomesMort1, MORT, 2, numero++);
            Rules rule_mort_2 = new Rules(symptomesMort2, MORT, 2, numero++);
            Rules rule_mort_3 = new Rules(symptomesMort3, MORT, 3, numero++);
            

            reglesMaladies.add(rule_grippe_1);
            reglesMaladies.add(rule_grippe_2);
            reglesMaladies.add(rule_covid_1);
            reglesMaladies.add(rule_covid_2);
            reglesMaladies.add(rule_malaise);
            reglesMaladies.add(rule_fragile);
            reglesMaladies.add(rule_complications_1);
            reglesMaladies.add(rule_complications_2);
            reglesMaladies.add(rule_mort_1);
            reglesMaladies.add(rule_mort_2);
            reglesMaladies.add(rule_mort_3);

        return reglesMaladies;
    }
    public static void main(String[] args) throws Exception {

        List<Rules> regles = creerReglesMaladies();

        // for (Rules rule : regles) {
        //     System.out.println("regle n°" + rule.getNumero() + " - " + rule.getConsequence().getNom());
        //     for (Symptome symptome : rule.getSymptomesRequis()) {
        //         System.out.println(symptome.getNom());

        //     }        
        // }
        
        List<Symptome> symptomesPatient = new ArrayList<>();
            // symptomesPatient.add(new Symptome("COURBATURE", 1));
            symptomesPatient.add(new Symptome("FATIGUE", 1));
            // symptomesPatient.add(new Symptome("FIEVRE", 1));
            symptomesPatient.add(new Symptome("SUEURS_FROIDES", 1));
            symptomesPatient.add(new Symptome("VIEUX", 1));
            // symptomesPatient.add(new Symptome("TOUX", 1));


        Personne patient = new Personne("Billy", 85, symptomesPatient, null);

        for (Symptome symptome : symptomesPatient) {
            System.out.println(symptome.getNom());
        }

        Chainage_avant ch = new Chainage_avant(patient, regles);

        ch.evaluer();

        Chainage_arriere chA = new Chainage_arriere(patient, regles);

        List<Symptome> obj = new ArrayList<>();
        obj.add(new Symptome("MORT", 4));

        System.out.println("patient mort : " + chA.chainageArriere(patient, new Symptome("MORT", 4)));
        
    }

    
    
}