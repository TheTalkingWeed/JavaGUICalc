import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FontFormater implements ChangeListener, ActionListener {

    JFrame frame = new JFrame();

    public static JSlider betumeret = new JSlider(15,30,22);
    JLabel sliderlable = new JLabel("Betü méret: ");
    JLabel sliderertek = new JLabel(String.valueOf(betumeret.getValue()));

    JPanel sliderpanel = new JPanel();
    JPanel fontpanel = new JPanel();

    JButton oksaa = new JButton("Mentés");


    private static String[] temp1 = {"Arial","Arial Black","Verdana","Garamond","Courier new","Times new roman","Calibri"};

    public static JComboBox types1 = new JComboBox(temp1);


    FontFormater(){



        betumeret.setPaintTicks(true);
        betumeret.setMajorTickSpacing(5);
        betumeret.setPaintLabels(true);
        betumeret.addChangeListener(this);

        oksaa.addActionListener(this);

        types1.addActionListener(this);

        sliderpanel.setLayout(new FlowLayout());

        sliderpanel.add(sliderlable);
        sliderpanel.add(betumeret);
        sliderpanel.add(sliderertek);

        fontpanel.add(types1);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(360,200);
        frame.setTitle("Betu beállítások");
        frame.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.add(sliderpanel);
        frame.add(fontpanel);
        frame.add(oksaa);


        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }



    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource()==betumeret){
            sliderertek.setText(String.valueOf(betumeret.getValue()));
            Calculator.changeFont(String.valueOf(types1.getSelectedItem()),betumeret.getValue());


        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==types1){
            Calculator.changeFont(String.valueOf(types1.getSelectedItem()),betumeret.getValue());

        }

        if(e.getSource()==oksaa){
            frame.dispose();
            try {
                FileUtils.saveConfig();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
