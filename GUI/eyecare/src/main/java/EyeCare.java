
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class EyeCare extends JPanel implements ItemListener {

    JPanel cards;

    public EyeCare() {

        // GridBagLayout to center the comboboxpane
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.weightx = 1;
        c.anchor = GridBagConstraints.NORTH;

        cards = new JPanel(new CardLayout());

        final String workPanel = "work";
        final String breakPanel = "break";

        // Adding the Work and Break panel that I created with the forms
        WorkPanel p1 = new WorkPanel();
        BreakPanel p2 = new BreakPanel();

        cards.add(p1, workPanel);
        cards.add(p2, breakPanel);

        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { workPanel, breakPanel };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        add(comboBoxPane, c);
        c.weighty = 1;
        add(cards, c);

    }

    // This is what changes the panels
    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)e.getItem());
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("EyeCare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EyeCare newEyeCare = new EyeCare();
        newEyeCare.setOpaque(true);
        frame.setContentPane(newEyeCare);

        frame.pack();
        frame.setVisible(true);
    }

    // sets the initial size of the window of the application
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(487, 183);
    }
}