/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.GetInfo;

/**
 *
 * @author mfh
 */
public class Search {
    
    GetInfo getInfo=new GetInfo();
    Sorting sort=new Sorting();
    String sKey;
    String getString[];
    String searchedString[];
    void setKeySearch(String key)
    {
             sKey=key;
    }
    void setBKeySearch(String key)
    {
        sKey=key;
    }
    String[] getKeySearch()
    {
        getString=sort.getEngString();
        searchedString=new String[getString.length];
        
        String uppercase=sKey.toUpperCase();
        String lowercase=sKey.toLowerCase();
        
        
        for(int i=0;i<getString.length;++i)
        {
            if(getString[i].startsWith(uppercase)||getString[i].startsWith(lowercase))
            {
                searchedString[i]=getString[i];
            }
  
        }
        
        //System.out.println(searchedString.length);
    return searchedString;
    }
    String[] getBKeySearch()
    {
        getString=sort.getBangString();
        searchedString=new String[getString.length];
        
        String uppercase=sKey.toUpperCase();
        String lowercase=sKey.toLowerCase();
        
        
        for(int i=0;i<getString.length;++i)
        {
            if(getString[i].startsWith(uppercase)||getString[i].startsWith(lowercase))
            {
                searchedString[i]=getString[i];
            }
  
        }
        
        //System.out.println(searchedString.length);
    return searchedString;
    }
    public static void main(String arp[])
    {
        Search ob=new Search();
        ob.setBKeySearch("ক");
        ob.getBKeySearch();
    }
    
}
