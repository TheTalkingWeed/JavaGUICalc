import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Users {
    private final String username;
    private final String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static boolean letezik(String user, String pass){


        for(Users e: MAin.felhasznalok){
            if(user.equals(e.getUsername())&&pass.equals(e.getPassword())) return true;
        }

        return false;
    }

    public static int isValid(List<Users> lista,String username,String pass,String passagain){



        if (!pass.equals(passagain)){
            JOptionPane.showMessageDialog(null,"A jelszavak nem egyeznek!","Üzenet",JOptionPane.WARNING_MESSAGE);
            return  0;
        }

        for(Users e: lista){
            if (username.equals(e.getUsername())){
                JOptionPane.showMessageDialog(null,"Felhasználónév foglalt!","Üzenet",JOptionPane.WARNING_MESSAGE);
                return 1;
            }

        }

        if(username.length()==0){
            JOptionPane.showMessageDialog(null,"Adjon meg egy felhasználónevet!","Üzenet",JOptionPane.WARNING_MESSAGE);
            return 2;
        }

        if (pass.length()==0 || passagain.length()==0){
            JOptionPane.showMessageDialog(null,"Nincs jelszó megadva vagy nincs megerősítve!","Üzenet",JOptionPane.WARNING_MESSAGE);
            return 3;
        }

        if(username.contains(" ")){
            JOptionPane.showMessageDialog(null,"A felhasználónév nem tartalmazhat szóközt!","Üzenet",JOptionPane.WARNING_MESSAGE);

            return 4;
        }

        JOptionPane.showMessageDialog(null,"Regisztráció sikeres!","Üzenet",JOptionPane.PLAIN_MESSAGE);



        return 7;
    }


    public static List<Users> createList() throws IOException {
        List<String> lista = new ArrayList<>(FileUtils.beolvas("usernames.txt"));
        List<Users> felhasznalok = new ArrayList<>();
        String[] temp;
        for(String e : lista){
            temp = e.split(" ");
            felhasznalok.add(new Users(temp[0],temp[1]));
        }

        return felhasznalok;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
