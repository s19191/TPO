// SERWLET POBIERANIA PARAMETRÓW
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/getParamsAllBooks")
public class GetParamsServletAllBooks extends HttpServlet {

    private ServletContext context;
    private String resBundleServ;    // nazwa serwletu przygotowującego
    // sparametryzowaną informacje
    private PrintWriter out;

    // Inicjacja
    public void init() {
        context = getServletContext();
        resBundleServ = context.getInitParameter("ResBundleServletAllBooks");
    }

    // Obsługa zleceń
    public void serviceRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Włączenie serwletu przygotowującego informacje z z zasobów
        // (ResourceBundle). Informacja będzie dostępna poprzez
        // statyczne metody klasy BundleInfo

        RequestDispatcher disp = context.getRequestDispatcher(resBundleServ);
        disp.include(req, resp);

        // Pobranie potrzebnej informacji
        // ktora została wczesniej przygotowana
        // przez klasę BundleInfo na podstawie zlokalizowanych zasobów

        // Zlokalizowana strona kodowa
        String charset = BundleInfo.getCharset();

        // Napisy nagłówkowe
        String[] headers = BundleInfo.getHeaders();

        // Nazwy parametrów (pojawią się w formularzu,
        // ale również są to nazwy parametrów dla Command)
        String[] pnames = BundleInfo.getCommandParamNames();

        // Opisy parametrów - aby było wiadomo co w formularzu wpisywać
        String[] pdes   = BundleInfo.getCommandParamDescr();

        // Napis na przycisku
        String submitMsg = BundleInfo.getSubmitMsg();

        // Ew. końcowe napisy na stronie
        String[] footers = BundleInfo.getFooters();

        // Ustalenie właściwego kodowania zlecenia
        // - bez tego nie będzie można własciwie odczytać parametrów
        req.setCharacterEncoding(charset);

        // Pobranie aktualnej sesji
        // w jej atrybutach są/będą przechowywane
        // wartości parametrów

        HttpSession session = req.getSession();

        // Generowanie strony

        resp.setCharacterEncoding(charset);
        out = resp.getWriter();

        String formFile = getInitParameter("startForm");

        ServletContext context = getServletContext();
        InputStream in = context.getResourceAsStream("/WEB-APP/"+formFile);
        BufferedReader br = new BufferedReader( new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) out.println(line);

        out.println("<center><h2>");
        for (int i=0; i<headers.length; i++)
            out.println(headers[i]);
        out.println("</center></h2><hr>");

    }

    //..metody doGet i doPost - wywołują serviceRequest

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceRequest(req,resp);
    }
}