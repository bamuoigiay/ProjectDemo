<%-- 
    Document   : add
    Created on : Jun 26, 2024, 2:04:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <h1>Add Product:</h1>
        <form action="MainController" method="POST">
            <input type="number" name="productID" placeholder="ProductId"/><br/>
            <input type="text" name="productName" placeholder="Product Name"/><br/>
            <input type="text" name="Status" placeholder="Status"/><br/>
            <input type="number" name="Price" placeholder="Price"/><br>
            <input type="number" name="Amount" placeholder="Amount"/><br>
            <input type="submit" name="btAction" value="AddProduct"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
