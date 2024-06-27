<%-- 
    Document   : viewCart
    Created on : Jun 24, 2024, 12:20:05 PM
    Author     : LENOVO
--%>

<%@page import="Product.ProductDTO"%>
<%@page import="Product.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIEW CART</title>
    </head>
    <body>
        <h1>View Cart Page</h1>
        <% Cart cart = (Cart) session.getAttribute("CART");%>
        <form action="MainController">
            <table border="1">
            <thead>
            <tr>
                <th>No.</th>
                <th>Food</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>
                <% if(cart!=null){
                    for(int i=0;i<cart.size();i++){
                        ProductDTO product = cart.get(i);
                %>        
                <tr>
                    <td><%=i+1%></td>
                    <td><%=product.getName()%></td>
                    <td><%=product.getQuantity()%></td>
                </tr>
                <%}}%>
            </tbody>
            </table>
        </form>
    </body>
</html>
