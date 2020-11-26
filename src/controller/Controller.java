
package controller;

import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import login.User;
import view.View;
import login.registerScreen;


public class Controller implements ActionListener {
    
    View view;
    Model model;
    
    public Controller(){
        this.view = new View(this);
        this.model = new Model();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == view.loginButton){
        String un = view.getUsername();
        String pw = view.getPassword();
        System.out.println("Username: " + un + " , Password: " + pw);
        
        User user = new User(un, pw);
        boolean result = model.login(user);
               
        if((result)){
            JOptionPane.showMessageDialog(view.success, "Logged in successfuly!!!");
        }
        else{
            JOptionPane.showMessageDialog(view.success, "Wrong Credentials");
        }
        }
        if (e.getSource() == view.registerButton) {
            
            registerScreen open = new registerScreen();
            open.setVisible(true);
        }
    }    
    
   public static class exitbuttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.exit(0);
        }
   }
}
  
    
    
    
    

  
    

