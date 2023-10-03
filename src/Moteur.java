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

    public String afficherSymptomesRequis(){
     
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

    
    public String afficherMaladiesDiagnostiquees(){
        String res = "";
        for(Rules r : this._rules){
            res += r.get_maladieDiagnostique() + "\n";
        }
        return res;
    }
}
