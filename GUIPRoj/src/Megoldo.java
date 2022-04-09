import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Megoldo implements ActionListener{

    JFrame frame = new JFrame();
    String[] keplettomb = {"Képletek","Másodfokú egyenlet","Pitagoras tétel"};

    JComboBox keplet = new JComboBox(keplettomb);

    JPanel megoldopanelek = new JPanel(new CardLayout());

    CardPanel ures = new CardPanel(null);
    CardPanel masodpanel = new CardPanel(null);
    CardPanel pitagoras = new CardPanel(null);

    JPanel submasodpanel = new JPanel();
    JPanel subpita = new JPanel();
    
    JTextField aertek = new JTextField();
    JTextField bertek = new JTextField();
    JTextField certek = new JTextField();

    JLabel alable = new JLabel("a érték:");
    JLabel blable = new JLabel("b érték:");
    JLabel clable = new JLabel("c érték:");

    JLabel megoldaslable = new JLabel("  megoldasok...");
   

    JButton solve = new JButton("Megold");

    JTextField pita = new JTextField();
    JTextField pitb = new JTextField();
    JTextField pitc = new JTextField();

    JLabel pital = new JLabel("a érték: ");
    JLabel pitbl = new JLabel("b érték: ");
    JLabel pitcl = new JLabel("c érték: ");
    JLabel pitend = new JLabel(" Eredmény...");
    Megoldo() {
        solve.addActionListener(this);
        solve.setFocusable(false);
        Dimension dim = new Dimension(100,25);
        Dimension subdim = new Dimension(200,200);
        pitagoras.setBackground(Color.WHITE);

        subpita.setLayout(new FlowLayout());
        subpita.setBackground(Color.WHITE);
        subpita.setPreferredSize(subdim);
        pita.setPreferredSize(dim);
        pitb.setPreferredSize(dim);
        pitc.setPreferredSize(dim);
        pitend.setPreferredSize(new Dimension(150,25));
        pitend.setBackground(Color.white);

        pitend.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        subpita.add(pital);
        subpita.add(pita);
        subpita.add(pitbl);
        subpita.add(pitb);
        subpita.add(pitcl);
        subpita.add(pitc);
        subpita.add(pitend);
        pitagoras.add(subpita);



        masodpanel.setLayout(new FlowLayout());


        aertek.setPreferredSize(dim);
        bertek.setPreferredSize(dim);
        certek.setPreferredSize(dim);

        megoldaslable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        megoldaslable.setBackground(Color.white);
        megoldaslable.setPreferredSize(new Dimension(200,25));
        megoldaslable.setOpaque(true);

        masodpanel.setPreferredSize(new Dimension(275,300));

        submasodpanel.setBackground(Color.WHITE);
        submasodpanel.setLayout(new FlowLayout());
        submasodpanel.setPreferredSize(subdim);

        submasodpanel.add(alable);
        submasodpanel.add(aertek);
        submasodpanel.add(blable);
        submasodpanel.add(bertek);
        submasodpanel.add(clable);
        submasodpanel.add(certek);
        submasodpanel.add(megoldaslable);
        masodpanel.add(submasodpanel);
        masodpanel.setBackground(Color.WHITE);

        ures.setBackground(Color.WHITE);
        
        megoldopanelek.add(ures,"Képletek");
        megoldopanelek.add(masodpanel,"Másodfokú egyenlet");
        megoldopanelek.add(pitagoras,"Pitagoras tétel");


        keplet.addActionListener(this);

        frame.setSize(320,420);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Képlet megoldó");
        frame.setBackground(Color.white);
        frame.add(keplet,BorderLayout.NORTH);
        frame.add(megoldopanelek,BorderLayout.WEST);
        frame.add(solve,BorderLayout.SOUTH);
        frame.setResizable(false);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==keplet ){
            JComboBox jcb = (JComboBox) e.getSource();
            CardLayout cl = (CardLayout) megoldopanelek.getLayout();
            cl.show(megoldopanelek, jcb.getSelectedItem().toString());
            System.out.println(keplet.getSelectedItem());
        }

        if(e.getSource()==solve && keplet.getSelectedItem().equals("Képletek")){
            JOptionPane.showMessageDialog(null,"Válassz ki egy képlet típust!","Üzenet",JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==solve && keplet.getSelectedItem().equals("Másodfokú egyenlet")){
            megoldaslable.setText(masodmegold());
        }

        if(e.getSource() == solve && keplet.getSelectedItem().equals("Pitagoras tétel")){
            pitend.setText(pitamegold());
        }
    }

    private String masodmegold(){


        if (aertek.getText().length() == 0 || bertek.getText().length() == 0 || bertek.getText().length() == 0) {
            JOptionPane.showMessageDialog(null,"Minden mezőt tölts ki","Üzenet",JOptionPane.PLAIN_MESSAGE);
        } else {

            double a = Double.parseDouble(aertek.getText());
            double b = Double.parseDouble(bertek.getText());
            double c = Double.parseDouble(certek.getText());

            double disz = (b*b)- 4 * a * c;

            double x1;
            double x2;

            if (a==0){
                return "  a = 0 nincs megoldás";
            }

            if(disz<0){
                return "nincs megoldás(D<0)";
            }

            if(disz == 0){
                double result = (-1*b)/(2*a);
                return String.valueOf(result);

            }

            if(disz>0){
                double result1 = ((-1*b)+Math.sqrt(disz))/(2/a);
                double result2 = ((-1*b)-Math.sqrt(disz))/(2/a);

                return String.format("x1 = %.2f , x2 = %.2f",result1,result2);
            }

        }


        return "";
    }
    private String pitamegold(){
        String result = "";
        int kitoltottmezok = 0;
        if(pita.getText().length()>0) kitoltottmezok++;
        if(pitb.getText().length()>0) kitoltottmezok++;
        if(pitc.getText().length()>0) kitoltottmezok++;

        double a;
        double b;
        double c;

        if(kitoltottmezok !=2) {
            JOptionPane.showMessageDialog(null, "Két mezőt tölts ki!", "Üzenet", JOptionPane.PLAIN_MESSAGE);
        }else {
            if (pita.getText().length() > 0 && pitb.getText().length() > 0) {
                a=Double.parseDouble(pita.getText());
                b=Double.parseDouble(pitb.getText());

                c=a*a+b*b;

                if(c<0){
                    return "Hibás paraméterek";
                }else {
                    return String.format("c: %.2f", Math.sqrt(c));
                }
            }
            if (pita.getText().length() > 0 && pitc.getText().length() > 0) {
                a=Double.parseDouble(pita.getText());
                c=Double.parseDouble(pitc.getText());

                b=c*c-a*a;
                if(b<0){
                    return "Hibás paraméterek";
                }else {
                    return String.format("b: %.2f",Math.sqrt(b));
                }
            }
            if (pitb.getText().length() > 0 && pitc.getText().length() > 0) {
                b=Double.parseDouble(pitb.getText());
                c=Double.parseDouble(pitc.getText());

                a=c*c-b*b;
                if(a<0){
                    return "Hibás paraméterek";
                }else {
                    return String.format("a: %.2f", Math.sqrt(a));
                }
            }
        }


        return result;
    }

}
