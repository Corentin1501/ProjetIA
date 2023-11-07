import java.util.*;

public class Personne {

    private String nom;
    private int age;
    private List<Symptome> symptomesDeLaPersonne;
    private List<Personne> personnesEnContact;


    public Personne(String nom, int age, List<Symptome> symptomes, List<Personne> personnesEnContact){
        this.nom = nom;
        this.age = age;
        this.symptomesDeLaPersonne = new ArrayList<Symptome>(symptomes);
        if (personnesEnContact != null) {
            this.personnesEnContact = new ArrayList<Personne>(personnesEnContact);
        }
    }

    public Boolean isVieux(){ return age >= 70; }

    public void ajouterSymptome(Symptome symptome) { symptomesDeLaPersonne.add(symptome); }

    public String getNom(){ return nom; }
    public int getAge(){    return age; }
    public List<Symptome> getSymptomesDeLaPersonne(){   return symptomesDeLaPersonne;   }
    public List<Personne> getPersonnesEnContact() {     return personnesEnContact;      }
    

    
 
}