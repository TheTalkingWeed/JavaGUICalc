import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MAin {

    public static List<Users> felhasznalok;

    static {
        try {
            felhasznalok = new ArrayList<>(Users.createList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {


       // new GUI();
        new Calculator();
        //new Megoldo();
        //new FontFormater();
    }
}
