package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel='stylesheet' href='./css/register.css'>\n");
      out.write("        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <style>\n");
      out.write("            @import url('https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100..700;1,100..700&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');\n");
      out.write("        </style>\n");
      out.write("        <title>SIGN UP</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper-register\">\n");
      out.write("        <h1>Sign Up</h1>\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\n");
      out.write("            \n");
      out.write("            <div class=\"input-box\">\n");
      out.write("                <input type=\"text\" required name=\"txtUserName\"> \n");
      out.write("                <label>User Name</label>\n");
      out.write("                <i class='bx bxs-user'></i>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-box\">\n");
      out.write("            <input type=\"password\" required name=\"txtPassword\"> \n");
      out.write("                <label>Password</label>\n");
      out.write("                <i class='bx bxs-lock-alt'></i>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-box\">\n");
      out.write("                <input type=\"text\" required name=\"txtFirstName\"> \n");
      out.write("                <label>First Name</label>\n");
      out.write("                <i class='bx bxs-user'></i>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-box\">\n");
      out.write("                <input type=\"text\" required name=\"txtLastName\"> \n");
      out.write("                <label>Last Name</label>\n");
      out.write("                <i class='bx bxs-user'></i>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class='input-box'>\n");
      out.write("                <input type=\"text\" required name=\"phoneNumber\"> \n");
      out.write("                <label>Phone Number</label>\n");
      out.write("                <i class='bx bxs-phone' ></i>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            <button type=\"submit\" class=\"btn\" name=\"btAction\" value=\"Register\">Sign Up</button>\n");
      out.write("            \n");
      out.write("            <div class=\"longin-link\">\n");
      out.write("                p>Already have an account? \n");
      out.write("                <a href=\"login.html\">Login</a></p>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
