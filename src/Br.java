

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Br {
    public ArrayList<Regle> baseRegles = new ArrayList<Regle>();
    public Br addRegle(Regle regle){
        this.baseRegles.add(regle);
        return this;
    }
    
    public String toString() {
        String result = "La base de regles :--------------\n";
        for (Regle regle : baseRegles) {
            result+= regle.toString()+ "\n"; 
        }
        result+="---------------------------------\n";
        return result;
    }

    public Regle getRegleApplicable(ArrayList<String> baseDeFait) throws Exception{
        Regle rApp = null;
        for (Regle regle : this.baseRegles) {
            if(baseDeFait.containsAll(regle.premiss) && regle.active){

                rApp = regle;
                break;
            }
        }
        if(rApp==null){
            throw new Exception("error no base"); 
        }
        return  rApp;

    }

    public int countRegleApplicable(ArrayList<String> baseDeFait){
        int compteur = 0;
        for (Regle regle : this.baseRegles) {
            if(baseDeFait.containsAll(regle.premiss) && regle.active){
                compteur ++;
                break;
            }
        }
        return compteur;
    }

    public Regle getRegleChainageArriere(String f) throws Exception{
        Regle reg = null;
        for(Regle regle:this.baseRegles){
            if(regle.action.contains(f) && regle.active){
                reg = regle;
                break;
            }
        }
        if(reg==null){
            throw new Exception("error no base"); 
        }
        return  reg;
    }

    public int countRegleChainageArriere(String f){
        int compteur = 0;
        for (Regle regle : this.baseRegles) {
            if(regle.action.contains(f) &&  regle.active){
                compteur++;
            }
        }
        return compteur;
    }

    public void init(){
        for (Regle regle : this.baseRegles) {
            regle.activate();
        }
    }


public void afficherReglesParOrdreCroissantDePremisses() {
    List<String> baseString = new ArrayList<>();

    for(Regle r : baseRegles){
        baseString.add(r.toString());
    }
    
    Collections.sort(baseString, Comparator.comparingInt(String::length));

    for(String s : baseString){
        System.out.println(s);
    }

    String plusLong = "";
        for (String str : baseString) {
            if (str.length() > plusLong.length()) {
                plusLong = str;
            }
        }
        System.out.println("Règle qui a le plus de prémisse:" +plusLong);

    
}

public static boolean estBaseFaitCoherente(ArrayList<String> baseDeFait, Br baseDeRegles) {
    // Création d'une copie de la base de faits pour éviter de la modifier
    ArrayList<String> copieBaseDeFait = new ArrayList<>(baseDeFait);
    
    try {
        // Parcourir les règles pour vérifier si les faits satisfont chaque règle
        for (Regle regle : baseDeRegles.baseRegles) {
            if (regle.active && !verifierRegle(regle, copieBaseDeFait)) {
                // Si une règle ne peut pas être satisfaite, la base de faits n'est pas cohérente
                return false;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    
    // Si toutes les règles peuvent être satisfaites, la base de faits est cohérente
    return true;
}

// Vérifier si une règle peut être satisfaite avec la base de faits actuelle
private static boolean verifierRegle(Regle regle, ArrayList<String> baseDeFait) throws Exception {
    return baseDeFait.containsAll(regle.premiss) && regle.active;
}
}