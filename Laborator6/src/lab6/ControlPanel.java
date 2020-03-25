package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        saveButton.setBounds( 50,100,95,30 );
        saveButton.addActionListener(this::save);
        frame.add(saveButton);

        loadButton.setBounds(150 ,100,95,30 );
        loadButton.addActionListener(this::load);
        frame.add(loadButton);

        resetButton.setBounds(250,100,95,30);
        resetButton.addActionListener(this::reset);
        frame.add(resetButton);

        exitButton.setBounds(350,100,95,30);
        exitButton.addActionListener(this::exit);
        frame.add(exitButton);

    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("/Users/vlad.dexamir/Documents/FacultateSem2 Labs/Java/Laborator6/SaveDirectory/test.png"));
        } catch (IOException er) {
            System.err.println(er);
        }
    }

    private void load(ActionEvent e) {
        BufferedImage image = null;

        try{
             image = ImageIO.read(new File("/Users/vlad.dexamir/Documents/FacultateSem2 Labs/Java/Laborator6/SaveDirectory/1.jpg"));

        }catch (IOException er) {
            System.err.println(er);
        }

        frame.add(new JLabel(new ImageIcon(image)));
    }

    private void reset(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    private void exit(ActionEvent e) {
        frame.setVisible(false);
        frame.dispose();
    }


}
