package se.jacobswenson.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class View extends JFrame implements ActionListener {

    private ViewFacade viewFacade;
    private JButton button1;
    private JButton button2;
    private JLabel text;
    private static String coolvetica = "src/se/jacobswenson/resources/coolveticarg.ttf";

    public View(ViewFacade facade) {
        this.viewFacade = facade;

        JPanel mainPanel = createPanel();
        button1 = createButton("1");
        button2 = createButton("2");
        text = createTextLabel("");

        JPanel buttonPanel = createPanel();
        buttonPanel.setLayout(new GridLayout(1,2,10,10));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        buttonPanel.setBorder(new EmptyBorder(10,10,10,10));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(createLabel("Tryck på knapparna"),BorderLayout.NORTH);
        mainPanel.add(text,BorderLayout.CENTER);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
        setSize(new Dimension(400,500));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(button1)) {
            viewFacade.UpdateText(1);
        } else if(e.getSource().equals(button2)) {
           viewFacade.UpdateText(2);
        }

    }

    public void changeLabelText(String text) {
        this.text.setText(text);
    }

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(246, 235, 219));
        return panel;
    }

    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(new Color(200, 57, 65));
        button.setBackground(Color.white);
        button.setOpaque(true);
        Border line = new LineBorder(new Color(200, 57, 65));
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        button.setPreferredSize(new Dimension(150,100));
        button.setFont(applyFont(coolvetica));
        return button;
    }

    private static Font applyFont(String path) {
        File font_file = new File(path);
        Font font=null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        Font sizedFont = font.deriveFont(18f);
        return sizedFont;
    }

    public static JLabel createLabel(String text) {
        JLabel jLabel = new JLabel(text,JLabel.CENTER);
        jLabel.setForeground(new Color(200, 57, 65));
        jLabel.setFont(applyFont(coolvetica));
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return jLabel;
    }

    public static JLabel createTextLabel(String text) {
        JLabel jLabel = new JLabel(text,JLabel.CENTER);
        jLabel.setForeground(new Color(200, 57, 65));
        Font font = applyFont(coolvetica);
        Font sizedFont = font.deriveFont(210f);
        jLabel.setFont(sizedFont);
        jLabel.setVerticalAlignment(JLabel.TOP);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel.setBorder(new EmptyBorder(10, 10, 60, 10));
        return jLabel;
    }

}
