
package UI.Client.student;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import registrazionevoti.dataContainer.users.Studente;
import registrazionevoti.dataContainer.users.UserData;

public class MainFrame extends JFrame {
    
    private static final String HOME = "Home";
    private static final String LIBRETTO = "Libretto";
    private static final String ESAMI = "Esami";
    private static final String ESITI = "Esiti";
   
    private JPanel masterPanel;
    private JPanel detailPanel;
    private Studente studentData;
    
    public MainFrame(UserData sessionData) {
        super();
        studentData = (Studente)sessionData;
        initComponents();
    }
    
    private void initComponents() {
        
        //Dimensions
        Dimension frameDimension = new Dimension(800,500);
        Dimension masterPaneDimension = new Dimension(200,500);
        //Borders
        Border standardBorder = BorderFactory.createLineBorder(Color.BLACK);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Area Riservata Studente");
        setSize(frameDimension);
        setResizable(false);
       
        JPanel contentPane = (JPanel) getContentPane();
        
        masterPanel = new JPanel(new BorderLayout());
        
        JPanel idPanel = new JPanel(new BorderLayout());
        ImageIcon accountIcon = new ImageIcon("resources/images/ic_account_circle_black.png","Default account icon");
        JLabel accountIdLabel = new JLabel(accountIcon);
        accountIdLabel.setText("Jon Snow");
        accountIdLabel.setHorizontalTextPosition(JLabel.CENTER);
        accountIdLabel.setVerticalTextPosition(JLabel.BOTTOM);
        accountIdLabel.setBorder(standardBorder);
        idPanel.add(accountIdLabel,BorderLayout.CENTER);
        
        JPanel navigationPanel = new JPanel(new BorderLayout());
        navigationPanel.setBorder(standardBorder);
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement(HOME);
        listModel.addElement(LIBRETTO);
        listModel.addElement(ESAMI);
        listModel.addElement(ESITI);
        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setCellRenderer(new navigationCell());
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList list = (JList)e.getSource();
                CardLayout cl = (CardLayout)(detailPanel.getLayout());
                switch(list.getSelectedIndex()) {
                    case 0:
                        cl.show(detailPanel,HOME);
                        break;
                    case 1:
                        cl.show(detailPanel,LIBRETTO);
                        break;
                    case 2:
                        cl.show(detailPanel, ESAMI);
                        break;
                    case 3:
                        cl.show(detailPanel, ESITI);
                        break;
                    default:
                        cl.show(detailPanel,HOME);
                }
            }
        });
        navigationPanel.add(list,BorderLayout.CENTER);

        masterPanel.add(idPanel,BorderLayout.NORTH);
        masterPanel.add(navigationPanel,BorderLayout.CENTER);
        
        
        
        detailPanel = new JPanel(new CardLayout());
        
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel(HOME));
        JPanel librettoPanel = new JPanel();
        librettoPanel.add(new JLabel(LIBRETTO));
        JPanel esamiPanel = new JPanel();
        esamiPanel.add(new JLabel(ESAMI));
        JPanel esitiPanel = new JPanel();
        esitiPanel.add(new JLabel(ESITI));
        
        detailPanel.add(homePanel,HOME);
        detailPanel.add(librettoPanel,LIBRETTO);
        detailPanel.add(esamiPanel,ESAMI);
        detailPanel.add(esitiPanel,ESITI);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,masterPanel,detailPanel);
        splitPane.setDividerLocation(masterPaneDimension.width);
        masterPanel.setMinimumSize(masterPaneDimension);
        
        contentPane.add(splitPane);
        
        setContentPane(contentPane);
    }
    
    public class navigationCell extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            
        setComponentOrientation(list.getComponentOrientation());

        Color bg = null;
        Color fg = null;

        if (isSelected) {
            setBackground(bg == null ? list.getSelectionBackground() : bg);
            setForeground(fg == null ? list.getSelectionForeground() : fg);
        }
        else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setText(value.toString());
          
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setPreferredSize(new Dimension(200,75));
        setHorizontalTextPosition(JLabel.CENTER);
        
        return this;
        }
        
    }

}
