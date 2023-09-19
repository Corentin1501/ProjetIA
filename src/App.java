import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Création des symptômes
        Symptome tristesse = new Symptome("TRISTESSE");
        Symptome perteInteret = new Symptome("PERTE_INTERET");
        Symptome fatigueSevere = new Symptome("FATIGUE_SEVERE");
        Symptome perteAppetit = new Symptome("PERTE_APPETIT");
        Symptome troubleSommeil = new Symptome("TROUBLE_SOMMEIL");
        Symptome penseesSuicidaires = new Symptome("PENSEES_SUICIDAIRES");

        // Création de la règle de diagnostic
        List<Symptome> symptomesPatient = new ArrayList<>();
        symptomesPatient.add(tristesse);
        symptomesPatient.add(perteInteret);
        symptomesPatient.add(fatigueSevere);
        symptomesPatient.add(perteAppetit);
        symptomesPatient.add(troubleSommeil);
        symptomesPatient.add(penseesSuicidaires);


        // Patient p1 = new Patient("P1", 20, symptomesPatient);

        Rules reglesDepressif = new Rules(symptomesPatient, new Maladie("depressif"));

        if(reglesDepressif.evaluer(symptomesPatient))
            System.out.println("Il est depressif");



    }

    
    
}