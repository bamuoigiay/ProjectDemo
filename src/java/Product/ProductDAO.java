/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import hieunm.db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kim Cuong
 */
public class ProductDAO {

    private static List<ProductDTO> proList = null;

    public List<ProductDTO> getProList() {
        return proList;
    }

    public ProductDTO getProByName(String name) {
        for (ProductDTO productDTO : proList) {
            if (productDTO.getProductName().trim().equalsIgnoreCase(name.trim())) {
                return productDTO;
            }
        }
        return null;
    }

    public List<ProductDTO> search(String searchValue)
            throws SQLException, ClassNotFoundException {
        List<ProductDTO> ProList = new ArrayList();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "Select * from product";
                stm = con.prepareStatement(query);
                stm.setString(1, searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int ID = rs.getInt("productID");
                    String name = rs.getString("productName");
                    String Status = rs.getString("Status");
                    int Price = rs.getInt("Price");
                    int Amount = rs.getInt("Amount");
                    ProList.add(new ProductDTO(ID, name, Status, Price, Amount));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            return ProList;
        }
    }

    public boolean createNewProduct(int ID, String Name, String Status, int Price, int Amount)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "INSERT INTO Product(productID, productName, Status, Price, Amount) VALUES(?,?,?,?,?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, ID);
                stm.setString(2, Name);
                stm.setString(3, Status);
                stm.setInt(4, Price);
                stm.setInt(5, Amount);
                int affectedRows = stm.executeUpdate();
                return affectedRows > 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean removeProduct(int productID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "DELETE FROM Product WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, productID);
                int affectedRows = stm.executeUpdate();
                return affectedRows > 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateProduct(int productID, String newName, String newStatus, int newPrice, int newAmount)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String query = "UPDATE Product SET productName = ?, Status = ?, Price = ?, Amount = ? WHERE productID = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, newName);
                stm.setString(2, newStatus);
                stm.setInt(3, newPrice);
                stm.setInt(4, newAmount);
                stm.setInt(5, productID);
                int affectedRows = stm.executeUpdate();
                return affectedRows > 0;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

}
