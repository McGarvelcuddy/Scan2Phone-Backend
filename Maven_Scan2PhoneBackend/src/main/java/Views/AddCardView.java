package Views;

import Controllers.AddCardController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class AddCardView extends JFrame{
    private AddCardController controller;
    private JLabel instructions;
    private JLabel scanLabel;
    private JLabel typeLabel;
    private JLabel numberLabel;
    private JTextField scanField;
    private JTextField typeField;
    private JTextField numberField;
    private JButton cancel;
    private JButton submit;
    
    
    
    public AddCardView(AddCardController controller){
        this.controller = controller;
        
        initComponents();
    }
    private void initComponents(){
        setTitle("Scan2Phone - Add A Card To Your Account");
        
        setSize(700, 300);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        instructions = new JLabel("Please input as much information as possible for card.");
        
        scanLabel = new JLabel("Scan card using mag. strip scanner:");
        typeLabel = new JLabel("What kind of card? (credit, debit, gift, etc.):");
        numberLabel = new JLabel("(Optional if card scanned) Any applicable primary card number");
        
        scanField = new JTextField();
        typeField = new JTextField();
        numberField = new JTextField();
        
        scanField.setPreferredSize(new Dimension(200, 21));
        typeField.setPreferredSize(new Dimension(200, 21));
        numberField.setPreferredSize(new Dimension(200, 21));
        
        cancel = new JButton("Cancel");
        submit = new JButton("Submit Card");
        
        submit.addActionListener(event -> controller.addCardJSON(scanField.getText(), typeField.getText(), numberField.getText()));
        
        
        
        //whole panel content pane
        this.setContentPane(new JPanel(new BorderLayout()));
        
        this.getContentPane().add(instructions, BorderLayout.NORTH);
        
        //gridbag layout set inside a border
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
        
        con.weightx = 1;
        con.gridx = 0;
        con.gridy = 1;
        gridPanel.add(scanLabel, con);
        
        con.gridx = 1;
        gridPanel.add(scanField, con);
        
        con.gridx = 0;
        con.gridy = 2;
        gridPanel.add(new JLabel(" "), con);
        
        con.gridy = 3;
        gridPanel.add(typeLabel, con);
        
        con.gridx = 1;
        gridPanel.add(typeField, con);
        
        con.gridx = 0;
        con.gridy = 4;
        gridPanel.add(new JLabel(" "), con);
        
        con.gridy = 5;
        gridPanel.add(numberLabel, con);
        
        con.gridx = 1;
        gridPanel.add(numberField, con);
        
        con.gridx = 0;
        con.gridy = 6;
        gridPanel.add(cancel, con);
        
        con.gridx = 1;
        gridPanel.add(submit, con);
        
        this.getContentPane().add(gridPanel);
    }
}