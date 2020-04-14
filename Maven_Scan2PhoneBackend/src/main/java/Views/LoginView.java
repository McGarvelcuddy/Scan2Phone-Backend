package Views;

import Controllers.LoginController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView extends JFrame {
    private final LoginController controller;
    private JLabel instructions;
    private JLabel uNameLabel;
    private JLabel pWordLabel;
    private JTextField username;
    private JTextField password;
    private JButton loginButton;
    private JPanel gridPanel;
    
    public LoginView(LoginController controller){
        this.controller = controller;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Scan2Phone - Login");
        setSize(600, 600);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        instructions = new JLabel("Please log in to your Scan2Phone account created on our mobile app to add cards.");
        
        uNameLabel = new JLabel("Username");
        uNameLabel.setPreferredSize(new Dimension(70, 21));
        pWordLabel = new JLabel("Password");
        pWordLabel.setPreferredSize(new Dimension(70, 21));
        
        username = new JTextField();
        password = new JTextField();
        
        username.setPreferredSize(new Dimension(70, 21));
        password.setPreferredSize(new Dimension(70, 21));
        
        loginButton = new JButton("Login");
        
        loginButton.addActionListener(event -> controller.accountSelect(username.getText() ,password.getText()));
        
        this.setContentPane(new JPanel(new BorderLayout()));
        
        gridPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints con = new GridBagConstraints();
        
        con.weightx = 0;
        this.getContentPane().add(instructions, BorderLayout.NORTH);
        
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
        con.gridx = 3;
        con.gridy = 4;
        gridPanel.add(loginButton, con);
        
        this.getContentPane().add(gridPanel);
        
    }
}