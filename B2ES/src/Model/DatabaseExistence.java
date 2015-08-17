/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;

/**
 *
 * @author mfh
 */
public class DatabaseExistence {
    
    File database;
    String fileName="C:/Program Files/B2ESL/B2ESL.db";
    public boolean DBExists()
    {
    database= new File(fileName);
    // URL dbadd= getClass().getResource("/View/files/ESLDB.db");
     
    if(database.exists())
        {
            return true;
        }
    
    else 
        {
            return false;
        }
    
    
    }
    
    public static void main(String ar[])
    {
    DatabaseExistence ob=new DatabaseExistence();
     
    System.out.println(">> "+ob.DBExists());
    }
}
