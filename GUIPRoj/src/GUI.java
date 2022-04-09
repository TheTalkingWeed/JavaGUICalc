import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GUI implements ActionListener  {




    JFrame frame;
    JButton submit;
    JButton register;
    JTextField username;
    JPasswordField password;
    ImageIcon ikon= new ImageIcon("mainicon.png");
    ImageIcon pipa= new ImageIcon("pipa.png");
    public GUI() throws IOException {




        frame = new JFrame();

        submit = new JButton("Belépés");
        submit.setPreferredSize(new Dimension(100,50));
        submit.setBorder(null);
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setBackground(new Color(0x82CDD7));
        submit.setForeground(Color.BLACK);

        register = new JButton("Regisztráció");
        register.setPreferredSize(new Dimension(100,50));
        register.setBorder(null);
        register.addActionListener(this);
        register.setFocusable(false);
        register.setBackground(new Color(0x82CDD7));
        register.setForeground(Color.BLACK);


        username = new JTextField();
        username.setPreferredSize(new Dimension(200 ,40));
        username.setBorder(null);
        username.setBackground(new Color(0x007DA5));
        username.setFont(new Font("calibri",Font.PLAIN,25));
        username.setForeground(Color.WHITE);
        username.setCaretColor(Color.WHITE);

        password = new JPasswordField();
        password.setPreferredSize(new Dimension(200 ,40));
        password.setBorder(null);
        password.setBackground(new Color(0x007DA5));
        password.setFont(new Font("Calibri",Font.PLAIN,25));
        password.setForeground(Color.WHITE);
        password.setEchoChar('*');
        password.setCaretColor(Color.WHITE);

        frame.setIconImage(ikon.getImage());
        frame.setTitle("Belepes");
        frame.setSize(250,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(new Color(0x00324B));




        frame.add(username);
        frame.add(password);
        frame.add(submit);
        frame.add(register);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return String.valueOf(password.getPassword());
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==submit){
            if(Users.letezik(getUsername(),getPassword())){
               JOptionPane.showMessageDialog(null,"Sikeres belépés!","Üzenet",JOptionPane.INFORMATION_MESSAGE,pipa);
               frame.dispose();
               new Calculator();
            }else {
                JOptionPane.showMessageDialog(null,"Helytelen felhasznalónév vagy jelszó!","Üzenet",JOptionPane.WARNING_MESSAGE);
            }
        }


        if(e.getSource()== register){
            frame.dispose();
            try {
                new RegWindow();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


}
