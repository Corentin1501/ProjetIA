

import java.util.ArrayList;

public class ChainageAvant{
    private String explicationsAbrege, explicationsCompletes, but;
    private ArrayList<String> baseDeFaits;
    private Br baseDeRegles;
    private Boolean resultat;

    

    public ChainageAvant(ArrayList<String> baseDeFaits, Br baseDeRegles, String but) {
        this.baseDeFaits = baseDeFaits;
        this.baseDeRegles = baseDeRegles;
        this.but = but;
        this.explicationsAbrege = "";
        this.explicationsCompletes = "";

    }

    public void solve() 
    {
        ArrayList<Regle> cheminementRegle = new ArrayList<Regle>();

        try {
            while (!baseDeFaits.contains(but) && baseDeRegles.countRegleApplicable(baseDeFaits)>0) 
            {
                // recupérer la regle applicable
                Regle regleAppl =  baseDeRegles.getRegleApplicable(baseDeFaits);
                regleAppl.desactivate();

                explicationsCompletes += "la regle applicable est : \n" + regleAppl.toString() + "\n";
                
                // System.out.println("la regle applicable est : \n" + regleAppl.toString() + "\n");
                
                // ajouter la regle au cheminement
                cheminementRegle.add(regleAppl);
                
                // ajouter l'action à la BF
                baseDeFaits.addAll(regleAppl.action);
                
                explicationsCompletes += "BF pour cet iteration:  " + baseDeFaits.toString() + "\n";
                explicationsAbrege += "BF pour cet iteration:  " + baseDeFaits.toString() + "\n";
                
                // System.out.println("BF pour cet iteration:  " + baseDeFaits.toString() + "\n");

            }
            if(baseDeFaits.contains(but)){
                resultat = true;
                // System.out.println( "La regle: " + but + "  est etabli");
                // System.out.println("Les regles utilisees pour demontrer {" + but +"} :");

                explicationsCompletes += "Les regles utilisees pour demontrer {" + but + "} :\n";
                explicationsAbrege += "Les regles utilisees pour demontrer {" + but + "} :\n";

                for (Regle r : cheminementRegle) {
                    // System.out.println(r);
                    explicationsCompletes += r.toString() + "\n";
                    explicationsAbrege += r.toString() + "\n";
                }

                
            } else {
                resultat = false;
                explicationsCompletes += "La regle: " + but + "  n'est pas etabli" + "\n";
                explicationsAbrege += "La regle: " + but + "  n'est pas etabli" + "\n";

            }
        } catch (Exception e) {
            explicationsCompletes += e;
            System.out.println(e);
        }
    }

    public String getExplicationsCompletes(){ return explicationsCompletes; }
    public String getExplicationsAbrege(){ return explicationsAbrege; }
    public Boolean getResultat(){ return resultat; }
}


