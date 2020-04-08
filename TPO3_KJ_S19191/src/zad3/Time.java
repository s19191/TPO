/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad3;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Time {

    public static String passed(String from, String to) {
        String result;
        LocalDate fromLd = null;
        LocalDate toLd = null;
        LocalDateTime fromLdt = null;
        LocalDateTime toLdt = null;
        long years;
        long months;
        long days;
        long hours;
        long minutes;
        String weeks;
        try {
           try {
               fromLd = LocalDate.parse(from);
               toLd = LocalDate.parse(to);
               years = ChronoUnit.YEARS.between(fromLd, toLd);
               months = ChronoUnit.MONTHS.between(fromLd, toLd) - years * 12;
               days = ChronoUnit.DAYS.between(fromLd, toLd);
               Locale none = new Locale("xx");
               weeks = String.format(none,"%.2f", ChronoUnit.DAYS.between(fromLd, toLd)/7.0);
               String dpatt = "d MMMM yyyy (EEEE)";
               String fromResult = fromLd.format(DateTimeFormatter.ofPattern(dpatt));
               String toResult = fromLd.format(DateTimeFormatter.ofPattern(dpatt));
               return result = "Od " + fromResult + "do " + toResult + "\n - mija: " + days + " dni, tygodni " + weeks + "\n- kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dni";
           } catch (DateTimeParseException ex) {
               fromLdt = LocalDateTime.parse(from);
               toLdt = LocalDateTime.parse(to);
               ZonedDateTime zdt1 = ZonedDateTime.of(fromLdt, ZoneId.of("Europe/Warsaw"));
               ZonedDateTime zdt2 = ZonedDateTime.of(toLdt, ZoneId.of("Europe/Warsaw"));
               minutes = ChronoUnit.MINUTES.between(zdt1, zdt2);
               hours = ChronoUnit.HOURS.between(zdt1, zdt2);
               days = ChronoUnit.DAYS.between(zdt1, zdt2);
               Locale none = new Locale("xx");
               weeks = String.format(none,"%.2f", ChronoUnit.DAYS.between(fromLdt, toLdt)/7.0);
               String tpatt = "d MMMM yyyy (EEEE) 'godz.' HH:mm";
               String fromResult = fromLdt.format(DateTimeFormatter.ofPattern(tpatt));
               String toResult = fromLdt.format(DateTimeFormatter.ofPattern(tpatt));
               return result = "Od " + fromResult + "  do " + toResult + "\n - mija: " + days + " dzień, tygodni " + weeks + "\n" + "-godzin: " + hours +", minut: " + minutes + "\n- kalendarzowo: ";
           }
        } catch (DateTimeParseException ex) {
            return ex.getParsedString() + ex.getMessage();
        }
    }
}
