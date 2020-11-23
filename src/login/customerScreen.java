package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class customerScreen implements ActionListener{
    
    public JFrame frame;
    private JLabel label;
    private JPanel panel;
    private JButton button;
    private int count = 1;
    
    public static void main(String[] args) {

    new customerScreen();
    
    }
    
   public customerScreen(){
       
    button = new JButton("Click Here");
    label = new JLabel("Number of Clicks: ");
    button.addActionListener(this);
    
    panel = new JPanel();
    panel.setBackground(Color.cyan);
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 20));
    panel.setLayout(new GridLayout (0, 1));
    panel.add(button);
    panel.add(label);
    
    frame = new JFrame();
    frame.setTitle("GUI Application");
    frame.add(panel, BorderLayout.CENTER);
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    
    
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        label.setText("Number of Clicks: " + count);
        count++;
    }
    
}
