import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by denis__larin on 18.05.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
       Pr pr = new Pr(1000);
        System.out.println("число вариантов " + pr.numberStep);
    }
}
