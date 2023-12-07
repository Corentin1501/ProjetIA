import java.util.ArrayList;


public class Coherence {
    
    public static boolean estBaseFaitsCoherente(ArrayList<String> baseFaitAvant, Br baseDeRegles) {
        ArrayList<String> tempBaseFait = new ArrayList<>(baseFaitAvant); // Création d'une copie temporaire de la base de faits

        // Tant qu'il existe des règles applicables et que la base de faits évolue
        boolean baseModifiee;
        do {
            baseModifiee = false;

            for (Regle regle : baseDeRegles.baseRegles) {
                if (tempBaseFait.containsAll(regle.premiss) && regle.active) {
                    tempBaseFait.addAll(regle.action); // Ajout des actions de la règle à la base de faits temporaire
                    regle.desactivate(); // Désactivation de la règle pour éviter une réapplication infinie

                    baseModifiee = true; // Indique que la base de faits a été modifiée
                }
            }
        } while (baseModifiee); // Continue tant que la base de faits évolue

        // Si la base de faits temporaire est identique à la base initiale, alors elle est cohérente
        return tempBaseFait.containsAll(baseFaitAvant);
    }
    
}

