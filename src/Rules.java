import java.util.List;
import java.util.ArrayList;

public class Rules {

    private List<Symptome> _symptomesRequis;
    private Maladie _maladieDiagnostique;
    
    public Rules(List<Symptome> symptomeRequis, Maladie maladie) {
        this._symptomesRequis = new ArrayList<Symptome>();
        for (Symptome s : symptomeRequis) {
            this._symptomesRequis.add(s);
        }
        this._maladieDiagnostique = maladie;
    }

    public boolean evaluer(List<Symptome> symptomesPresent) {
        int nombreSymptomesRequis = this._symptomesRequis.size();
        int nombreSymptomesPresent = 0;

        // System.out.println("\nEvaluation de la regle pour " + this._maladieDiagnostique.getNomMaladie());
        // System.out.println("Symptomes requis :");
        // for(Symptome s : _symptomesRequis){
        //     System.out.println("\t- " + s.get_nom());
        // }


        for(Symptome symptRequis : this._symptomesRequis){
            for(Symptome symptPatient : symptomesPresent){
                if (symptPatient.getNomSymptome() == symptRequis.getNomSymptome()){
                    nombreSymptomesPresent++;
                }
            }
        }
        // System.out.println("\nNombre de symptome requis : " + nombreSymptomesRequis + "\nNombre de symptome présent : " + nombreSymptomesPresent);
        return (nombreSymptomesRequis == nombreSymptomesPresent);
    }

    public List<Symptome> get_symptomesRequis() {
        return _symptomesRequis;
    }

    public Maladie get_maladieDiagnostique() {
        return _maladieDiagnostique;
    }

    

}
