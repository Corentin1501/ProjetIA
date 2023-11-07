import java.util.*;

public class Personne {

    private String nom;
    private int age;
    private List<Symptome> symptomesDeLaPersonne;

    public Personne(String nom, int age, List<Symptome> symptomes){
        this.nom = nom;
        this.age = age;
        this.symptomesDeLaPersonne = new ArrayList<Symptome>();

        for (Symptome symptome : symptomes) {
            this.symptomesDeLaPersonne.add(symptome);
        }
    }

    public Boolean isVieux(){ return age >= 70; }

    public String getNom(){ return nom; }
    public int getAge(){    return age; }
    public List<Symptome> getSymptomesDeLaPersonne(){   return symptomesDeLaPersonne;   }

    
 
}