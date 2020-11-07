
package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//giving instructions to the program on what to do when a button is clicked on
import javax.swing.JButton;//adding interactive buttons
import javax.swing.JFrame;//the main "box" of the application where the panel goes inside
import javax.swing.JLabel;// naming the buttons on the screen
import javax.swing.JPanel;//basically it is the "layout" of the application
import javax.swing.JPasswordField;//Password text box, it will show ***** so it wont show whatever user types
import javax.swing.JTextField;//the username text field where text is visible to the user


public class Login  implements ActionListener{// implemeting the action listener.
    //here just all of my imports and just getting things started
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private static JLabel exit;
    private static JButton exitbutton;
    
    
    
    public static void main(String[] args) {
        
        JPanel panel = new JPanel();//creating the panel
        JFrame frame = new JFrame();//creating the frame
        frame.setMinimumSize(new Dimension(400, 230));//setting minimum window size
        //frame.setMaximumSize(new Dimension(350, 200));
        frame.setTitle("Grafton Barber");//labelling the name displayed on the top of the window
        frame.setSize(350, 200);//setting the program STARTING size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to stop running (on netbeans the "running stts" the program once it has been closed.
        frame.add(panel);//adding the panel to the frame
        //panel.setBackground(Color.cyan);
        panel.setLayout(null);
        
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);// dimensions are based in: x, y, width, height
        panel.add(userLabel);
        
        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        
        exitbutton = new JButton("Exit");
        exitbutton.setBounds(295, 140, 70, 25);
        exitbutton.addActionListener(new exitbuttonListener());
        panel.add(exitbutton);
        
        button = new JButton("Sign In");
        button.setBounds(100, 80, 80, 25);
        button.addActionListener(new Login());
        panel.add(button);
        
        button = new JButton("Register");
        button.setBounds(183, 80, 82, 25);
        //button.addActionListener(new Login());
        panel.add(button);
        
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        
        frame.setVisible(true);
}
    public void gitTest(){
        System.out.println("    dska");
        tgsdgdtgzjkbnkjnk
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println("Username: " + user + " , Password: " + password);
        
        if (user.equals("Gabriel") && password.equals("gabriel1234")) {
            
           success.setText("Logged in successfully!!!");
           
        } else {
            success.setText("Wrong Credentials!!!");
        }
        
    }

    private static class exitbuttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.exit(0);
        }
    }
}
