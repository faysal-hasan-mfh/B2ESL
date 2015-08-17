/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
 *
 * @author mfh
 */
public class GetInfo {
    Connection c = null;
    Statement stmt = null;
    
    String web_name[]=new String [5000];
    String allInfo[]= new String[8];;
    int id[]=new int[5000];
    String date;
    DatabaseExistence dbe=new DatabaseExistence();
    
    
    int getLastId;
   
    String dbadd="C:/Program Files/B2ESL/B2ESL.db";
   //  URL dbadd= getClass().getResource("/View/files/ESLDB.db");
  
    String dbTable="besl";
    String tableColumn1="id";
    String tableColumn2="bangla";
    String tableColumn3="english";
    String tableColumn4="date";
    public int[] getIDFromDB(){
    
   if(dbe.DBExists()){     
        try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+dbadd);
      c.setAutoCommit(false);
   //   System.out.println("Opened librarian database ID successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM "+dbTable+";" );
      
      int countID=0;
      while ( rs.next() ) {
          
     
         this.id[countID]=rs.getInt(tableColumn1);
       
         
         ++countID;
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage()+"Getinfo...1" );
      System.exit(0);
    }
        
        return id;
   }
   else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error.."+"Getinfo...1", JOptionPane.ERROR_MESSAGE);
    return id;
    }
   
    }
    
    
   
    
    
    
    public void showIDFromDB(int []id ){
               
        int count3=0;
      while(count3<id.length)
      {
      
          if(web_name[count3]!=null) {
              System.out.println(id[count3]);
          }
          
          ++count3;
      }
        
    }
    
    
    
     public int totalID(String []wn ){
        
     int totalIDnum=0,countid=0;
      while((countid<wn.length)&&(web_name[countid]!=null))
      {
      
       totalIDnum= ++countid;
        
      }
        
      
      return totalIDnum;
      
    }
    
     // Last id       ,,,,,,,,,,,,,............
     
    public int LastID(){
    
        if(dbe.DBExists()){     
        
            try {
     
                Class.forName("org.sqlite.JDBC");
                
                 c = DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                c.setAutoCommit(false);
      
             //   System.out.println("Opened librarian database ID successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM "+dbTable+";" );
      
       int countID=0;
                 while ( rs.next() ) {
                         this.id[countID]=rs.getInt(tableColumn1);
                           getLastId=id[countID];
                        ++countID;
                        }
                 
      
                 rs.close();
                 stmt.close();
                   c.close();
            }
            catch ( Exception e ) {
                        System.err.println( e.getClass().getName() + ": " + e.getMessage()+"Getinfo...2" );
                        System.exit(0);
                }
        
        return getLastId;
   }
   else{
  //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return getLastId;
    }
   
    }
    
    
    
    
    
    
    
    
    
  
    
    
     public boolean getBookIdExistFromDB(String targetOffID){
    
     boolean isFound=false;
    
        if(dbe.DBExists()){
        
            try {
      
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                c.setAutoCommit(false);
           //     System.out.println("Opened librarian database successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM "+dbTable+";" );
      
                
               
                
             
              
              
      
              while ( rs.next() ) {
          
              
         
         String loid = rs.getString("BOOKSID");
        
         
                  if(targetOffID.equals(loid))
                  {
                     isFound=true;
                  break;
                  }
              }

      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage()+"Getinfo...3" );
      
      System.exit(0);
    }
        
            return isFound;
      
    }
    else{
 //   JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return isFound;
    }
    }
    
     
     
    
     
     
     public String[] getBanglaFromDB(){
    
     
    
        if(dbe.DBExists()){
        
            try {
      
                
                Class.forName("org.sqlite.JDBC");
      
                c = DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                c.setAutoCommit(false);
                System.out.println("Opened database b2esl DB bangla successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM "+dbTable+";" );
      
              int count=0;
      
              while ( rs.next() ) {
          
                  this.web_name[count]=rs.getString(tableColumn2);
        
                      ++count;
                }
      rs.close();
      stmt.close();
      c.close();
      System.out.println("closed bangla b2esl db successfully...");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage()+"Getinfo...4");
      
      System.exit(0);
    }
        
        return web_name;
    }
    else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error.."+"Getinfo...4", JOptionPane.ERROR_MESSAGE);
    return web_name;
    }
    }
    
     
     public String[] getEnglishFromDB(){
    
     
    
        if(dbe.DBExists()){
        
            try {
      
                
                Class.forName("org.sqlite.JDBC");
      
               c = DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                c.setAutoCommit(false);
               System.out.println("Opened database  ee BESLDB successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM "+dbTable+";" );
      
              int count=0;
      
              while ( rs.next() ) {
          
                  this.web_name[count]=rs.getString(tableColumn3);
        
                      ++count;
                }
      rs.close();
      stmt.close();
      c.close();
      System.out.println("closed english b2esl db successfully..."+count+web_name.length);
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage()+"Getinfo...eng" );
      
      System.exit(0);
    }
        
        return this.web_name;
    }
    else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error.."+"Getinfo...eng", JOptionPane.ERROR_MESSAGE);
    return web_name;
    }
    }
     
     
     public String getDateFromDB(int id){
    
     
    
        if(dbe.DBExists()){
        
            try {
      
                
                Class.forName("org.sqlite.JDBC");
      
               c = DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                c.setAutoCommit(false);
      //          System.out.println("Opened database ESLDB successfully");

      
      
      
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM "+dbTable+";" );
      
              
      
              while ( rs.next() ) {
                  
                 int dId=rs.getInt(tableColumn1);
                  if(dId==id)
                  {
                  date=rs.getString(tableColumn4);
                  break;
                  }
                  
                }
      rs.close();
      stmt.close();
      c.close();
      System.out.println("closed english b2esl db successfully...");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage()+"Getinfo...eng" );
      
      System.exit(0);
    }
        
        return date;
    }
    else{
    JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error.."+"Getinfo...date", JOptionPane.ERROR_MESSAGE);
    return date;
    }
    }
     
     
     
     
     public int LastSerial(){
    
        if(dbe.DBExists()){     
        
            try {
     
                Class.forName("org.sqlite.JDBC");
                
               c = DriverManager.getConnection("jdbc:sqlite:"+dbadd);
                c.setAutoCommit(false);
      
             //   System.out.println("Opened librarian database ID successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM ESL;" );
      
       int countID=0;
                 while ( rs.next() ) {
                         this.id[countID]=rs.getInt("serial");
                           getLastId=id[countID];
                        ++countID;
                        }
                 
      
                 rs.close();
                 stmt.close();
                   c.close();
            }
            catch ( Exception e ) {
                        System.err.println( e.getClass().getName() + ": " + e.getMessage()+"Getinfo...serial" );
                        System.exit(0);
                }
        
        return getLastId;
   }
   else{
  //  JOptionPane.showMessageDialog(null, "sorry.. no database existed..", "Error..", JOptionPane.ERROR_MESSAGE);
    return getLastId;
    }
   
    }
    
     public static void main(String ar[])
     {
     
         GetInfo ob=new GetInfo();
         
         String arg[]= ob.getBanglaFromDB();
     
     }
     
}
