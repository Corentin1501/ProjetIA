import java.util.*;

public class Chainage_avant {
    private Personne patient;
    private List<Rules> ensembleDeRegles;

    public Chainage_avant(Personne patient, List<Rules> ensembleDeRegles) {
        this.patient = patient;
        this.ensembleDeRegles = new ArrayList<>(ensembleDeRegles);
    }

    public void evaluer(){
        // On commence par trier les regles par niveau

            List<List<Rules>> reglesParNiveaux = new ArrayList<>();
            List<Rules> reglesNiveau1 = new ArrayList<>();
            List<Rules> reglesNiveau2 = new ArrayList<>();
            List<Rules> reglesNiveau3 = new ArrayList<>();
            reglesParNiveaux.add(reglesNiveau1);
            reglesParNiveaux.add(reglesNiveau2);
            reglesParNiveaux.add(reglesNiveau3);
            
            for (Rules rule : ensembleDeRegles) {
                if (rule.getNiveau() == 1) reglesNiveau1.add(rule);
                if (rule.getNiveau() == 2) reglesNiveau2.add(rule);
                else reglesNiveau3.add(rule);
            }
        //-------------------------------------------

            // for (Symptome symptome : patient.getSymptomesDeLaPersonne()) {
            //     System.out.println(symptome.getNom());
            // }

        // évaluation de toutes les regles dans l'ordre de niveau
        
        for (int niveau = 0; niveau < 3; niveau++) {
            for (Rules rule : reglesParNiveaux.get(niveau)) {
                if (rule.evaluer(patient.getSymptomesDeLaPersonne()) 
                    && !patient.getSymptomesDeLaPersonne().contains(rule.getConsequence()))
                {
                    patient.ajouterSymptome(rule.getConsequence());
                    System.out.println("nouveau symptome : " + rule.getConsequence().getNom());
                }
            }
        }

        // toutes les regles et faits ont été évalués, on regarde ensuite quel symptome trouvé est le plus grave (on cherche la mort)

        // System.out.println("-----------");
        // for (Symptome symptome : patient.getSymptomesDeLaPersonne()) {
        //     System.out.println(symptome.getNom());
        // }

        Symptome pireSymptome = patient.getSymptomesDeLaPersonne().get(0); // on prend par défaut le premier 

        for (Symptome symptome : patient.getSymptomesDeLaPersonne()) {
            if(symptome.getNiveau() > pireSymptome.getNiveau()) pireSymptome = symptome;
        }

        System.out.println("Pire symptome : " + pireSymptome.getNom());
    }

    

}