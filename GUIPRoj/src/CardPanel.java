import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CardPanel extends JPanel {

    private static final Random random = new Random();
    private static final JPanel cards = new JPanel(new CardLayout());
    private static final JComboBox combo = new JComboBox();
    private final String name;

    public CardPanel(String name) {
        this.name = name;
        this.setPreferredSize(new Dimension(320, 240));
        this.setBackground(new Color(random.nextInt()));
        this.add(new JLabel(name));
    }
}