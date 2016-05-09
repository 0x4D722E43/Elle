
package UI.Client;

import UI.Client.student.MainFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import registrazionevoti.dataContainer.users.User;
import registrazionevoti.dataContainer.users.UserData;
import userCtrl.session.UserSession;

public class LoginFrame extends JFrame{
    
    private UserSession sessionController = new UserSession(); 
    private JTextField user;
    private JTextField pass;
    
    public LoginFrame() {
        super();
        initComponents();
    }
    
    private void initComponents() {
        Dimension frameDimension = new Dimension(300,150);
        Border standardBorder = BorderFactory.createLineBorder(Color.BLACK);
        
        setTitle("LOGIN - Area Riservata");
        setSize(frameDimension);
        setResizable(false);
       
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
        
        JPanel userPanel = new JPanel(new FlowLayout());
        JLabel codFiscale = new JLabel("Codice Fiscale :");
        user = new JTextField();  
        user.setColumns(15);
        userPanel.add(codFiscale);
        userPanel.add(user);
        
        JPanel passPanel = new JPanel(new FlowLayout());
        JLabel password = new JLabel("Password :");
        pass = new JTextField();
        pass.setColumns(15);
        passPanel.add(password);
        passPanel.add(pass);
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doLogin(user.getText(),pass.getText());
            }
        });
        
        contentPane.add(userPanel);
        contentPane.add(passPanel);
        contentPane.add(loginButton);
        
        setContentPane(contentPane);
    }
    
    private void doLogin(String user,String password) {
        try {
            sessionController.login(user, password);
        } catch (Exception e) {
            //gestire se è sbagliata password o nome utente
        }
        User userType = sessionController.getUserType();
        UserData userData = sessionController.getUser();
        switch(userType) {
            case STUDENT:
                MainFrame mf = new MainFrame(userData);
                mf.setVisible(true);
                this.dispose();
                break;
        }
        
    }
}
