import java.util.*;

public class DbAccessDef_plAllBooks extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            { "charset", "ISO-8859-2" },
            { "header", new String[] { "Baza danych książek" } },
            { "footer", new String[] { } },
            { "resDescr",
                    new String[] { "" } },
    };
}