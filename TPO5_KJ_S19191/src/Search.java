import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/search")
public class Search extends HttpServlet {

    DataSource dataSource;
    private PrintWriter out;

    private void printEndTag() {
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

    public void serviceRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        out = resp.getWriter();

        String formFile = getInitParameter("seachBookForm");
        ServletContext context = getServletContext();
        InputStream in = context.getResourceAsStream("/WEB-APP/"+formFile);
        BufferedReader br = new BufferedReader( new InputStreamReader(in));

        String line;
        while ((line = br.readLine()) != null) out.println(line);
        String formTitle = req.getParameter("tytul");

        if (formTitle == null) {
            printEndTag();
            out.close();
            return;
        }

        Connection con = null;
        try {
            synchronized (dataSource) {
                con = dataSource.getConnection();
            }
            PreparedStatement pstmt = con.prepareStatement("select * from pozycje where tytul like ?");
            pstmt.setString(1, "%" + formTitle + "%");
            ResultSet rs = pstmt.executeQuery();
            out.println("<ol>");
            while (rs.next())  {
                String tytul = rs.getString("tytul");
                float cena  = rs.getFloat("cena");
                out.println("<li>" + tytul + " - cena: " + cena + "</li>");
            }
            out.println("</ol>");
            rs.close();
            pstmt.close();
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serviceRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serviceRequest(request, response);
    }
}
