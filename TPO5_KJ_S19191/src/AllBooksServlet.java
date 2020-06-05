import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.naming.*;
import java.sql.*;
import javax.sql.*;

@WebServlet("/allBooks")
public class AllBooksServlet extends HttpServlet {

    DataSource dataSource;
    private PrintWriter out;

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

    public void serviceRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String charset = "UTF-8";
        req.setCharacterEncoding(charset);
        resp.setContentType("text/html; charset=" + charset);
        out = resp.getWriter();
        Connection con = null;

        String formFileStart = getInitParameter("startForm");

        ServletContext context = getServletContext();
        InputStream in = context.getResourceAsStream("/WEB-INF/"+formFileStart);
        Reader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) out.println(line);
        out.println("<h2><a>Wszystkie książki</a></h2>");
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
                String formFileEnd = getInitParameter("endForm");
                in = context.getResourceAsStream("/WEB-INF/"+formFileEnd);
                reader = new InputStreamReader(in, "UTF-8");
                br = new BufferedReader(reader);
                while ((line = br.readLine()) != null) out.println(line);
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