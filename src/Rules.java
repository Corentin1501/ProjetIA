import java.util.List;
import java.util.ArrayList;

public class Rules {

    private List<Symptome> symptomesRequis;
    private Symptome consequence;
    private int niveau;
    private int numero;
    
    public Rules(List<Symptome> symptomeRequis, Symptome consequence, int niveau, int numero) {
        this.symptomesRequis = new ArrayList<Symptome>(symptomeRequis);
        this.consequence = consequence;
        this.niveau = niveau;
        this.numero = numero;
    }

    public boolean evaluer(List<Symptome> symptomesPresent) {
        int nombreSymptomesRequis = this.symptomesRequis.size();
        int symptomesPresents = 0;

        for(Symptome symptomeRequis : this.symptomesRequis){
            for(Symptome symptPersonne : symptomesPresent){
                if (symptPersonne.getNom() == symptomeRequis.getNom()){
                    symptomesPresents++;
                }
            }
        }
        return (nombreSymptomesRequis == symptomesPresents);
    }

    public List<Symptome> getSymptomesRequis(){ return symptomesRequis; }
    public Symptome getConsequence(){ return consequence; }
    public int getNiveau() { return niveau; }
    public int getNumero() { return numero; }

    

}