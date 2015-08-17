/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author mfh
 */
public class AddIntoDB {
    
      Connection c = null;
      Statement stmt = null;
    
       String dbadd="C:/Program Files/B2ESL/B2ESL.db";
   //  URL dbadd= getClass().getResource("/View/files/ESLDB.db");
  
    String dbTable="besl";
    String tableColumn1="id";
    String tableColumn2="bangla";
    String tableColumn3="english";
    String tableColumn4="date";
      
    public void InsertToDB(String bangla, String english, String date){
    
    
      GetInfo getInfo=new GetInfo();
        
        int lastID= getInfo.LastID();
        
        System.out.println("Last Id is: "+lastID);
       

         
        try {
      
            
            Class.forName("org.sqlite.JDBC");
    
            c = DriverManager.getConnection("jdbc:sqlite:"+dbadd);
            c.setAutoCommit(false);
            System.out.println("Opened bes 1 ..insert... database successfully");

              stmt = c.createStatement();
              
              
              
              
             String sql = "INSERT INTO "+dbTable+" (id,bangla,english,date) " +
                   "VALUES (?,?,?,?);"; 
             
             PreparedStatement pst= c.prepareStatement(sql);
             
             pst.setInt(1,++lastID);
             pst.setString(2,bangla);
             pst.setString(3,english);
             pst.setString(4,date);
            
             
              pst.executeUpdate();
      
              
              
              stmt.close();
      
              
              c.commit();
      
              
              c.close();
              
              System.out.println("Successfully Closed.. addition... db");
    } 
        
        catch ( Exception e ) {
      
            System.err.println( e.getClass().getName() + ": " + e.getMessage()+"add into db" );
      
            System.exit(0);
    }
        
        
    System.out.println(" >> 1 Records created successfully");
  //  JOptionPane.showMessageDialog(null, "Successfully added to DB..", "Insertion Info:", JOptionPane.OK_OPTION);
}
    
    public static void main(String ar[])
    {
        AddIntoDB object=new AddIntoDB();
        
        object.InsertToDB( "ফয়সাল হাসান", "md. faysal hasan", "22/12/2014");
    
    }
}
