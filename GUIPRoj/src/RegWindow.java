import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class RegWindow implements ActionListener {



    JFrame frame = new JFrame();

    JLabel newusenamelable = new JLabel("Felhasználó név:");
    JLabel passfieldlable = new JLabel("Jelszó:");
    JLabel passagainlable = new JLabel("Jelszó újra:");

    JTextField newusername = new JTextField();
    JPasswordField passfield = new JPasswordField();
    JPasswordField passagain = new JPasswordField();

    JButton elfogad = new JButton("Regisztrálás");

    ImageIcon ikon = new ImageIcon("register.png");
    RegWindow() throws IOException {

        newusenamelable.setForeground(Color.WHITE);
        passfieldlable.setForeground(Color.WHITE);
        passagainlable.setForeground(Color.WHITE);


        newusername.setPreferredSize(new Dimension(200 ,40));
        newusername.setBorder(BorderFactory.createEtchedBorder());
        newusername.setBackground(new Color(0x007DA5));
        newusername.setFont(new Font("CALIBRI",Font.PLAIN,25));
        newusername.setForeground(Color.white);
        newusername.setCaretColor(Color.WHITE);
        newusername.setBorder(null);

        passfield.setPreferredSize(new Dimension(200 ,40));
        passfield.setBorder(BorderFactory.createEtchedBorder());
        passfield.setBackground(new Color(0x007DA5));
        passfield.setFont(new Font("CALIBRI",Font.PLAIN,25));
        passfield.setForeground(Color.WHITE);
        passfield.setCaretColor(Color.WHITE);
        passfield.setEchoChar('*');
        passfield.setBorder(null);

        passagain.setPreferredSize(new Dimension(200 ,40));
        passagain.setBorder(BorderFactory.createEtchedBorder());
        passagain.setBackground(new Color(0x007DA5));
        passagain.setFont(new Font("CALIBRI",Font.PLAIN,25));
        passagain.setForeground(Color.WHITE);
        passagain.setCaretColor(Color.WHITE);
        passagain.setEchoChar('*');
        passagain.setBorder(null);

        elfogad.setPreferredSize(new Dimension(100,50));
        elfogad.setBorder(BorderFactory.createEtchedBorder());
        elfogad.setBackground(new Color(0x82CDD7));
        elfogad.addActionListener(this);
        elfogad.setForeground(Color.BLACK);
        elfogad.setFocusable(false);
        elfogad.setBorder(null);

        frame.setIconImage(ikon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,320);
        frame.setLayout(new FlowLayout());
        frame.setTitle("Regisztráció");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0x00324B));
        frame.add(newusenamelable);
        frame.add(newusername);
        frame.add(passfieldlable);
        frame.add(passfield);
        frame.add(passagainlable);
        frame.add(passagain);
        frame.add(elfogad);



        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public String getNewusername() {
        return newusername.getText();
    }

    public String getPassfield() {
        return String.valueOf(passfield.getPassword());
    }

    public String getPassagain() {
        return String.valueOf(passagain.getPassword());
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== elfogad){
            int value = Users.isValid(MAin.felhasznalok,getNewusername(),getPassfield(),getPassagain());

            frame.dispose();

            if (value == 7){
                MAin.felhasznalok.add(new Users(getNewusername(),getPassfield()));
                try {
                    FileUtils.beir("usernames.txt",getNewusername(),getPassfield());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            for(Users k: MAin.felhasznalok){
                System.out.println(k);
            }

            try {
                new GUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}

