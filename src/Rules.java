import java.util.List;
import java.util.ArrayList;

public class Rules {

    List<Symptome> _symptomesRequis;
    Maladie _maladieDiagnostique;
    
    public Rules(List<Symptome> symptomeRequis, Maladie maladie) {
        this._symptomesRequis = new ArrayList<Symptome>();
        for (Symptome s : symptomeRequis) {
            this._symptomesRequis.add(s);
        }
        this._maladieDiagnostique = maladie;
    }

    public boolean evaluer(List<Symptome> symptomesPresent) {
        return symptomesPresent.containsAll(_symptomesRequis);
    }

    // public boolean isAnxiete(List<Symptome> s){

    //     for(int i=0; i < s.size(); i++) {

    //         if(s.get(i).getNomSymptome() == "INQUIETUDE" && s.get(i).getNomSymptome() == "TROUBLE_MUSCULAIRES" &&
    //            s.get(i).getNomSymptome() == "TROUBLE_SOMMEIL" && s.get(i).getNomSymptome() == "TROUBLE_CARDIAQUE" &&
    //            s.get(i).getNomSymptome() == "SUEURS" &&  s.get(i).getNomSymptome() == "CRISE_DE_PANIQUE" )

    //                   return true;
            
    //     }
    //     return false;

        
    // }
    
    // public boolean isDepressif(List<Symptome> s){

    //     for(int i=0; i < s.size(); i++) {
            
    //         if(s.get(i).getNomSymptome() == "TRISTESSE" && s.get(i).getNomSymptome() == "PERTE_INTERET" &&
    //            s.get(i).getNomSymptome() == "FATIGUE_SEVERE" && s.get(i).getNomSymptome() == "PERTE_APPETIT" &&
    //            s.get(i).getNomSymptome() == "TROUBLE_SOMMEIL" &&  s.get(i).getNomSymptome() == "PENSEES_SUICIDAIRES" )

    //                   return true;
            
    //     }
    //     return false;

        
    // }

}