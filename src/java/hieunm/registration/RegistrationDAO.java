/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunm.registration;

import hieunm.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class RegistrationDAO {

    public boolean authenticate(String userName,String password)
        throws SQLException,ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "SELECT * FROM registration WHERE UserName = ? AND Password = ?";
                stm = con.prepareStatement(query);
                stm.setString(1,userName);
                stm.setString(2,password);
                rs = stm.executeQuery();
                return rs.next();
            }
        }finally{
            if(rs!=null) rs.close(); if(stm!=null)stm.close();
            if(con!=null) con.close();
        }
        return false;
    }
    
    public List<RegistrationDTO> search(String searchValue) 
    throws SQLException,ClassNotFoundException{
        List<RegistrationDTO> accList = new ArrayList();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            //1. connect to DB
            con = DBUtil.getConnection();
            if(con!=null){
                //2. viet lenh query
                String query = "SELECT * FROM registration WHERE lastname LIKE ?";
                //Like: search gan dung; %?%: Search ky tu o vi tri bat ky
                //3. lay du lieu nap vao accList
                stm = con.prepareStatement(query);
                stm.setString(1,"%"+ searchValue+"%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String userName = rs.getString("username");//"username": ten cot trong db
                    String password = rs.getString("password");//"password": ten cot trong db
                    String lastName = rs.getString("lastname");//"lastname": ten cot trong db
                    boolean isAdmin = rs.getBoolean("isAdmin");//chu y bien kieu gi thi get kieu do
                    accList.add(new RegistrationDTO(userName,password,lastName,isAdmin));
                }
                
            }
        }finally{
            if(rs!=null) rs.close();if(stm!=null) stm.close();
            if(con!=null) con.close();
            return accList;
        }
    }
    
    public boolean delete(String id)
    throws SQLException,ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "DELETE FROM registration WHERE username=?";
                stm = con.prepareStatement(query);
                stm.setString(1, id);
                int affectedRows = stm.executeUpdate();
                return affectedRows>0;
            }
        }finally{
            if(stm!=null) stm.close(); if(con!=null)con.close();
        }
        return false;
    }
    
    public boolean update(String userName,String password,String lastName,boolean isAdmin) 
            throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "UPDATE registration SET password=?,lastname=?,isAdmin=? WHERE username=?";
                stm = con.prepareStatement(query);
                stm.setString(1, password);
                stm.setString(2, lastName);
                stm.setBoolean(3, isAdmin);
                stm.setString(4, userName);
                int affectedRow = stm.executeUpdate();
                return affectedRow >0;
            }
        }finally{
            if(stm!=null) stm.close(); if(con!=null) con.close();
        }
        return false;
    }
    public boolean checkAccountExist(String userName)
    throws SQLException,ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "SELECT * FROM registration WHERE username=?";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                rs = stm.executeQuery();
                return rs.next();
            }
        }finally{
            if(rs!=null)rs.close();if(stm!=null)stm.close();
            if(con!=null)con.close();
        }
        return false;
    }
  
    public boolean createNewAccount(String userName,String password,String firstName,String lastName,String phone)
    throws SQLException,ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "INSERT INTO registration VALUES (?,?,?,?,?)";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                stm.setString(2, password);
                stm.setNString(3, firstName);
                stm.setNString(4, lastName);
                stm.setString(5, phone);
                int affectedRows = stm.executeUpdate();
                return affectedRows != 0;
            }
        }finally{
            if(stm!=null)stm.close();if(con!=null)con.close();
        }
        return false;
    }
    
    public RegistrationDTO getUser(String userName)
    throws SQLException,ClassNotFoundException{
        //Get user by id
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtil.getConnection();
            if(con!=null){
                String query = "SELECT * FROM registration WHERE username=?";
                stm = con.prepareStatement(query);
                stm.setString(1, userName);
                rs = stm.executeQuery();
                if(rs.next()){
                    String password = rs.getString("password");
                    String lastName = rs.getString("lastname");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    RegistrationDTO user = new RegistrationDTO(userName, password, lastName, isAdmin);
                    return user;
                }
            }
        }finally{
            if(rs!=null)rs.close();if(stm!=null)stm.close();if(con!=null)con.close();
        }
        return null;
    }
}
