


import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetrieveChatData
 */
@WebServlet("/RetrieveChatData")
public class RetrieveChatData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveChatData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest paramReq, HttpServletResponse paramRes) throws ServletException, IOException {
        doGet(paramReq, paramRes);
      }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest paramReq, HttpServletResponse paramRes) throws ServletException, IOException
	  {
		try
	    {
			paramRes.setContentType("text/html");
		      
	      
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "P@ssw0rd");
	      String strSelectSQL = "select * from ChatData";
	      PreparedStatement sqlStmt = conn.prepareStatement(strSelectSQL);
	      
	      ResultSet resultSQL = sqlStmt.executeQuery();
	      
	      while (resultSQL.next()) {
	        String struname = resultSQL.getString(1);
	        String strmsg = resultSQL.getString(2);
	        String strdd = resultSQL.getString(3);
	        String strhh = resultSQL.getString(4);
	        PrintWriter prWriter = paramRes.getWriter();
	        prWriter.print("<p>" + struname + "-<g style='color:blue;'>" + strmsg + "</g><br><small>" + strdd + " " + strhh + "</small></p>");
	      }
	      conn.close();

	    }
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	      System.out.println("Error");
	    }
	}

}
