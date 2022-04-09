import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.sqrt;


public class Calculator implements ActionListener {

    JFrame frame = new JFrame();
    public static JButton button0 = new JButton("0");
    public static JButton button1 = new JButton("1");
    public static JButton button2 = new JButton("2");
    public static JButton button3 = new JButton("3");
    public static JButton button4 = new JButton("4");
    public static JButton button5 = new JButton("5");
    public static JButton button6 = new JButton("6");
    public static JButton button7 = new JButton("7");
    public static JButton button8 = new JButton("8");
    public static JButton button9 = new JButton("9");

    public static JButton delete = new JButton("DEL");

    public static JButton sqr = new JButton("x^2");
    public static JButton sqrt = new JButton("√x");
    public static JButton sqr2 = new JButton("x^y");
    public static JButton sqrt2 = new JButton("y√x");
    public static JButton plusz = new JButton("+");
    public static JButton minusz = new JButton("-");
    public static JButton szoroz = new JButton("*");
    public static JButton oszt   = new JButton("/");
    public static JButton egyenlo = new JButton("=");

    public static JButton cos = new JButton("cos");
    public static JButton sin = new JButton("sin");
    public static JButton tan = new JButton("tan");
    public static JButton ctan = new JButton("ctan");
    
    JPanel numbers = new JPanel();
    JPanel operatorok = new JPanel();
    JPanel specialops = new JPanel();

    


    JLabel kijelzo = new JLabel("",SwingConstants.RIGHT);

    String output="";

    String kifejezes="";

    int pressedoperators = 0;

    boolean kiertekelve = false;

    ImageIcon ikon = new ImageIcon("calculator.png");

    JMenuBar menubar = new JMenuBar();
    JMenu settings = new JMenu("Beállítások");
    JMenu looks = new JMenu("Kinézet");
    JMenu help = new JMenu("Súgó");


    JMenuItem fonts = new JMenuItem("Betü formázás");
    JMenu theme = new JMenu("Téma");

    JMenu kepletek = new JMenu("Képletek");
    JMenuItem kepletmegoldo = new JMenuItem("Képlet megoldó");
    
    JMenuItem helper = new JMenuItem("Program használata");
    JMenuItem dark1 = new JMenuItem("Sötét lila");
    JMenuItem dark2 = new JMenuItem("Sötét szürke");
    JMenuItem light1 = new JMenuItem("Világos kék");
    JMenuItem light2 = new JMenuItem("Világos zöld");
    JMenuItem basic = new JMenuItem("Alap");
    JMenuItem exit = new JMenuItem("Kilépés");



