import java.util.List;

public class rules {

    List<symptome> symptomesRequis;
    List<maladie> maladiesConstates;
    
    public rules(List<symptome> sympt, List<maladie> mal) {
        this.symptomesRequis = sympt;
        this.maladiesConstates = mal;
    }

    public boolean isAnxiete(List<symptome> s){

        for(int i=0; i < s.size(); i++) {

            if(s.get(i).getNomSymptome() == "INQUIETUDE" && s.get(i).getNomSymptome() == "TROUBLE_MUSCULAIRES" &&
               s.get(i).getNomSymptome() == "TROUBLE_SOMMEIL" && s.get(i).getNomSymptome() == "TROUBLE_CARDIAQUE" &&
               s.get(i).getNomSymptome() == "SUEURS" &&  s.get(i).getNomSymptome() == "CRISE_DE_PANIQUE" )

                      return true;
            
        }
        return false;

        
    }
    
    public boolean isDepressif(List<symptome> s){

        for(int i=0; i < s.size(); i++) {
            
            if(s.get(i).getNomSymptome() == "TRISTESSE" && s.get(i).getNomSymptome() == "PERTE_INTERET" &&
               s.get(i).getNomSymptome() == "FATIGUE_SEVERE" && s.get(i).getNomSymptome() == "PERTE_APPETIT" &&
               s.get(i).getNomSymptome() == "TROUBLE_SOMMEIL" &&  s.get(i).getNomSymptome() == "PENSEES_SUICIDAIRES" )

                      return true;
            
        }
        return false;

        
    }

}
