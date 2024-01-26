



import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayChat
 */
@WebServlet("/DisplayChat")
public class DisplayChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayChat() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doPost(HttpServletRequest Req, HttpServletResponse Res) throws ServletException, IOException
    {
     
      try
      {
        Res.setContentType("text/html");
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "P@ssw0rd");
	    
        Statement sqlStmt = conn.createStatement();
        

        String struname = Req.getParameter("uname");
        String strmsg = Req.getParameter("msg");
        
        SimpleDateFormat dd = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat hh = new SimpleDateFormat("hh:mm:ss a");
        Date todaydd = new Date();
        String strdd = dd.format(todaydd);
        String strhh = hh.format(todaydd);
        
        String str5 = "insert into ChatData values('" + struname + "','" + strmsg + "','" + strdd + "','" + strhh + "',seq_ChatData.nextval)";
        //Debugging
        System.out.println(str5);
        ResultSet resultSQL = sqlStmt.executeQuery(str5);
        
        resultSQL.next();
        conn.close();
      }
      catch (Exception localException) {
        localException.printStackTrace();
        System.out.println("Invalid User");
      }
    }
    
    public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException
    {
      doGet(paramHttpServletRequest, paramHttpServletResponse);
    }
  }


