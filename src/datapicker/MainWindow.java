/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datapicker;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
/**
 *
 * @author bacana
 */
//public class MainWindow extends JFrame implements
 public class MainWindow extends JPanel implements PropertyChangeListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//the TextField for typing the date
	JFormattedTextField  textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));

        public MainWindow()
		{
//						
			JPanel cp = new JPanel();
                        cp.setPreferredSize (new Dimension (290,240));
                        cp.setBackground(new Color(153, 120, 92));
                        //cp.setBorder(new LineBorder(new Color(169, 140, 7), 3));
			

                        // Validation date
                        JLabel msne = new JLabel("");
                        
                        
			cp.setLayout(new FlowLayout());
                    
			 			
			  
			textField.setValue(new Date());
			textField.setPreferredSize(new Dimension(130, 30));
			    
			// display the window with the calendar
			CalendarWindow calendarWindow = new CalendarWindow(); 
			    
			//wire a listener for the PropertyChange event of the calendar window
			calendarWindow.addPropertyChangeListener(this);
			
			
			JButton calendarButton = new JButton("Pick a Date");
					
			calendarButton.addActionListener((ActionEvent e) -> {
                            //render the calendar window below the text field
                            calendarWindow.setLocation(textField.getLocationOnScreen().x, (textField.getLocationOnScreen().y + textField.getHeight()));
                            //get the Date and assign it to the calendar
                            Date d = (Date)textField.getValue();
                            
                            calendarWindow.resetSelection(d);
                            calendarWindow.setUndecorated(true);
                            calendarWindow.setVisible(true);
                            
                        });

			//add the UI controls to the ContentPane
			cp.add(textField);
			cp.add(calendarButton);
			cp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                        add(cp);
	       
		}
		
        @Override
		public void propertyChange(PropertyChangeEvent event) {
			
        	//get the selected date from the calendar control and set it to the text field
	            if (event.getPropertyName().equals("selectedDate")) {
	            
				java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
				Date selDate =  cal.getTime();
				textField.setValue(selDate);
	        }
			
                }
}
