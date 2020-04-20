package Views;

import Controllers.LoginController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import org.json.JSONException;

public class LoginView extends JFrame {
    private final LoginController controller;
    private JLabel instructions;
    private JLabel uNameLabel;
    private JLabel pWordLabel;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JLabel badLogin;
    
    
    public LoginView(LoginController controller){
        this.controller = controller;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Scan2Phone - Login");
        setSize(500, 250);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        instructions = new JLabel("Please log in to your Scan2Phone account created on our mobile app to add cards.");
        
        uNameLabel = new JLabel("Username");
        uNameLabel.setPreferredSize(new Dimension(70, 21));
        pWordLabel = new JLabel("Password");
        pWordLabel.setPreferredSize(new Dimension(70, 21));
        
        username = new JTextField();
        password = new JPasswordField();
        
        loginButton = new JButton("Login");
        
        loginButton.addActionListener(event -> {
            try {
                controller.accountSelect(username.getText() ,password.getText());
            } catch (JSONException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        this.setContentPane(new JPanel(new BorderLayout()));
        
        JPanel gridPanel = new JPanel(new GridBagLayout());
        gridPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(
                    EtchedBorder.RAISED, Color.GRAY
                    , Color.DARK_GRAY), "Login"));
        
        GridBagConstraints con = new GridBagConstraints();
        
        Insets WEST_INSETS = new Insets(5,0,5,5);
        Insets EAST_INSETS = new Insets(5, 5, 5, 0);
        
        int x = 2;
        int y = 2;
        con.gridx = x;
        con.gridy = y;
        con.gridwidth = 1;
        con.gridheight = 1;

        con.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        con.fill = (x == 0) ? GridBagConstraints.BOTH
            : GridBagConstraints.HORIZONTAL;

        con.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
        con.weightx = (x == 0) ? 0.1 : 1.0;
        con.weighty = 1.0;
     
        con.weightx = 0;
        this.getContentPane().add(instructions, BorderLayout.NORTH);
        badLogin = new JLabel();
        this.getContentPane().add(badLogin, BorderLayout.SOUTH);
        
        
        con.gridx = 0;
        con.gridy = 1;
        gridPanel.add(uNameLabel, con);
        
        con.gridx = 1;
        con.gridy = 1;
        gridPanel.add(username, con);
        
        con.gridx = 0;
        con.gridy = 2;
        gridPanel.add(new JLabel(" "), con);
        
        con.gridx = 0;
        con.gridy = 3;
        gridPanel.add(pWordLabel, con);
        
        con.gridx = 1;
        con.gridy = 3;
        gridPanel.add(password, con);
        
        con.weightx = 1;
        con.gridx = 1;
        con.gridy = 4;
        gridPanel.add(loginButton, con);
        
        this.getContentPane().add(gridPanel);
        
    }
    
    
    public void failedLogin(){
        if(badLogin.getText().equals("")){
            badLogin.setText("Account not found.  Please check your username and password and try again.");
        }else{
            badLogin.setText("");
        }
        repaint();
    }
}