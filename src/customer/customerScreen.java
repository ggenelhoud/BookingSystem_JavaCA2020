/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import controller.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Model;
import view.View;

/**
 *
 * @author genel
 */
public class customerScreen extends JFrame {

    View view;

    public customerScreen(View view) {

         this.view = new View();
    }

    public customerScreen() {
        components();
    }

    public void components() {

        this.setVisible(true);
        this.setSize(900, 800);
        this.setTitle("Layout Managers");

        JButton region = new JButton("Region");
        JButton product = new JButton("Log Out");

        JButton rep = new JButton("Sales Rep");

        JLabel welcome = new JLabel("Welcome, ");
        welcome.setFont(new Font("Arial", Font.PLAIN, 18));
        welcome.setForeground(Color.WHITE);
        JLabel two = new JLabel("two");
        JLabel three = new JLabel("three");
        JLabel four = new JLabel("four");
        JLabel five = new JLabel("five");

        JPanel p1 = new JPanel();
        p1.setBackground(Color.black);
        p1.setPreferredSize(new Dimension(30, 30));
        GridLayout grid = new GridLayout(1, 2);
        BorderLayout border = new BorderLayout();
        p1.setLayout(border);

        JPanel left = new JPanel();
        left.setLayout(border);
        p1.add(left);

        JPanel p3 = new JPanel();
        p3.setBackground(Color.white);

        JPanel p4 = new JPanel();
        p4.setBackground(Color.cyan);
        Border border1 = BorderFactory.createLineBorder(Color.black, 1);
        p4.setBorder(border1);
        p4.setPreferredSize(new Dimension(220, 50));

        BorderLayout manager = new BorderLayout();

        this.setLayout(manager);

        p1.add(welcome);
        p1.add(region);
        p1.add(product);
        p1.setBorder(border1);

        p3.add(three);
        p4.add(four);

        p1.add(welcome, BorderLayout.CENTER);
        p1.add(product, BorderLayout.LINE_END);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p1, BorderLayout.PAGE_START);
        this.add(p3, BorderLayout.CENTER);
        this.add(p4, BorderLayout.LINE_START);

    }

    public void repaint() {

        this.validate();
        this.repaint();

    }
}
