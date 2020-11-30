/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datapicker;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;

/**
 *
 * @author bacana
 */
public class DataPicker extends JFrame{
     /**
     * @param args the command line arguments
     */
    private static final long serialVersionUID = 1L;
    JFormattedTextField textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            DataPicker window = null;
            try {
                window = new DataPicker();
                window.setVisible(true);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
  
}
     public DataPicker(){
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(368, 362);
        setTitle("JavaDataTimePicker");
        
        Container cp = getContentPane();
        FlowLayout flowLayout = new FlowLayout();
        
        cp.setLayout(flowLayout);
        cp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        textField.setValue(new Date());
        textField.setPreferredSize(new Dimension (130,30));
        //Add UI Controls to the Min Container Content Pane
        cp.add(textField);
        
        JButton calButton = new JButton ("Pick a Date");
        cp.add(calButton);
        
        
        
        
        
    }
}
