import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Rules> creerReglesMaladies() {
        List<Rules> reglesMaladies = new ArrayList<Rules>();

        // Création de tous les symptômes

            Symptome ANXIETE = new Symptome("ANXIETE");
            Symptome COMPORTEMENTS_REPETITIFS = new Symptome("COMPORTEMENTS_REPETITIFS");
            Symptome COMPULSIONS = new Symptome("COMPULSIONS");
            Symptome CONFUSIONS = new Symptome("CONFUSIONS");
            Symptome CONVULSIONS = new Symptome("CONVULSIONS");
            Symptome CRISE_DE_PANIQUE = new Symptome("CRISE_DE_PANIQUE");
            Symptome DESORIENTATION = new Symptome("DESORIENTATION");
            Symptome FATIGUE_SEVERE = new Symptome("FATIGUE_SEVERE");
            Symptome HALLUCINATIONS = new Symptome("HALLUCINATIONS");
            Symptome HYPERACTIF = new Symptome("HYPERACTIF");
            Symptome IMPULSIF = new Symptome("IMPULSIF");
            Symptome INATTENTION = new Symptome("INATTENTION");
            Symptome INQUIETUDE = new Symptome("INQUIETUDE");
            Symptome IRRITABLE = new Symptome("IRRITABLE");
            Symptome ISOLEMENT_SOCIAL = new Symptome("ISOLEMENT_SOCIAL");
            Symptome MAL_DE_TETE = new Symptome("MAL_DE_TETE");
            Symptome NAUSEES = new Symptome("NAUSEES");
            Symptome OBSESSIONS = new Symptome("OBSESSIONS");
            Symptome PENSEES_SUICIDAIRES = new Symptome("PENSEES_SUICIDAIRES");
            Symptome PROBLEME_COORDINATION = new Symptome("PROBLEME_COORDINATION");
            Symptome PERTE_APPETIT = new Symptome("PERTE_APPETIT");
            Symptome PERTE_CONSCIENCE = new Symptome("PERTE_CONSCIENCE");
            Symptome PERTE_INTERET = new Symptome("PERTE_INTERET");
            Symptome PERTE_MEMOIRE = new Symptome("PERTE_MEMOIRE");
            Symptome SENSIBILITE_LUMIERE = new Symptome("SENSIBILITE_LUMIERE");
            Symptome SENSIBILITE_SENSORIELLES_ACCRUE = new Symptome("SENSIBILITE_SENSORIELLES_ACCRUE");
            Symptome SUEURS = new Symptome("SUEURS");
            Symptome TREMBLEMENTS = new Symptome("TREMBLEMENTS");
            Symptome TRISTESSE = new Symptome("TRISTESSE");
            Symptome TROUBLE_CARDIAQUE = new Symptome("TROUBLE_CARDIAQUE");
            Symptome TROUBLE_COMMUNICATIONS = new Symptome("TROUBLE_COMMUNICATIONS");
            Symptome TROUBLE_INTERACTIONS_SOCIALES = new Symptome("TROUBLE_INTERACTIONS_SOCIALES");
            Symptome TROUBLE_MOUVEMENTS = new Symptome("TROUBLE_MOUVEMENTS");
            Symptome TROUBLE_MUSCULAIRES = new Symptome("TROUBLE_MUSCULAIRES");
            Symptome TROUBLE_PERSONNALITE = new Symptome("TROUBLE_PERSONNALITE");
            Symptome TROUBLE_SOMMEIL = new Symptome("TROUBLE_SOMMEIL");
            Symptome TROUBLE_VISION = new Symptome("TROUBLE_VISION");

        // Création de toutes les maladies

            Maladie DEPRESSIF = new Maladie("depressif");
            Maladie ANXIEUX = new Maladie("anxieux");
            Maladie BIPOLAIRE = new Maladie("bipolaire");
            Maladie SCHIZOPHRENE = new Maladie("schizophrène");
            Maladie TOC = new Maladie("Troubles obsessionnels-compulsifs (TOC)");
            Maladie TDAH = new Maladie("TDAH (trouble du déficit de l'attention avec hyperactivité)");
            Maladie MIGRAINE = new Maladie("migraine");
            Maladie PARKINSON = new Maladie("Parkinson");
            Maladie SCLEROSE = new Maladie("sclérose en plaques");
            Maladie EPILEPSIE = new Maladie("épilepsie");
            Maladie ALZHEIMER = new Maladie("Alzheimer");
            Maladie AUTISME = new Maladie("autiste");

        // Création des différentes listes de symptômes pour chaque maladies

            List<Symptome> symptomesDepressif = new ArrayList<Symptome>();
                symptomesDepressif.add(TRISTESSE);
                symptomesDepressif.add(PERTE_INTERET);
                symptomesDepressif.add(FATIGUE_SEVERE);
                symptomesDepressif.add(PERTE_APPETIT);
                symptomesDepressif.add(TROUBLE_SOMMEIL);
                symptomesDepressif.add(PENSEES_SUICIDAIRES);
            List<Symptome> symptomesAnxiete = new ArrayList<Symptome>();
                symptomesAnxiete.add(INQUIETUDE);
                symptomesAnxiete.add(IRRITABLE);
                symptomesAnxiete.add(TROUBLE_MUSCULAIRES);
                symptomesAnxiete.add(TROUBLE_CARDIAQUE);
                symptomesAnxiete.add(SUEURS);
                symptomesAnxiete.add(CRISE_DE_PANIQUE);
                symptomesAnxiete.add(TROUBLE_SOMMEIL);
            List<Symptome> symptomesBipolaire = new ArrayList<Symptome>();
                symptomesBipolaire.add(TROUBLE_PERSONNALITE);
                symptomesBipolaire.add(IMPULSIF);
                symptomesBipolaire.add(TROUBLE_SOMMEIL);
            List<Symptome> symptomesSchizo = new ArrayList<Symptome>();
                symptomesSchizo.add(HALLUCINATIONS);
                symptomesSchizo.add(ISOLEMENT_SOCIAL);
            List<Symptome> symptomesToc = new ArrayList<Symptome>();
                symptomesToc.add(OBSESSIONS);
                symptomesToc.add(COMPULSIONS);
                symptomesToc.add(ANXIETE);
            List<Symptome> symptomesTdah = new ArrayList<Symptome>();
                symptomesTdah.add(INATTENTION);
                symptomesTdah.add(IMPULSIF);
                symptomesTdah.add(HYPERACTIF);
            List<Symptome> symptomesMigraine = new ArrayList<Symptome>();
                symptomesMigraine.add(MAL_DE_TETE);
                symptomesMigraine.add(SENSIBILITE_LUMIERE);
                symptomesMigraine.add(NAUSEES);
            List<Symptome> symptomesParkinson = new ArrayList<Symptome>();
                symptomesParkinson.add(TREMBLEMENTS);
                symptomesParkinson.add(PROBLEME_COORDINATION);
                symptomesParkinson.add(TROUBLE_MUSCULAIRES);
            List<Symptome> symptomesSclerose = new ArrayList<Symptome>();
                symptomesSclerose.add(FATIGUE_SEVERE);
                symptomesSclerose.add(TROUBLE_VISION);
                symptomesSclerose.add(TROUBLE_MUSCULAIRES);
                symptomesSclerose.add(PROBLEME_COORDINATION);
            List<Symptome> symptomesEpilepsie = new ArrayList<Symptome>();
                symptomesEpilepsie.add(CONVULSIONS);
                symptomesEpilepsie.add(PERTE_CONSCIENCE);
                symptomesEpilepsie.add(TROUBLE_MOUVEMENTS);
                symptomesEpilepsie.add(CONFUSIONS);
            List<Symptome> symptomesAlzheimer = new ArrayList<Symptome>();
                symptomesAlzheimer.add(PERTE_MEMOIRE);
                symptomesAlzheimer.add(CONFUSIONS);
                symptomesAlzheimer.add(DESORIENTATION);
                symptomesAlzheimer.add(TROUBLE_COMMUNICATIONS);
                symptomesAlzheimer.add(TROUBLE_PERSONNALITE);
            List<Symptome> symptomesAutisme = new ArrayList<Symptome>();
                symptomesAutisme.add(TROUBLE_INTERACTIONS_SOCIALES);
                symptomesAutisme.add(COMPORTEMENTS_REPETITIFS);
                symptomesAutisme.add(SENSIBILITE_SENSORIELLES_ACCRUE);

        // Création des différentes règles pour chaque maladies 

            Rules rule_depressif = new Rules(symptomesDepressif, DEPRESSIF);
            Rules rule_anxiete = new Rules(symptomesAnxiete, ANXIEUX);
            Rules rule_bipolaire = new Rules(symptomesBipolaire, BIPOLAIRE);
            Rules rule_schizo = new Rules(symptomesSchizo, SCHIZOPHRENE);
            Rules rule_toc = new Rules(symptomesToc, TOC);
            Rules rule_tdah = new Rules(symptomesTdah, TDAH);
            Rules rule_migraine = new Rules(symptomesMigraine, MIGRAINE);
            Rules rule_parkinson = new Rules(symptomesParkinson, PARKINSON);
            Rules rule_sclerose = new Rules(symptomesSclerose, SCLEROSE);
            Rules rule_epilepsie = new Rules(symptomesEpilepsie, EPILEPSIE);
            Rules rule_alzheimer = new Rules(symptomesAlzheimer, ALZHEIMER);
            Rules rule_autisme = new Rules(symptomesAutisme, AUTISME);

            reglesMaladies.add(rule_alzheimer);
            reglesMaladies.add(rule_anxiete);
            reglesMaladies.add(rule_autisme);
            reglesMaladies.add(rule_bipolaire);
            reglesMaladies.add(rule_depressif);
            reglesMaladies.add(rule_epilepsie);
            reglesMaladies.add(rule_migraine);
            reglesMaladies.add(rule_parkinson);
            reglesMaladies.add(rule_schizo);
            reglesMaladies.add(rule_sclerose);
            reglesMaladies.add(rule_tdah);
            reglesMaladies.add(rule_toc);

        return reglesMaladies;
    }
    public static void main(String[] args) throws Exception {

        List<Rules> regles = creerReglesMaladies();
        
        // Création de la règle de diagnostic
        List<Symptome> symptomesPatient = new ArrayList<>();
            symptomesPatient.add(new Symptome("TRISTESSE"));
            symptomesPatient.add(new Symptome("PERTE_INTERET"));
            symptomesPatient.add(new Symptome("FATIGUE_SEVERE"));
            symptomesPatient.add(new Symptome("PERTE_APPETIT"));
            symptomesPatient.add(new Symptome("TROUBLE_SOMMEIL"));
            symptomesPatient.add(new Symptome("PENSEES_SUICIDAIRES"));
            symptomesPatient.add(new Symptome("TROUBLE_PERSONNALITE"));
            symptomesPatient.add(new Symptome("IMPULSIF"));


        Patient p1 = new Patient("P1", 20, symptomesPatient);

        for (Rules r : regles) {
            if (r.evaluer(p1.get_symptomesDuPatient())) System.out.println("Le patient est " + r.get_maladieDiagnostique().getNomMaladie());
        }

    }

    
    
}