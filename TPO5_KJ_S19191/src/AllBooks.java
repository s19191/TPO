import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.naming.*;
import java.sql.*;
import javax.sql.*;

@WebServlet("/allBooks")
public class AllBooks extends HttpServlet {

    DataSource dataSource;
    private PrintWriter out;

    private void printEndTag() {
        out.println("</ol>");
        out.println("</div>");
        out.println("<div id=\"footer\"></div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    public void init() throws ServletException {
        try {
            Context init = new InitialContext();
            Context contx = (Context) init.lookup("java:comp/env");
            dataSource = (DataSource) contx.lookup("jdbc/ksidb");
        } catch (NamingException exc) {
            throw new ServletException(
                    "Nie mogę uzyskać źródła java:comp/env/jdbc/ksidb", exc);
        }
    }

    public void serviceRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html; charset=windows-1250");
        out = resp.getWriter();
        Connection con = null;

        String formFile = getInitParameter("allBooksForm");

        ServletContext context = getServletContext();
        InputStream in = context.getResourceAsStream("/WEB-APP/"+formFile);
        BufferedReader br = new BufferedReader( new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) out.println(line);

        try {
            synchronized (dataSource) {
                con = dataSource.getConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pozycje");
            out.println("<ol>");
            while (rs.next())  {
                String tytul = rs.getString("tytul");
                float cena  = rs.getFloat("cena");
                out.println("<li>" + tytul + " - cena: " + cena + "</li>");
            }
            rs.close();
            stmt.close();
        } catch (Exception exc)  {
            out.println(exc.getMessage());
        } finally {
            try {
                printEndTag();
                con.close();
            } catch (Exception exc) {}
        }
        out.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serviceRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serviceRequest(request, response);
    }
}