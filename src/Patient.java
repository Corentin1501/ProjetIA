import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String _nom;
    private int _age;
    private List<Symptome> _symptomesDuPatient;

    public Patient(String nom, int age, List<Symptome> symptomes){
        this._nom = nom;
        this._age = age;
        this._symptomesDuPatient = new ArrayList<Symptome>();

        for (Symptome s : symptomes) {
            this._symptomesDuPatient.add(s);
        }
    }

    public String get_nom() {
        return _nom;
    }

    public int get_age() {
        return _age;
    }

    public List<Symptome> get_symptomesDuPatient() {
        return _symptomesDuPatient;
    }

    
 
}