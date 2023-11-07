import java.util.List;
import java.util.ArrayList;

public class Moteur {

    private List<Rules> _rules;
    private List<Symptome> _baseDeFait;
    

    public Moteur(List<Rules> r, List<Symptome> b){
        _rules = new ArrayList<Rules>();
        _baseDeFait = new ArrayList<Symptome>();

        for(Symptome s : b) 
            this._baseDeFait.add(s);
       
        for(Rules rul : r)
            this._rules.add(rul);
   
    }
    
    public List<Symptome> getBaseDeFait(){
        return this._baseDeFait;
    }

    public List<Rules> getRules(){
        return this._rules;
    }

    public boolean diagnosticMaladie(List<Symptome> s1, List<Symptome> s2 ) {
        for(Symptome symptRequis : s1){
            for(Symptome symptPatient : s2){
                if (symptPatient.getNomSymptome() == symptRequis.getNomSymptome()){
                    return true;
                }
            }
        }
        return false;
    }    

    public String afficherRegles(){
     
        List<Symptome> res = new ArrayList<Symptome>();

        for(Rules r : _rules){
            for (Symptome symptome : r.get_symptomesRequis()) {
                res.add(symptome);
            }
        }
   
        String resString = " R1: ";
        for(Symptome s : res){

            resString += s.getNomSymptome() +" ∧ ";
        }


        
        
        return resString;
    }

   
    

    

}
