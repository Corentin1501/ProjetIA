

import java.util.ArrayList;

public class ChainageArriere{
    public static Boolean solve(ArrayList<String> baseDeFait, Br baseDeRegles, ArrayList<String> faits){
        Boolean res;
        if(faits.size()==0){
            res = true;
        }
        else {
            System.out.println("faits a verifier : " +  faits.get(faits.size()-1));
            String firstFait =  faits.get(faits.size()-1);
            if(demBut(baseDeFait, baseDeRegles, firstFait)){
                System.out.println("{" + firstFait + "} est verifie");
                baseDeFait.add(firstFait);
                faits.remove(firstFait);
                res = solve(baseDeFait, baseDeRegles, faits);
            }else{
                res = false;
                
                // System.out.println("echec , faits = : "  + faits);

            }
        }
        return res;
    }

    public static Boolean demBut(ArrayList<String> baseDeFait, Br baseDeRegles, String but){
        if(baseDeFait.contains(but)){
            return true;
        }else{
            // Br baseRegles = baseDeRegles.clone();
            boolean res =false ;
            while(baseDeRegles.countRegleChainageArriere(but) > 0  && !res){
                try {
                    Regle r = baseDeRegles.getRegleChainageArriere(but);
                    r.desactivate();

                    // if(baseDeFait.containsAll(r.action)){
                    System.out.println("Premises a verifier : " +  r.premiss);
                    
                    res = solve(baseDeFait, baseDeRegles, r.premiss);

                    // }
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
            return res;
        }
    }
}