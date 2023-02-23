/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.napier.sem;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
/**
 *
 * @author FAQ
 */
public class DB {
    
    Connection con = null;
        
    
    public Connection connect(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con =(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/worlddb","root","");  
            //here sonoo is database name, root is username and password  
             
        }catch(Exception e){ System.out.println(e);}  
        
            return con;
        
    }  
    
    
    public ResultSet queryExe(String query){
    
        connect();
        ResultSet rs=null;
        try{
            Statement stmt=(Statement) con.createStatement();  
            rs = (ResultSet) stmt.executeQuery(query);  
            while(rs.next()){
                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                
                int column_count = rsmd.getColumnCount();
                
                for(int i=1;i<column_count;i++){
                   
                    System.out.print(rs.getObject(i)+" ");
                    
                    
                }
                System.out.println("");
            
            }  
            
            con.close();  
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return rs;
    }
    
    
    
    
    
    
    public void disconnect(){
        
        try{  
            
            con.close();
            
        }catch(Exception e){ System.out.println(e);}  
        
        
    }  
    
    
    }
