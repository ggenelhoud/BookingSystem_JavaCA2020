/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import datapicker.MainWindow;

/**
 *
 * @author bacana
 */
public class MainFrame extends JFrame {
    
   private final MainWindow mw;
            
    public MainFrame(String title){
        
    this.setTitle(title);
    this.setSize(700,550);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    
    JButton Bookings = new JButton("Bookings");
    JButton Feedback = new JButton("Feedback");
    JButton Delete = new JButton("Delete");
    JButton Submit = new JButton("Submit");
    JButton Close = new JButton("Close");
    
    
    Container mainContainer = this.getContentPane();
    mainContainer.setLayout(new BorderLayout (8,6));
    mainContainer.setBackground(new Color(212, 198, 94));
    //this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, new Color(153, 120, 92)));
    
    
    //LOGO BARBER
    ImageIcon barberLogo = new ImageIcon ("logo-barbershop.png");
    JLabel labelBarber = new JLabel (barberLogo);
    labelBarber.setBounds(20, 10, 65, 75);
    
    //Top Panel
    JPanel topPanel = new JPanel();
    topPanel.setBorder(new LineBorder(new Color(169, 140, 7),3));
    topPanel.setBackground(new Color(153, 120, 92)); //new Color(153, 120, 92)
    topPanel.setLayout(null);//new FlowLayout(FlowLayout.RIGHT, 250,1)
    topPanel.setPreferredSize(new Dimension(650,100));
    mainContainer.add(topPanel, BorderLayout.NORTH);
    //  SET BUTTON DIM & POS
    //Close.setPreferredSize(new Dimension(50,30));
    Close.setBounds(600,50,70,30);
    topPanel.add(labelBarber);
    topPanel.add(Close);
    
        
    // ->> LEFT CENTER PANEL 
    // LEFT FLOW LAYOUT
    JPanel lmidPanel = new JPanel();
    lmidPanel.setBorder(new LineBorder(new Color(169, 140, 7), 3));
    lmidPanel.setLayout(new FlowLayout(4,4,4));
    lmidPanel.setBackground(new Color(153, 120, 92));
    
    
    // LEFT GRID LAYOUT // MENU BUTTONS
    JPanel lGridPanel = new JPanel();
    lGridPanel.setLayout(new GridLayout(2,1,5,5));
    lGridPanel.setPreferredSize (new Dimension (100,100)); // set the sise of each panel container
    lGridPanel.setBackground(new Color(153, 120, 92));
    lGridPanel.add(Bookings);
    lGridPanel.add(Feedback);
          
    // ADD MIDDLE LEFT PANELLS INTO MAIN CONTAINER
    lmidPanel.add(lGridPanel);
    mainContainer.add(lmidPanel, BorderLayout.WEST);
    
    
    
    // -->> MIDDLE CENTER PANEL <<--- //
    
    JPanel centerContPanel = new JPanel ();
    centerContPanel.setBorder(new LineBorder(new Color (169, 140, 7),3));
    centerContPanel.setLayout(new FlowLayout());//new BorderLayout()
    centerContPanel.setBackground(new Color(153, 120, 92));
    mainContainer.add(centerContPanel);
    
    //---- SUB PANELS  ------
    mw = new MainWindow();
    centerContPanel.add(mw);
    //centerContPanel.add(tp2, BorderLayout.EAST);

    // -->> RIGHT CENTER PANEL
    JPanel rmidPanel = new JPanel ();
    rmidPanel.setBorder(new LineBorder(new Color(169, 140, 7), 3));
    rmidPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    rmidPanel.setBackground(new Color(153, 120, 92));
    JLabel rmidtxt = new JLabel ("Right Container",SwingConstants.CENTER);
    rmidPanel.add(rmidtxt);
    mainContainer.add(rmidPanel, BorderLayout.EAST);
    
    
    // BOTTON PANEL
    JPanel bottonPanel = new JPanel ();
    bottonPanel.setBorder(new LineBorder(new Color(169, 140, 7), 3));
    bottonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    bottonPanel.setBackground(new Color(153, 120, 92));
    JLabel bottontxt = new JLabel ("Copyrigt © All rights reserved",SwingConstants.CENTER);
    bottonPanel.add(bottontxt);
    mainContainer.add(bottonPanel, BorderLayout.SOUTH);
    
    }
    public static void main(String[] args) {
        MainFrame barberApp = new MainFrame("Grafton Barber");
        barberApp.setVisible(true);
    }
    
}


//Action listener "mw" from MainWondow/Datapicker

