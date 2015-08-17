/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.GetInfo;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author mfh
 */
public class Sorting {
    
    GetInfo getInfo=new GetInfo();
    String getEnglishAll[];
    String getBanglaAll[];
    String total[];
    String[] getEngString()
    {
        getEnglishAll = getInfo.getEnglishFromDB();
        int lastID=getInfo.LastID();
        total=new String[lastID];
       // System.out.println(getEnglishAll[0]);
     
        for(int i=0;i<getEnglishAll.length;++i)
        {
            if(getEnglishAll[i]!=null)
            {
                total[i]=getEnglishAll[i];
            }
        }
         if(total.length!=0)
         {
         Arrays.sort(total);
         System.out.println(total[0]);
         return total;
         }
         else
         {
         System.out.println("Sorry.. there is no item.... from sorting...");
         return total;
         }
         
      //  return total.length;
    }
    String[] getBangString()
    {
        getBanglaAll = getInfo.getBanglaFromDB();
        int lastID=getInfo.LastID();
        total=new String[lastID];
       // System.out.println(getEnglishAll[0]);
     
        for(int i=0;i<getBanglaAll.length;++i)
        {
            if(getBanglaAll[i]!=null)
            {
                total[i]=getBanglaAll[i];
            }
        }
         if(total.length!=0)
         {
         Arrays.sort(total);
         System.out.println(total[0]);
         return total;
         }
         else
         {
         System.out.println("Sorry.. there is no item.... from sorting...");
         return total;
         }
         
      //  return total.length;
    }
    void engSorting()
    {
       
        
       
       // System.out.println("LLL: "+getEnglishAll.length);
        
   
        Arrays.sort(getEnglishAll);
       
       System.out.println(">>"+getEnglishAll[0]);
       
        
    
    
    }
   /* int getLength()
    {
    String ge[]=getInfo.getEnglishFromDB();
    return ge.length;
    
    }
    */
    
    
    void Sortting()
    {
     String s[]={"b","d","c","e","a"};
     
     Arrays.sort(s);
     System.out.println(s[0]);
    }
    
    public static void main(String arg[])
    {
        Sorting ob=new Sorting();
     //   ob.engSorting();
     //  System.out.println("Length of eng: "+ob.getString()+"     ");
     //   ob.Sortting();
       // ob.engSorting();
        ob.getEngString();
        ob.getBangString();
    }
}
