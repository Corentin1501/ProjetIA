
public class Symptome {
    
    private String nom;
    private int niveau;
   

    public Symptome(String nom, int niveau) {
        this.nom = nom;
        this.niveau = niveau;
    }


    public String getNom() { return nom;    }
    public int getNiveau() { return niveau; }

    public boolean equals(Symptome s){
        return nom == s.getNom();
    
    }
}