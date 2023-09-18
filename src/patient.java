import java.util.List;

public class patient {

    String _nom;
    int _age;
    List<symptome> symptomesDuPatient;

    public patient(String n, int a, List<symptome> sympt){
        this._nom = n;
        this._age = a;
        this.symptomesDuPatient =sympt;
    }

}
