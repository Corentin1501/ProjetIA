import java.util.ArrayList;
import java.util.List;

public class Chainage_arriere {
    private Personne patient;
    private List<Rules> ensembleDeRegles;

    public Chainage_arriere(Personne patient, List<Rules> ensembleDeRegles) {
        this.patient = patient;
        this.ensembleDeRegles = new ArrayList<>(ensembleDeRegles);
    }

        public boolean chainageArriere(Personne personne, Symptome symptomeRecherche) {
            // Vérifier si la personne a déjà ce symptôme
            if (personne.getSymptomesDeLaPersonne().contains(symptomeRecherche)) {
                return true;
            }
    
            // Parcourir les règles pour trouver une correspondance avec le symptôme recherché
            for (Rules rule : ensembleDeRegles) {
                Symptome consequence = rule.getConsequence();
                if (consequence.equals(symptomeRecherche)) {
                    List<Symptome> symptomesRequis = rule.getSymptomesRequis();
                    boolean symptomesPresents = true;
    
                    // Vérifier si tous les symptômes requis sont présents chez la personne
                    for (Symptome symptomeRequis : symptomesRequis) {
                        if (!personne.getSymptomesDeLaPersonne().contains(symptomeRequis)) {
                            symptomesPresents = false;
                            break;
                        }
                    }
    
                    // Si tous les symptômes requis sont présents, évaluer la règle récursivement
                    if (symptomesPresents) {
                        boolean isTrue = chainageArriere(personne, consequence);
                        if (isTrue) {
                            return true;
                        }
                    }
                }
            }
    
            // Aucune correspondance trouvée
            return false;
        }
}
