package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides");
        sidesField = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6);

        Random rand = new Random();
        Color colors[]  = new Color[100];
        for(int i=0;i<100;i++) {
            colors[i] = new Color(rand.nextInt(0xFFFFFF));
        }
        colorCombo = new JComboBox(colors);
        colorCombo.setMaximumRowCount(2);
        colorCombo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event)
            {

                if (event.getStateChange() == ItemEvent.SELECTED)
                {
                    frame.setBackground(colors[colorCombo.getSelectedIndex()]);
                    frame.repaint();
                }

            }
        });

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);

    }
}
