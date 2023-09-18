public class BaseDeFait {
    
    String faits[];

    public BaseDeFait(String symptomes[]) {
        for (int i = 0; i < symptomes.length; i++) {
            faits[i] = symptomes[i];
        }
    }

    
}
