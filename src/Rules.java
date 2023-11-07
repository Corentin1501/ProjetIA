import java.util.List;
import java.util.ArrayList;

public class Rules {

    private List<Symptome> symptomesRequis;
    private Symptome consequence;
    
    public Rules(List<Symptome> symptomeRequis, Symptome consequence) {
        this.symptomesRequis = new ArrayList<Symptome>();

        for (Symptome s : symptomesRequis) {
            this.symptomesRequis.add(s);
        }
        this.consequence = consequence;
    }

    public boolean evaluer(List<Symptome> symptomesPresent) {
        int nombreSymptomesRequis = this.symptomesRequis.size();
        int symptomesPresents = 0;

        for(Symptome symptomeRequis : this.symptomesRequis){
            for(Symptome symptPersonne : symptomesPresent){
                if (symptPersonne.get_nom() == symptomeRequis.get_nom()){
                    symptomesPresents++;
                }
            }
        }
        return (nombreSymptomesRequis == symptomesPresents);
    }

    public List<Symptome> getSymptomesRequis(){ return symptomesRequis; }
    public Symptome getConsequence(){ return consequence; }
    
}