    Calculator(){

    ConfigInput conin = new ConfigInput();

        changeFont(conin.getBetutipus(),conin.getBetumeret());

        kepletmegoldo.addActionListener(this);

        kepletek.add(kepletmegoldo);

        settings.add(looks);
        settings.add(exit);

        exit.addActionListener(this);
        dark1.addActionListener(this);
        dark2.addActionListener(this);
        light1.addActionListener(this);
        light2.addActionListener(this);
        basic.addActionListener(this);

        fonts.addActionListener(this);

        looks.add(theme);
        looks.add(fonts);

        theme.add(dark1);
        theme.add(dark2);
        theme.add(light1);
        theme.add(light2);
        theme.add(basic);

        helper.addActionListener(this);

        help.add(helper);

        menubar.add(settings);
        menubar.add(help);
        menubar.add(kepletek);

        sqr.setBorder(null);
        sqr.setFocusable(false);
        sqr.addActionListener(this);

        sqr2.setBorder(null);
        sqr2.setFocusable(false);
        sqr2.addActionListener(this);

        sqrt.setBorder(null);
        sqrt.setFocusable(false);
        sqrt.addActionListener(this);

        sqrt2.setBorder(null);
        sqrt2.setFocusable(false);
        sqrt2.addActionListener(this);

        cos.setBorder(null);
        cos.setFocusable(false);
        cos.addActionListener(this);

        sin.setBorder(null);
        sin.setFocusable(false);
        sin.addActionListener(this);

        tan.setBorder(null);
        tan.setFocusable(false);
        tan.addActionListener(this);

        ctan.setBorder(null);
        ctan.setFocusable(false);
        ctan.addActionListener(this);



        button0.setPreferredSize(new Dimension(50,50));
        button0.setBorder(null);
        button0.setFocusable(false);
        button0.addActionListener(this);


        button1.setPreferredSize(new Dimension(50,50));
        button1.setBorder(null);
        button1.setFocusable(false);
        button1.addActionListener(this);

        button2.setPreferredSize(new Dimension(50,50));
        button2.setBorder(null);
        button2.setFocusable(false);
        button2.addActionListener(this);

        button3.setPreferredSize(new Dimension(50,50));
        button3.setBorder(null);
        button3.setFocusable(false);
        button3.addActionListener(this);

        button4.setPreferredSize(new Dimension(50,50));
        button4.setBorder(null);
        button4.setFocusable(false);
        button4.addActionListener(this);

        button5.setPreferredSize(new Dimension(50,50));
        button5.setBorder(null);
        button5.setFocusable(false);
        button5.addActionListener(this);

        button6.setPreferredSize(new Dimension(50,50));
        button6.setBorder(null);
        button6.setFocusable(false);
        button6.addActionListener(this);

        button7.setPreferredSize(new Dimension(50,50));
        button7.setBorder(null);
        button7.setFocusable(false);
        button7.addActionListener(this);

        button8.setPreferredSize(new Dimension(50,50));
        button8.setBorder(null);
        button8.setFocusable(false);
        button8.addActionListener(this);

        button9.setPreferredSize(new Dimension(50,50));
        button9.setBorder(null);
        button9.setFocusable(false);
        button9.addActionListener(this);

        delete.setPreferredSize(new Dimension(60,50));
        delete.setBorder(null);
        delete.setFocusable(false);
        delete.addActionListener(this);

        plusz.setFocusable(false);
        plusz.setBorder(null);
        plusz.addActionListener(this);

        minusz.setFocusable(false);
        minusz.setBorder(null);
        minusz.addActionListener(this);

        szoroz.setFocusable(false);
        szoroz.setBorder(null);
        szoroz.addActionListener(this);

        oszt.setFocusable(false);
        oszt.setBorder(null);
        oszt.addActionListener(this);

        egyenlo.setPreferredSize(new Dimension(60,275));
        egyenlo.setFocusable(false);
        egyenlo.setBorder(null);
        egyenlo.addActionListener(this);


        numbers.setPreferredSize(new Dimension(200,230));
        numbers.setBackground(Color.lightGray);
        numbers.setBorder(null);
        numbers.setLayout(new FlowLayout());


        operatorok.setLayout(new GridLayout(5,1));
        operatorok.setPreferredSize(new Dimension(60,275));
        operatorok.setBorder(null);
        operatorok.add(delete);
        operatorok.add(plusz);
        operatorok.add(minusz);
        operatorok.add(szoroz);
        operatorok.add(oszt);

        specialops.setLayout(new GridLayout(2,3));
        specialops.setPreferredSize(new Dimension(310,50));

        specialops.add(sqr);
        specialops.add(sqr2);
        specialops.add(sqrt);
        specialops.add(sqrt2);
        specialops.add(cos);
        specialops.add(sin);
        specialops.add(tan);
        specialops.add(ctan);



        numbers.add(button1);
        numbers.add(button2);
        numbers.add(button3);
        numbers.add(button4);
        numbers.add(button5);
        numbers.add(button6);
        numbers.add(button7);
        numbers.add(button8);
        numbers.add(button9);
        numbers.add(button0);

        kijelzo.setPreferredSize(new Dimension(200,65));
        kijelzo.setBorder(null);
        kijelzo.setBackground(Color.white);
        kijelzo.setFont(new Font("Calibri",Font.PLAIN,40));
        kijelzo.setForeground(Color.BLACK);
        kijelzo.setOpaque(true);


        frame.setIconImage(ikon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(310,340);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Szamológép");
        frame.setResizable(false);
        frame.add(kijelzo,BorderLayout.NORTH);
        frame.add(numbers,BorderLayout.CENTER);
        frame.add(operatorok,BorderLayout.WEST);
        frame.add(egyenlo,BorderLayout.EAST);
        frame.add(specialops,BorderLayout.SOUTH);
        frame.setJMenuBar(menubar);
        setColor(Color.WHITE,Color.BLACK,Color.GRAY,Color.LIGHT_GRAY);


        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button0 && output.length()!=0){
            if (kiertekelve){
                output="";
                output += "0";
                kiertekelve = false;
            }else output += "0";
            kifejezes += "0";
            kijelzo.setText(output);
        }
        if (e.getSource()==button1){
            if (kiertekelve){
                output="";
                output += "1";
                kiertekelve = false;
            }else output += "1";
            kifejezes += "1";
            kijelzo.setText(output);
        }
        if (e.getSource()==button2){
            if (kiertekelve){
                output="";
                output += "2";
                kiertekelve = false;
            }else output += "2";
            kifejezes += "2";
            kijelzo.setText(output);
        }
        if (e.getSource()==button3){
            if (kiertekelve){
                output="";
                output += "3";
                kiertekelve = false;
            }else output += "3";
            kifejezes += "3";
            kijelzo.setText(output);
        }
        if (e.getSource()==button4){
            if (kiertekelve){
                output="";
                output += "4";
                kiertekelve = false;
            }else output += "4";
            kifejezes += "4";
            kijelzo.setText(output);
        }
        if (e.getSource()==button5){
            if (kiertekelve){
                output="";
                output += "5";
                kiertekelve = false;
            }else output += "5";
            kifejezes += "5";
            kijelzo.setText(output);
        }
        if (e.getSource()==button6){
            if (kiertekelve){
                output="";
                output += "6";
                kiertekelve = false;
            }else output += "6";
            kifejezes += "6";
            kijelzo.setText(output);
        }
        if (e.getSource()==button7){
            if (kiertekelve){
                output="";
                output += "7";
                kiertekelve = false;
            }else output += "7";
            kifejezes += "7";
            kijelzo.setText(output);
        }
        if (e.getSource()==button8){
            if (kiertekelve){
                output="";
                output += "8";
                kiertekelve = false;
            }else output += "8";
            kifejezes += "8";
            kijelzo.setText(output);
        }
        if (e.getSource()==button9){
            if (kiertekelve){
                output="";
                output += "9";
                kiertekelve = false;
            }else output += "9";
            kifejezes += "9";
            kijelzo.setText(output);
        }
        if(e.getSource()==delete){
            output="";
            kifejezes = "";
            pressedoperators = 0;
            kiertekelve = false;
            kijelzo.setText(output);
        }
        if(e.getSource()==plusz && pressedoperators == 0 && kifejezes.length() !=0){
            output = "";
            kifejezes +=" + ";
            pressedoperators++;
            kijelzo.setText(output);

        }
        if(e.getSource()== minusz && pressedoperators == 0 && kifejezes.length() !=0){
            output = "";
            kifejezes +=" - ";
            pressedoperators++;
            kijelzo.setText(output);
        }
        if(e.getSource()== szoroz && pressedoperators == 0 && kifejezes.length() !=0){
            output = "";
            kifejezes +=" * ";
            pressedoperators++;
            kijelzo.setText(output);
        }
        if(e.getSource()== oszt && pressedoperators == 0 && kifejezes.length() !=0){
            output = "";
            kifejezes +=" / ";
            pressedoperators++;
            kijelzo.setText(output);
        }
        if(e.getSource()==egyenlo && pressedoperators !=0){
            pressedoperators = 0;
            kiertekelve = true;
            kijelzo.setText(kiertekel(kifejezes));
            System.out.println(kifejezes);
            kifejezes ="";
        }
        if(e.getSource()==sqr && kifejezes.length()!=0){
            pressedoperators = 0;
            kiertekelve = true;
            int a = Integer.parseInt(output)*Integer.parseInt(output);
            kijelzo.setText(String.valueOf(a));

            kifejezes="";
        }
        if(e.getSource()== sqr2 && pressedoperators == 0 && kifejezes.length() !=0){
            output = "";
            kifejezes +=" ^ ";
            pressedoperators++;
            kijelzo.setText(output);
        }
        if(e.getSource()==sqrt && kifejezes.length()!=0){
            pressedoperators = 0;
            kiertekelve = true;
            double a = sqrt(Integer.parseInt(output));

            int intPart = (int) a;

            if (a-intPart == 0){
                kijelzo.setText(String.valueOf(intPart));
            }else{
                kijelzo.setText(String.valueOf(a));
            }



            kifejezes="";
        }
        if(e.getSource()== sqrt2 && pressedoperators == 0 && kifejezes.length() != 0){
            output = "";
            kifejezes +=" √ ";
            pressedoperators++;
            kijelzo.setText(output);
        }
        if (e.getSource()==cos && pressedoperators == 0 && kifejezes.length() != 0){
            pressedoperators = 0;
            kiertekelve = true;
            double a = Math.cos(Double.parseDouble(output));
            kijelzo.setText(String.valueOf(a));
            kifejezes="";
        }

        if (e.getSource()==sin && pressedoperators == 0 && kifejezes.length() != 0){
            pressedoperators = 0;
            kiertekelve = true;
            double a = Math.sin(Double.parseDouble(output));
            kijelzo.setText(String.valueOf(a));
            kifejezes="";
        }

        if (e.getSource()==tan && pressedoperators == 0 && kifejezes.length() != 0){
            pressedoperators = 0;
            kiertekelve = true;
            double a = Math.tan(Double.parseDouble(output));
            kijelzo.setText(String.valueOf(a));
            kifejezes="";
        }

        if (e.getSource()==ctan && pressedoperators == 0 && kifejezes.length() != 0){
            System.out.println("not programmed yet :)");
        }
        if (e.getSource()==dark1){
            Color gombok = new Color(48,27,63);
            Color betuszinek = new Color(180,165,165);
            Color hatter = new Color(21,21,21);
            Color kijelzohatter = new Color(60,65,92);

            setColor(gombok,betuszinek,hatter,kijelzohatter);
        }
        if (e.getSource()==dark2){
            Color gombok = new Color(65,63,56);
            Color betuszinek = new Color(244,142,176);
            Color hatter = new Color(36,33,29);
            Color kijelzohatter = new Color(60,45,47);

            setColor(gombok,betuszinek,hatter,kijelzohatter);
        }
        if(e.getSource()==light1){
            Color gombok = new Color(117,157,217);
            Color betuszinek = new Color(207,218,236);
            Color hatter = new Color(8,77,117);
            Color kijelzohatter = new Color(156,184,208);

            setColor(gombok,betuszinek,hatter,kijelzohatter);
        }
        if(e.getSource()==light2){
            Color gombok = new Color(100,172,143);
            Color betuszinek = new Color(230,245,221);
            Color hatter = new Color(74,97,85);
            Color kijelzohatter = new Color(149,215,186);

            setColor(gombok,betuszinek,hatter,kijelzohatter);
        }
        if(e.getSource()==basic){
            setColor(Color.WHITE,Color.BLACK,Color.GRAY,Color.LIGHT_GRAY);
        }
        if(e.getSource()==helper){
             File htmlFile = new File("help.html");
            try {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==exit){
            System.exit(0);
        }
        if(e.getSource()==fonts){
            new FontFormater();
        }
        if(e.getSource()==kepletmegoldo){
            new Megoldo();
        }
    }

    private void setColor(Color gombok, Color betuszinek,Color hatter,Color kijelzohatter){

        sqr.setBackground(gombok);
        sqr2.setBackground(gombok);
        sqrt.setBackground(gombok);
        sqrt2.setBackground(gombok);
        button0.setBackground(gombok);
        button1.setBackground(gombok);
        button2.setBackground(gombok);
        button3.setBackground(gombok);
        button4.setBackground(gombok);
        button5.setBackground(gombok);
        button6.setBackground(gombok);
        button7.setBackground(gombok);
        button8.setBackground(gombok);
        button9.setBackground(gombok);
        delete.setBackground(gombok);
        plusz.setBackground(gombok);
        minusz.setBackground(gombok);
        szoroz.setBackground(gombok);
        oszt.setBackground(gombok);
        egyenlo.setBackground(gombok);
        cos.setBackground(gombok);
        sin.setBackground(gombok);
        tan.setBackground(gombok);
        ctan.setBackground(gombok);


        sqr.setForeground(betuszinek);
        sqr2.setForeground(betuszinek);
        sqrt.setForeground(betuszinek);
        sqrt2.setForeground(betuszinek);
        button0.setForeground(betuszinek);
        button1.setForeground(betuszinek);
        button2.setForeground(betuszinek);
        button3.setForeground(betuszinek);
        button4.setForeground(betuszinek);
        button5.setForeground(betuszinek);
        button6.setForeground(betuszinek);
        button7.setForeground(betuszinek);
        button8.setForeground(betuszinek);
        button9.setForeground(betuszinek);
        delete.setForeground(betuszinek);
        plusz.setForeground(betuszinek);
        minusz.setForeground(betuszinek);
        szoroz.setForeground(betuszinek);
        oszt.setForeground(betuszinek);
        egyenlo.setForeground(betuszinek);
        cos.setForeground(betuszinek);
        sin.setForeground(betuszinek);
        tan.setForeground(betuszinek);
        ctan.setForeground(betuszinek);


        kijelzo.setForeground(betuszinek);

        kijelzo.setBackground(kijelzohatter);
        operatorok.setBackground(hatter);


        frame.getContentPane().setBackground(hatter);

        numbers.setBackground(hatter);
    }

    public static void changeFont(String type,int size){
        
        Font betutipus = new Font(type,Font.PLAIN,size);
        button0.setFont(betutipus);
        button1.setFont(betutipus);
        button2.setFont(betutipus);
        button3.setFont(betutipus);
        button4.setFont(betutipus);
        button5.setFont(betutipus);
        button6.setFont(betutipus);
        button7.setFont(betutipus);
        button8.setFont(betutipus);
        button9.setFont(betutipus);

        sqr.setFont(betutipus);
        sqr2.setFont(betutipus);
        sqrt.setFont(betutipus);
        sqrt2.setFont(betutipus);
        cos.setFont(betutipus);
        sin.setFont(betutipus);
        tan.setFont(betutipus);
        ctan.setFont(betutipus);


        delete.setFont(betutipus);
        plusz.setFont(betutipus);
        minusz.setFont(betutipus);
        szoroz.setFont(betutipus);
        oszt.setFont(betutipus);

        egyenlo.setFont(betutipus);

    }
    

    public String kiertekel(String kif){
        double result=0;
        String[] temp;
        if(kif.contains(" + ")){
            temp = kif.split(" \\+ ");
            result = Double.parseDouble(temp[0])+Double.parseDouble(temp[1]);

        }
        if(kif.contains("-")){
            temp = kif.split(" - ");
            result = Double.parseDouble(temp[0])-Double.parseDouble(temp[1]);
        }
        if(kif.contains("*")){
            temp = kif.split(" \\* ");
            result = Double.parseDouble(temp[0])*Double.parseDouble(temp[1]);
        }
        if(kif.contains("/")){
            temp = kif.split(" / ");
            result = Double.parseDouble(temp[0])/Double.parseDouble(temp[1]);
        }
        if(kif.contains("^")){
            temp = kif.split(" \\^ ");
            result = Math.pow(Double.parseDouble(temp[0]),Double.parseDouble(temp[1]));
        }
        if(kif.contains("√")){
            temp = kif.split(" √ ");
            result = Math.pow(Double.parseDouble(temp[0]),1/Double.parseDouble(temp[1]));
        }
        int intPart = (int) result;

        if (result-intPart == 0){
            return String.valueOf(intPart);
        }

        return String.valueOf(result);
    }


}
