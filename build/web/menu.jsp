<%-- 
    Document   : menu.jsp
    Created on : Jun 24, 2024, 9:52:40 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU</title>
    </head>
    <body>
        <h1>Menu Page</h1>
        
        <form action="MainController" method="GET">
            
            Search <input type="text" name="txtSearchValue"/> 
            <input type="submit" name="btAction" value="Search"/>
            <div>
                hamburger 
                <a href="MainController?btAction=Add&Food=<%="hamburger"%>">Add To Cart</a>
            </div><br/>
            <div>
                sandwich 
                <button><a href="MainController?btAction=Add&Food=sandwich">Add To Cart</a></button>
            </div><br/>
            <input type="submit" name="btAction" value="View Cart"/>    
            
        </form>
        
    </body>
</html>
