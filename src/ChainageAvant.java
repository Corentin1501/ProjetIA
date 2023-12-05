

import java.util.ArrayList;

public class ChainageAvant{
    public static void solve(ArrayList<String> baseDeFaits, Br baseDeRegles, String but) 
    {
        ArrayList<Regle> cheminementRegle = new ArrayList<Regle>();

        try {
            while (!baseDeFaits.contains(but) && baseDeRegles.countRegleApplicable(baseDeFaits)>0) 
            {
                // recupérer la regle applicable
                Regle regleAppl =  baseDeRegles.getRegleApplicable(baseDeFaits);
                regleAppl.desactivate();

                System.out.println("la regle applicable est : \n" + regleAppl.toString() + "\n");

                // ajouter la regle au cheminement
                cheminementRegle.add(regleAppl);

                // ajouter l'action à la BF
                baseDeFaits.addAll(regleAppl.action);

                System.out.println("BF pour cet iteration:  " + baseDeFaits.toString() + "\n");

            }
            if(baseDeFaits.contains(but)){
                System.out.println( "La regle: " + but + "  est etabli");
                System.out.println("Les regles utilisees pour demontrer {" + but +"} :");

                for (Regle r : cheminementRegle) {
                    System.out.println(r);
                }

                
            } else {
                System.out.println( "La regle: " + but + "  n'est pas etabli");

            }
        } catch (Exception e) {
                System.out.println(e);
        }
        

       
    }
}


