import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/allBooksss")
public class AllBooksServlet extends HttpServlet {

    DataSource dataSource;

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
        List<String> books = new ArrayList<>();
        Connection con = null;
        try {
            synchronized (dataSource) {
                con = dataSource.getConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from POZYCJE inner join AUTOR on POZYCJE.AUTID = AUTOR.AUTID inner join WYDAWCA on POZYCJA.WYDID = WYDAWCA.WYDID");
            String line;
            while (rs.next()) {
            }
            rs.close();
            stmt.close();
        } catch (Exception exc)  {

        } finally {
            try {
                con.close();
            } catch (Exception exc) {}
        }
//        req.setAttribute("allBooksList", books);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/allBooks.jsp");
//        dispatcher.forward(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serviceRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serviceRequest(request, response);
    }
}