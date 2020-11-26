package login;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class View extends JFrame{
    
    private  JLabel userLabel;
    private  JTextField userName;
    private  JLabel passwordLabel;
    private  JPasswordField userPassword;
    public JButton loginButton, registerButton;
    public JLabel success;
    public static JLabel exit;
    public JButton exitbutton; 
    Controller controller;
    JRadioButton adminButton;
    public JTextField adminNO;
   

   public View(Controller controller) {

        this.controller = controller;
        components();
        frameValidation();
   }
    
public void components(){
    
        JPanel panel = new JPanel();//creating the panel
        JFrame frame = new JFrame();//creating the frame
        frame.setMinimumSize(new Dimension(388, 212));//setting minimum window size
        //frame.setMaximumSize(new Dimension(350, 200));
        frame.setTitle("Grafton Barber");//labelling the name displayed on the top of the window
        frame.setSize(350, 200);//setting the program STARTING size
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//to stop running (on netbeans the "running stts" the program once it has been closed.
        frame.add(panel);//adding the panel to the frame
        //panel.setBackground(Color.cyan);
        panel.setLayout(null);
        frame.setResizable(false);
    
    
        userLabel = new JLabel("E-mail:");
        userLabel.setBounds(10, 20, 80, 25);// dimensions are based in: x, y, width, height
        panel.add(userLabel);
        
        userName = new JTextField();
        userName.setBounds(100, 20, 165, 25);
        panel.add(userName);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        userPassword = new JPasswordField();
        userPassword.setBounds(100, 50, 165, 25);
        panel.add(userPassword);
        
        exitbutton = new JButton("Exit");
        exitbutton.setBounds(295, 140, 70, 25);
        exitbutton.addActionListener(controller);
        panel.add(exitbutton);
        
        loginButton = new JButton("Sign In");
        loginButton.setBounds(100, 80, 80, 25);
        loginButton.addActionListener((controller));
        panel.add(loginButton);
        
        registerButton = new JButton("Register");
        registerButton.setBounds(183, 80, 82, 25);
        registerButton.addActionListener(controller);
        panel.add(registerButton);
        
        adminButton = new JRadioButton("admin");
        adminButton.setBounds(10, 140, 70, 25);
        adminButton.addActionListener(controller);
        panel.add(adminButton);
        
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        
        frame.setVisible(true);
        
}
    private void frameValidation(){
        this.validate();
        this.repaint();
    }

    public String getUsername() {
        return userName.getText();
    }
    
    public String getPassword(){
        return userPassword.getText();
    }
    public void getSuccess(String result){
         JOptionPane.showMessageDialog(this, "");
    }
}

