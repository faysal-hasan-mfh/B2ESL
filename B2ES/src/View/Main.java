/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.AddIntoDB;
import Model.GetInfo;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mfh
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
     Connection conn;
     PreparedStatement pst;
     ResultSet rs;
    
     String dbadd="C:/Program Files/B2ESL/B2ESL.db";
     String dbTable="besl";
     
     GetInfo getInfoClass=new GetInfo();
     Sorting sort=new Sorting();
     Search search=new Search();
    public Main() {
        initComponents();
        
     //   jList1.hide();
        //jTextArea2.hide();
        //listTabPan.hide();
        
        fillComboBox();
        setTotal();
        setBanglaList();
        setEnglishList();
        //getDate();
    }

    void setBanglaList()
    {
    String getWebAdd[]= sort.getBangString();///getInfoClass.getBanglaFromDB();
   // System.out.println(getWebAdd.length);
                //int lengthofid=getInfoClass.totalID(getWebAdd);
                if(getWebAdd.length!=0){
                    DefaultListModel dlm=new DefaultListModel();
                
                     for(String wan: getWebAdd)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                }
                        }
                
                         banglaList.setModel(dlm);
                }
                else
                {
                //JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                System.out.println("No Item!");
                }
    
    
    
    }
    void setEnglishList()
    {
    String getWebAdd[]= sort.getEngString(); //getInfoClass.getEnglishFromDB();
               // int lengthofid=getInfoClass.totalID(getWebAdd);
                if(getWebAdd.length!=0){
                    DefaultListModel dlm=new DefaultListModel();
                
                     for(String wan: getWebAdd)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                }
                        }
                
                         englishList.setModel(dlm);
                }
                else
                {
                //JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                System.out.println("No Item!");
                }
    
    
    
    }
    void setSearchList(String sKey)
    {
        
        search.setKeySearch(sKey);
    String getWebAdd[]= search.getKeySearch(); //getInfoClass.getEnglishFromDB();
               // int lengthofid=getInfoClass.totalID(getWebAdd);
    DefaultListModel dlm=new DefaultListModel();
                if(getWebAdd.length!=0){
                    
                
                     for(String wan: getWebAdd)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                }
                            
                        }
                 
                         searchList.setModel(dlm);
                }
                else
                { //dlm.addElement("No Item !");
                //JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                System.out.println("No Item!");
                
                searchList.setModel(dlm);
                }
   
    
    
    }
    void setBangSearchList(String sKey)
    {
        
        search.setBKeySearch(sKey);
    String getWebAdd[]= search.getBKeySearch(); //getInfoClass.getEnglishFromDB();
               // int lengthofid=getInfoClass.totalID(getWebAdd);
    DefaultListModel dlm=new DefaultListModel();
                if(getWebAdd.length!=0){
                    
                
                     for(String wan: getWebAdd)
                        {
                            if(wan!=null) {
                                    dlm.addElement(wan);
                                }
                            
                        }
                 
                         searchList.setModel(dlm);
                }
                else
                { //dlm.addElement("No Item !");
                //JOptionPane.showMessageDialog(rootPane,"Sorry.. there is no item..!", "Error !", JOptionPane.ERROR_MESSAGE);
                System.out.println("No Item!");
                
                searchList.setModel(dlm);
                }
   
    
    
    }
    void fillComboBox()
    {
    
        try
        {
            
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection("jdbc:sqlite:"+dbadd);
            String sql="select * from "+dbTable;
          //  rs = stmt.executeQuery( "SELECT * FROM "+dbTable+";" );
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            
            while(rs.next())
            {
            int id=rs.getInt("id");
            serialComboBox.addItem(id);
            editComboBox.addItem(id);
            removeComboBox.addItem(id);
            
            }
            
              pst.close();
              conn.close();
       
              
              System.out.println("Successfully Closed.. addition... fill combo");
        }
        catch(Exception e)
        {
        
            JOptionPane.showMessageDialog(null, e);
        
        }
    }
    
    void addLastID()
    {
    int lastID=getInfoClass.LastID();
    serialComboBox.addItem(lastID);
    editComboBox.addItem(lastID);
    removeComboBox.addItem(lastID);
    }
    String getDate()
    {
    Calendar cal= Calendar.getInstance();
    String date=" "+cal.get(Calendar.DATE)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.YEAR);
    
    System.out.println(date);
    
    return date;
    }
    void setTotal()
    {
     String totals=Integer.toString(getInfoClass.LastID());
     totalsLabel.setText(totals);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        serialComboBox = new javax.swing.JComboBox();
        bangKeyComboBox = new javax.swing.JComboBox();
        engKeyComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        totalsLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        listTabPan = new javax.swing.JTabbedPane();
        listPanel = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList();
        jScrollPane14 = new javax.swing.JScrollPane();
        sETArea = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        sBTArea = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        englishTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        banglaTextArea = new javax.swing.JTextArea();
        CANCEL = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        banglaTA = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        banglaList = new javax.swing.JList();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        englishList = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        englishTA = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        englishAddTA = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        banglaAddTA = new javax.swing.JTextArea();
        dbAddDoneButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        editComboBox = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        editEngTA = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        editBanglaTA = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        removeComboBox = new javax.swing.JComboBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        removeEngTA = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        removeBanglaTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("B2ESL");
        setBackground(new java.awt.Color(0, 51, 51));
        setIconImage(new ImageIcon(getClass().getResource("/View/b4.jpg")).getImage());

        jPanel12.setBackground(new java.awt.Color(0, 51, 51));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTabbedPane1.setBackground(new java.awt.Color(0, 51, 51));
        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(0, 51, 51));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setToolTipText("Easy Learing ");
        jTabbedPane1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true)));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searchTextField.setBackground(new java.awt.Color(0, 102, 102));
        searchTextField.setColumns(10);
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter / Select To Search");

        serialComboBox.setBackground(new java.awt.Color(0, 51, 51));
        serialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));
        serialComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialComboBoxActionPerformed(evt);
            }
        });

        bangKeyComboBox.setBackground(new java.awt.Color(0, 51, 51));
        bangKeyComboBox.setFont(new java.awt.Font("Vrinda", 0, 11)); // NOI18N
        bangKeyComboBox.setForeground(new java.awt.Color(0, 51, 51));
        bangKeyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "~", "অ", "আ", "ই", "ঈ", "উ", "ঊ", "ঋ", "এ", "ঐ", "ও", "ঔ ", "ক", "খ", "গ", "ঘ", "চ", "ছ", "জ", "ঝ", "ত", "থ", "দ", "ধ", "ন", "প", "ফ", "ব", "ভ", "ম", "স", "শ", "ষ", "হ", "র", "ল", "য়", "য", "ক্ষ", "হ্ম", "জ্ঞ" }));
        bangKeyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bangKeyComboBoxActionPerformed(evt);
            }
        });

        engKeyComboBox.setBackground(new java.awt.Color(0, 51, 51));
        engKeyComboBox.setForeground(new java.awt.Color(0, 51, 51));
        engKeyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "~", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
        engKeyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engKeyComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Total Sentences : ");

        totalsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        totalsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(179, 179, 179)
                        .addComponent(totalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(bangKeyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(engKeyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(searchTextField)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(serialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(bangKeyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(engKeyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(serialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/b2sl04.jpg"))); // NOI18N
        jLabel3.setIconTextGap(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        listTabPan.setBackground(new java.awt.Color(0, 51, 51));
        listTabPan.setForeground(new java.awt.Color(0, 51, 51));
        listTabPan.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        listPanel.setBackground(new java.awt.Color(0, 51, 51));
        listPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 14), new java.awt.Color(0, 102, 102))); // NOI18N
        listPanel.setForeground(new java.awt.Color(0, 51, 51));

        searchList.setBackground(new java.awt.Color(0, 102, 102));
        searchList.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        searchList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchList.setForeground(new java.awt.Color(255, 204, 255));
        searchList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "~ Enter To Search ~" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        searchList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                searchListValueChanged(evt);
            }
        });
        searchList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchListPropertyChange(evt);
            }
        });
        jScrollPane13.setViewportView(searchList);

        sETArea.setEditable(false);
        sETArea.setBackground(new java.awt.Color(0, 102, 102));
        sETArea.setColumns(20);
        sETArea.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        sETArea.setForeground(new java.awt.Color(204, 204, 0));
        sETArea.setRows(5);
        sETArea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "English", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 51, 51)));
        jScrollPane14.setViewportView(sETArea);

        sBTArea.setEditable(false);
        sBTArea.setBackground(new java.awt.Color(0, 102, 102));
        sBTArea.setColumns(20);
        sBTArea.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        sBTArea.setForeground(new java.awt.Color(204, 255, 0));
        sBTArea.setRows(5);
        sBTArea.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bangla", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 51, 51)));
        jScrollPane15.setViewportView(sBTArea);

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setForeground(new java.awt.Color(0, 0, 102));
        jButton5.setText("RESET");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13)
            .addComponent(jScrollPane14)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5))
        );

        listTabPan.addTab("Lists", listPanel);

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));

        englishTextArea.setEditable(false);
        englishTextArea.setBackground(new java.awt.Color(0, 102, 102));
        englishTextArea.setColumns(20);
        englishTextArea.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        englishTextArea.setForeground(new java.awt.Color(255, 204, 153));
        englishTextArea.setRows(5);
        englishTextArea.setToolTipText("English");
        englishTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder("English"));
        jScrollPane1.setViewportView(englishTextArea);

        banglaTextArea.setEditable(false);
        banglaTextArea.setBackground(new java.awt.Color(0, 102, 102));
        banglaTextArea.setColumns(20);
        banglaTextArea.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        banglaTextArea.setForeground(new java.awt.Color(153, 255, 0));
        banglaTextArea.setRows(5);
        banglaTextArea.setToolTipText("Bangla");
        banglaTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Bangla"));
        jScrollPane2.setViewportView(banglaTextArea);

        CANCEL.setBackground(new java.awt.Color(0, 102, 102));
        CANCEL.setText("RESET");
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });

        previousButton.setBackground(new java.awt.Color(0, 51, 51));
        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setBackground(new java.awt.Color(0, 51, 51));
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(CANCEL)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CANCEL)
                        .addComponent(previousButton)
                        .addComponent(nextButton)))
                .addContainerGap())
        );

        listTabPan.addTab("Sentences", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listTabPan)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(listTabPan)
        );

        jTabbedPane1.addTab("Learn", jPanel1);

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));

        jPanel10.setBackground(new java.awt.Color(0, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bangla", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 102, 102)));

        banglaTA.setEditable(false);
        banglaTA.setBackground(new java.awt.Color(0, 102, 102));
        banglaTA.setColumns(20);
        banglaTA.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        banglaTA.setForeground(new java.awt.Color(255, 204, 153));
        banglaTA.setRows(5);
        banglaTA.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane9.setViewportView(banglaTA);

        jButton3.setBackground(new java.awt.Color(0, 51, 51));
        jButton3.setText("Clear");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        banglaList.setBackground(new java.awt.Color(0, 102, 102));
        banglaList.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        banglaList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "কিছু পাওয়া যায় নি !" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        banglaList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        banglaList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                banglaListValueChanged(evt);
            }
        });
        jScrollPane12.setViewportView(banglaList);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
            .addComponent(jScrollPane12)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9)))
        );

        jPanel11.setBackground(new java.awt.Color(0, 51, 51));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Englsh", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 102, 102)));

        jButton4.setBackground(new java.awt.Color(0, 51, 51));
        jButton4.setText("Clear");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        englishList.setBackground(new java.awt.Color(0, 102, 102));
        englishList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        englishList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "No Item !" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        englishList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        englishList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                englishListValueChanged(evt);
            }
        });
        jScrollPane10.setViewportView(englishList);

        englishTA.setEditable(false);
        englishTA.setBackground(new java.awt.Color(0, 102, 102));
        englishTA.setColumns(20);
        englishTA.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        englishTA.setForeground(new java.awt.Color(204, 255, 153));
        englishTA.setRows(5);
        englishTA.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane8.setViewportView(englishTA);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("GetAll", jPanel9);

        jPanel13.setBackground(new java.awt.Color(0, 51, 51));

        jTabbedPane2.setBackground(new java.awt.Color(0, 51, 51));
        jTabbedPane2.setForeground(new java.awt.Color(0, 51, 51));
        jTabbedPane2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 51, 51));

        englishAddTA.setBackground(new java.awt.Color(0, 102, 102));
        englishAddTA.setColumns(20);
        englishAddTA.setForeground(new java.awt.Color(204, 204, 0));
        englishAddTA.setRows(5);
        englishAddTA.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane3.setViewportView(englishAddTA);

        banglaAddTA.setBackground(new java.awt.Color(0, 102, 102));
        banglaAddTA.setColumns(20);
        banglaAddTA.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        banglaAddTA.setForeground(new java.awt.Color(255, 204, 153));
        banglaAddTA.setRows(5);
        banglaAddTA.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane4.setViewportView(banglaAddTA);

        dbAddDoneButton.setBackground(new java.awt.Color(0, 51, 51));
        dbAddDoneButton.setText("Done");
        dbAddDoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbAddDoneButtonActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 51, 51));
        jButton6.setText("Deny");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(dbAddDoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbAddDoneButton)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDIT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        editComboBox.setBackground(new java.awt.Color(0, 51, 51));
        editComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));
        editComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editComboBoxActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(0, 102, 102));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setToolTipText("Enter To Search");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        editEngTA.setBackground(new java.awt.Color(0, 102, 102));
        editEngTA.setColumns(20);
        editEngTA.setRows(5);
        editEngTA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane5.setViewportView(editEngTA);

        editBanglaTA.setBackground(new java.awt.Color(0, 102, 102));
        editBanglaTA.setColumns(20);
        editBanglaTA.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        editBanglaTA.setRows(5);
        editBanglaTA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255), null, null));
        jScrollPane6.setViewportView(editBanglaTA);

        jButton7.setBackground(new java.awt.Color(0, 51, 51));
        jButton7.setText("Deny");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 51, 51));
        jButton8.setText("Done");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addComponent(editComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REMOVE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        jTextField3.setBackground(new java.awt.Color(0, 102, 102));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setToolTipText("Enter To Search");

        removeComboBox.setBackground(new java.awt.Color(0, 51, 51));
        removeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));
        removeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeComboBoxActionPerformed(evt);
            }
        });

        removeEngTA.setBackground(new java.awt.Color(0, 102, 102));
        removeEngTA.setColumns(20);
        removeEngTA.setRows(5);
        removeEngTA.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane7.setViewportView(removeEngTA);

        jButton9.setBackground(new java.awt.Color(0, 51, 51));
        jButton9.setText("Deny");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 51, 51));
        jButton10.setText("Done");

        removeBanglaTA.setBackground(new java.awt.Color(0, 102, 102));
        removeBanglaTA.setColumns(20);
        removeBanglaTA.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        removeBanglaTA.setRows(5);
        removeBanglaTA.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane11.setViewportView(removeBanglaTA);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9))
                    .addComponent(jScrollPane7)
                    .addComponent(removeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Single", jPanel4);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Settings", jPanel13);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         serialComboBox.setSelectedIndex(0);
         banglaTextArea.setText("");
         englishTextArea.setText("");
         searchTextField.setText("");
         bangKeyComboBox.setSelectedIndex(0);
         engKeyComboBox.setSelectedIndex(0);
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void serialComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialComboBoxActionPerformed
        // TODO add your handling code here:
        
        Object object=serialComboBox.getSelectedItem();
        String objType=object.getClass().getName();
        System.out.println("> "+objType);
        String intObj="java.lang.Integer";
        if(objType==intObj)
        {
            
            int tmp= (int) serialComboBox.getSelectedItem();
            String sql= "select * from "+dbTable+" where id=?";
            dateLabel.setText(getInfoClass.getDateFromDB(tmp));
             try
            {
                conn=DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                pst=conn.prepareStatement(sql);
                pst.setInt(1, tmp);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String bangla=rs.getString("bangla");
                    String english=rs.getString("english");
               
                     banglaTextArea.setText(bangla);
                     englishTextArea.setText(english);
                     sBTArea.setText(bangla);
                     sETArea.setText(english);
                }
               
                pst.close();
                conn.close();
       
            }
        
             catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e+"here");
            }
             
        }
        else
        {
         serialComboBox.setSelectedIndex(0);
         banglaTextArea.setText("কোন কিছু পাওয়া যায় নি !");
         englishTextArea.setText("No Item");
         sBTArea.setText("");
         sETArea.setText("");
         dateLabel.setText("");
                 
        }
        
    
    
    
    }//GEN-LAST:event_serialComboBoxActionPerformed

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
        // TODO add your handling code here:
        serialComboBox.setSelectedIndex(0);
        banglaTextArea.setText("");
        englishTextArea.setText("");
        
        
    }//GEN-LAST:event_CANCELActionPerformed

    private void bangKeyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bangKeyComboBoxActionPerformed
        // TODO add your handling code here:
        searchList.setFont(new  Font( "Vrinda", Font.PLAIN, 12 ));
         String sKey=(String) bangKeyComboBox.getSelectedItem();
        System.out.println(sKey);
        if(!sKey.equals(""))
        {
            setBangSearchList(sKey);
            listPanel.setVisible(true);
            searchTextField.setText("");
           // engKeyComboBox.setSelectedIndex(0);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter something to search ...");
        }
    }//GEN-LAST:event_bangKeyComboBoxActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
       
        Object object=serialComboBox.getSelectedItem();
        {
        String objType=object.getClass().getName();
     //   System.out.println("> "+objType);
        String intObj="java.lang.Integer";
        if(objType==intObj)
        {
            int selectedItem=(int )serialComboBox.getSelectedIndex();
            if(++selectedItem<= getInfoClass.LastID())
            {
               
                serialComboBox.setSelectedIndex(selectedItem);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No Item");
                serialComboBox.setSelectedIndex(0);
            }
        }
        else
        {
       // JOptionPane.showMessageDialog(null, "No Item");
                serialComboBox.setSelectedIndex(1);
            
        }
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        // TODO add your handling code here:
        
        Object object=serialComboBox.getSelectedItem();
        {
        String objType=object.getClass().getName();
     //   System.out.println("> "+objType);
        String intObj="java.lang.Integer";
        if(objType==intObj)
        {
            int selectedItem=(int )serialComboBox.getSelectedIndex();
            if(--selectedItem> 0)
            {
               
                serialComboBox.setSelectedIndex(selectedItem);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No Item");
                serialComboBox.setSelectedIndex(0);
            }
        }
        else
        {
        JOptionPane.showMessageDialog(null, "No Item");
                serialComboBox.setSelectedIndex(0);
            
        }
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    private void banglaListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_banglaListValueChanged
        // TODO add your handling code here:
        String tmp= (String) banglaList.getSelectedValue();
     System.out.println(tmp);
     if(tmp!=null)
       {
        String sql= "select * from "+dbTable+" where bangla=?";

        try
        {
            conn=DriverManager.getConnection("jdbc:sqlite:"+dbadd);
            pst=conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String bangla=rs.getString("bangla");
                String english=rs.getString("english");

                banglaTA.setText(bangla);
                englishTA.setText(english);
            }

            conn.close();
            pst.close();
            
            banglaList.clearSelection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e+"from here");
        }
       }
        
    }//GEN-LAST:event_banglaListValueChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        banglaTA.setText("");
        englishTA.setText("");
        banglaList.clearSelection();
        englishList.clearSelection();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         banglaTA.setText("");
        englishTA.setText("");
        banglaList.clearSelection();
        englishList.clearSelection();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void englishListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_englishListValueChanged
        // TODO add your handling code here:
         String tmp= (String) englishList.getSelectedValue();
     
         if(tmp!=null)
       {
        String sql= "select * from "+dbTable+" where english=?";

        try
        {
            conn=DriverManager.getConnection("jdbc:sqlite:"+dbadd);
            pst=conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String bangla=rs.getString("bangla");
                String english=rs.getString("english");

                banglaTA.setText(bangla);
                englishTA.setText(english);
            }

            conn.close();
            pst.close();
            
            englishList.clearSelection();
            
                    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e+" english");
        }
       }
    }//GEN-LAST:event_englishListValueChanged

    private void dbAddDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbAddDoneButtonActionPerformed
        // TODO add your handling code here:
        String engA=englishAddTA.getText().toString().trim();
        String banA=banglaAddTA.getText().toString().trim();
        String date=getDate();
        if(!engA.equals("") && !banA.equals(""))
        {
            AddIntoDB addDB=new AddIntoDB();
            addDB.InsertToDB(banA, engA, date);
                 
            JOptionPane.showMessageDialog(null, "Information Successfully Added Into DataBase.");
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Empty Area Is Not Acceptable...!");
        }

        banglaAddTA.setText("");
        englishAddTA.setText("");
        
        
        
        addLastID();
        
        serialComboBox.updateUI();
        editComboBox.updateUI();
        removeComboBox.updateUI();
        setTotal();
        setBanglaList();
        setEnglishList();

        
    }//GEN-LAST:event_dbAddDoneButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        banglaAddTA.setText("");
        englishAddTA.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void editComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editComboBoxActionPerformed
        // TODO add your handling code here:
        
        Object object=editComboBox.getSelectedItem();
        String objType=object.getClass().getName();
       // System.out.println("> "+objType);
        String intObj="java.lang.Integer";
        if(objType==intObj)
        {
            
            int tmp= (int) editComboBox.getSelectedItem();
            String sql= "select * from "+dbTable+" where id=?";
           
             try
            {
                conn=DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                pst=conn.prepareStatement(sql);
                pst.setInt(1, tmp);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String bangla=rs.getString("bangla");
                    String english=rs.getString("english");
               
                     editBanglaTA.setText(bangla);
                     editEngTA.setText(english);
                     
                }
               
                pst.close();
                conn.close();
       
            }
        
             catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e+" From edit panel");
            }
             
        }
        else
        {
         editComboBox.setSelectedIndex(0);
         editBanglaTA.setText("কোন কিছু পাওয়া যায় নি !");
         editEngTA.setText("No Item");
         
                 
        }
        
    
    
    }//GEN-LAST:event_editComboBoxActionPerformed

    private void removeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeComboBoxActionPerformed
        // TODO add your handling code here:
         
        Object object=removeComboBox.getSelectedItem();
        String objType=object.getClass().getName();
       // System.out.println("> "+objType);
        String intObj="java.lang.Integer";
        if(objType==intObj)
        {
            
            int tmp= (int) removeComboBox.getSelectedItem();
            String sql= "select * from "+dbTable+" where id=?";
           
             try
            {
                conn=DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                pst=conn.prepareStatement(sql);
                pst.setInt(1, tmp);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String bangla=rs.getString("bangla");
                    String english=rs.getString("english");
               
                     
                     removeBanglaTA.setText(bangla);
                     removeEngTA.setText(english);
                     
                     
                }
               
                pst.close();
                conn.close();
       
            }
        
             catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e+" From remove panel");
            }
             
        }
        else
        {
         removeComboBox.setSelectedIndex(0);
         removeBanglaTA.setText("কোন কিছু পাওয়া যায় নি !");
         removeEngTA.setText("No Item");
         
                 
        }
        
    
    
    }//GEN-LAST:event_removeComboBoxActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        editComboBox.setSelectedIndex(0);
        editBanglaTA.setText("");
        editEngTA.setText("");
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        removeComboBox.setSelectedIndex(0);
        removeBanglaTA.setText("");
        removeEngTA.setText("");
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void searchListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_searchListValueChanged
        // TODO add your handling code here:
           String tmp=  (String) searchList.getSelectedValue();
           String font=searchList.getFont().getFamily().toString();
           System.out.println("Font: "+font);
          System.out.println("tmpppp: "+tmp);
          String no="No Item !";
      if(font.equals("Times New Roman"))
      {
          if(tmp!=null && !evt.getValueIsAdjusting())
       {
        String sql= "select * from "+dbTable+" where english=?";

       // String sen=tmp.trim();
       
        try
        {
            conn=DriverManager.getConnection("jdbc:sqlite:"+dbadd);
            pst=conn.prepareStatement(sql);
            pst.setString(1, tmp.trim());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String bangla=rs.getString("bangla");
                String english=rs.getString("english");

                sBTArea.setText(bangla);
                sETArea.setText(english);
            }
            

            conn.close();
            pst.close();
            
            searchList.clearSelection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e+"from here");
        }
       }
      }
      else if(font.equals("Vrinda"))
              {
                  if(tmp!=null && !evt.getValueIsAdjusting())
       {
        String sql= "select * from "+dbTable+" where bangla=?";

       // String sen=tmp.trim();
       
        try
        {
            conn=DriverManager.getConnection("jdbc:sqlite:"+dbadd);
            pst=conn.prepareStatement(sql);
            pst.setString(1, tmp.trim());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String bangla=rs.getString("bangla");
                String english=rs.getString("english");

                sBTArea.setText(bangla);
                sETArea.setText(english);
            }
            

            conn.close();
            pst.close();
            
            searchList.clearSelection();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e+"from here");
        }
       }
              }
    }//GEN-LAST:event_searchListValueChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        sBTArea.setText("");
        sETArea.setText("");
        engKeyComboBox.setSelectedIndex(0);
        bangKeyComboBox.setSelectedIndex(0);
        searchList.removeAll();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String sKey=(searchTextField.getText().toString()).trim();
        System.out.println(sKey);
        if(!sKey.equals(""))
        {
            setSearchList(sKey);
           // listTabPan.listPanel.setVisible(true);
            searchTextField.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter something to search ...");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchListPropertyChange
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_searchListPropertyChange

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
         String sKey=(searchTextField.getText().toString()).trim();
        System.out.println(sKey);
        if(!sKey.equals(""))
        {
            setSearchList(sKey);
            listPanel.setVisible(true);
            searchTextField.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter something to search ...");
        }
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void engKeyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engKeyComboBoxActionPerformed
        // TODO add your handling code here:
        
        searchList.setFont(new  Font( "Times New Roman", Font.PLAIN, 12 ));
         String sKey=(String) engKeyComboBox.getSelectedItem();
        System.out.println(sKey);
        if(!sKey.equals(""))
        {
            setSearchList(sKey);
            listPanel.setVisible(true);
            searchTextField.setText("");
            //bangKeyComboBox.setSelectedIndex(0);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter something to search ...");
        }
    }//GEN-LAST:event_engKeyComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CANCEL;
    private javax.swing.JComboBox bangKeyComboBox;
    private javax.swing.JTextArea banglaAddTA;
    private javax.swing.JList banglaList;
    private javax.swing.JTextArea banglaTA;
    private javax.swing.JTextArea banglaTextArea;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton dbAddDoneButton;
    private javax.swing.JTextArea editBanglaTA;
    private javax.swing.JComboBox editComboBox;
    private javax.swing.JTextArea editEngTA;
    private javax.swing.JComboBox engKeyComboBox;
    private javax.swing.JTextArea englishAddTA;
    private javax.swing.JList englishList;
    private javax.swing.JTextArea englishTA;
    private javax.swing.JTextArea englishTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel listPanel;
    private javax.swing.JTabbedPane listTabPan;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JTextArea removeBanglaTA;
    private javax.swing.JComboBox removeComboBox;
    private javax.swing.JTextArea removeEngTA;
    private javax.swing.JTextArea sBTArea;
    private javax.swing.JTextArea sETArea;
    private javax.swing.JList searchList;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox serialComboBox;
    private javax.swing.JLabel totalsLabel;
    // End of variables declaration//GEN-END:variables
}
