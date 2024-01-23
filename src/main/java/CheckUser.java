

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CheckUser")
public class CheckUser extends javax.servlet.http.HttpServlet
{
  public CheckUser() {}
  
  public void doPost(HttpServletRequest paramReq, HttpServletResponse paramRes) throws ServletException, IOException
  {
    PrintWriter prWriter = paramRes.getWriter();
    try {
    	paramRes.setContentType("text/html");
      
    Class.forName("oracle.jdbc.OracleDriver");
    
    Connection localConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sys as sysdba", "P@ssw0rd");
      Statement sqlStmt = localConnection.createStatement();     
      String struname = paramReq.getParameter("uname");
      System.out.println(struname);
      String strpw = paramReq.getParameter("pw");
      System.out.println(strpw);
      String strSQL = "select * from ChatUSer where username='" + struname + "' AND password='" + strpw + "'";
      
      ResultSet sqlResultSet = sqlStmt.executeQuery(strSQL);
      if (sqlResultSet.next())
      {
        String strunamefrmSQL = sqlResultSet.getString("username");
        HttpSession httpSession = paramReq.getSession();
        httpSession.setAttribute("name", strunamefrmSQL);
        prWriter.println("<p style='color:white;' > Welcome, " + strunamefrmSQL.toUpperCase() + "</p>");
        prWriter.println("<br/> ");
        prWriter.println("<a href='mainchat.jsp' style='color: white;'>Start Chat</a>");
        prWriter.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='logout.jsp' style='color: white;'>Logout</a>");
      } else {
    	  prWriter.println("Incorrect Username or Password.");
      }
      System.out.println("done");

      localConnection.close();
    } catch (Exception localException) {
      localException.printStackTrace();
      System.out.println("Invalid User");
    }
  }
  
  public void doGet(HttpServletRequest paramReq, HttpServletResponse paramRes) throws ServletException, IOException {
    doGet(paramReq, paramRes);
  }
}