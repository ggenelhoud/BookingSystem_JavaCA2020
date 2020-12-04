/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import controller.Controller;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

/**
 *
 * @author bacana
 */
public class MainFrame extends JFrame {

    Controller controller;

    public MainFrame(Controller controller) {
        this.controller = new Controller();
        new MainFrame();
    }

    public MainFrame() {
        frame();
    }

    public void frame() {

        this.setTitle("Grafton Barber");
        this.setSize(700, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JButton Bookings = new JButton("Bookings");
        JButton Feedback = new JButton("Feedback");
        JButton Delete = new JButton("Delete");
        JButton Submit = new JButton("Submit");
        JButton Close = new JButton("Close");

        Container mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));
        mainContainer.setBackground(new Color(212, 198, 94));
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(153, 120, 92)));

        //LOGO BARBER
        ImageIcon barberLogo = new ImageIcon("logo-barbershop.png");
        JLabel labelBarber = new JLabel(barberLogo);

        //Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(new Color(169, 140, 7), 3));
        topPanel.setBackground(new Color(153, 120, 92));
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 250, 1));
        mainContainer.add(topPanel, BorderLayout.NORTH);
        topPanel.add(labelBarber);
        topPanel.add(Close);

    // ->> LEFT CENTER PANEL 
        // LEFT FLOW LAYOUT
        JPanel lmidPanel = new JPanel();
        lmidPanel.setBorder(new LineBorder(new Color(169, 140, 7), 3));
        lmidPanel.setLayout(new FlowLayout(4, 4, 4));
        lmidPanel.setBackground(new Color(153, 120, 92));

        // LEFT GRID LAYOUT // MENU NUTTONS
        JPanel lGridPanel = new JPanel();
        lGridPanel.setLayout(new GridLayout(2, 1, 5, 5));
        lGridPanel.setBackground(new Color(153, 120, 92));
        lGridPanel.add(Bookings);
        lGridPanel.add(Feedback);

    // -->> MIDDLE CENTER PANEL <<--- //
        JLabel centerContPanel = new JLabel("Center Container", SwingConstants.CENTER);
        centerContPanel.setBorder(new LineBorder(new Color(169, 140, 7), 3));

        // ADD MIDDLE PANELLS INTO MAIN CONTAINER
        lmidPanel.add(lGridPanel);
        mainContainer.add(lmidPanel, BorderLayout.WEST);
        mainContainer.add(centerContPanel);

        // -->> RIGHT CENTER PANEL
        JPanel rmidPanel = new JPanel();
        rmidPanel.setBorder(new LineBorder(new Color(169, 140, 7), 3));
        rmidPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        rmidPanel.setBackground(new Color(153, 120, 92));
        JLabel rmidtxt = new JLabel("Right Container", SwingConstants.CENTER);
        rmidPanel.add(rmidtxt);
        mainContainer.add(rmidPanel, BorderLayout.EAST);

        // BOTTON PANEL
        JPanel bottonPanel = new JPanel();
        bottonPanel.setBorder(new LineBorder(new Color(169, 140, 7), 3));
        bottonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottonPanel.setBackground(new Color(153, 120, 92));
        JLabel bottontxt = new JLabel("Copyrigt © All rights reserved", SwingConstants.CENTER);
        bottonPanel.add(bottontxt);
        mainContainer.add(bottonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
        this.validate();
        this.repaint();

    }
}
