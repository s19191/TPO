/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad3;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Time {

    public static String passed(String from, String to) {
//        System.out.println(from);
//        System.out.println(to);
        LocalDate fromLd;
        LocalDate toLd;
        LocalDateTime fromLdt;
        LocalDateTime toLdt;
        long years;
        long months;
        long daysAll;
        long days;
        long hours;
        long minutes;
        String weeks;
        String firstCatch = null;
        try {
           try {
               fromLd = LocalDate.parse(from);
               toLd = LocalDate.parse(to);
               Period p = Period.between(fromLd, toLd);
               years = ChronoUnit.YEARS.between(fromLd, toLd);
               months = p.getMonths();
               daysAll = ChronoUnit.DAYS.between(fromLd, toLd);
               days = p.getDays();
               Locale none = new Locale("xx");
               weeks = String.format(none,"%.2f", ChronoUnit.DAYS.between(fromLd, toLd)/7.0);
               if (Double.parseDouble(weeks) == 0.00) {
                   weeks = "0";
               }
               String ldPattern = "d MMMM yyyy (EEEE)";
               String fromResult = fromLd.format(DateTimeFormatter.ofPattern(ldPattern));
               String toResult = toLd.format(DateTimeFormatter.ofPattern(ldPattern));
               if (years == 1) {
                   if (months == 1) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc";
                           }
                       }
                   } else if (months >= 2 && months <= 4) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące";
                           }
                       }
                   } else if (months >= 5) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy";
                           }
                       }
                   } else if (months <= 0) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " rok";
                           }
                       }
                   }
               } else if (years >= 2 && years <= 4) {
                   if (months == 1) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc";
                           }
                       }
                   } else if (months >= 2 && months <= 4) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące";
                           }
                       }
                   } else if (months >= 5) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy";
                           }
                       }
                   } else if (months <= 0) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lata";
                           }
                       }
                   }
               } else if (years >= 5) {
                   if (months == 1) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc";
                           }
                       }
                   } else if (months >= 2 && months <= 4) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące";
                           }
                       }
                   } else if (months >= 5) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy";
                           }
                       }
                   } else if (months <= 0) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + years + " lat";
                           }
                       }
                   }
               } else if (years <= 0) {
                   if (months == 1) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiąc";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiąc";
                           }
                       }
                   } else if (months >= 2 && months <= 4) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiące";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesiące";
                           }
                       }
                   } else if (months >= 5) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesięcy";
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + months + " miesięcy";
                           }
                       }
                   } else if (months <= 0) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - kalendarzowo: " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks;
                           }
                       } else if (daysAll >= 2) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - kalendarzowo: " + days + " dni";
                           } else if (days <= 0){
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks;
                           }
                       }
                   }
               }
           } catch (DateTimeParseException ex) {
               firstCatch = ex.toString();
               fromLdt = LocalDateTime.parse(from);
               toLdt = LocalDateTime.parse(to);
               fromLd = fromLdt.toLocalDate();
               toLd = toLdt.toLocalDate();
               Period p = Period.between(fromLd, toLd);
               ZonedDateTime fromZdt = ZonedDateTime.of(fromLdt, ZoneId.of("Europe/Warsaw"));
               ZonedDateTime toZdt = ZonedDateTime.of(toLdt, ZoneId.of("Europe/Warsaw"));
               years = ChronoUnit.YEARS.between(fromLd, toLd);
               months = p.getMonths();
               daysAll = ChronoUnit.DAYS.between(fromLd, toLd);
               days = p.getDays();
               hours = ChronoUnit.HOURS.between(fromZdt, toZdt);
               minutes = ChronoUnit.MINUTES.between(fromZdt, toZdt);
               Locale none = new Locale("xx");
               weeks = String.format(none, "%.2f", ChronoUnit.DAYS.between(fromLd, toLd) / 7.0);
               if (Double.parseDouble(weeks) == 0.00) {
                   weeks = "0";
               }
               String ldtPattern = "d MMMM yyyy (EEEE) 'godz.' HH:mm";
               String fromResult = fromLdt.format(DateTimeFormatter.ofPattern(ldtPattern));
               String toResult = toLdt.format(DateTimeFormatter.ofPattern(ldtPattern));
               if (years == 1) {
                   if (months == 1) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiąc";
                           }
                       }
                   } else if (months >= 2 && months <= 4) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesiące";
                           }
                       }
                   } else if (months >= 5) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + months + " miesięcy";
                           }
                       }
                   } else if (months <= 0) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " rok";
                           }
                       }
                   }
               } else if (years >= 2 && years <= 4) {
                   if (months == 1) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiąc";
                           }
                       }
                   } else if (months >= 2 && months <= 4) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesiące";
                           }
                       }
                   } else if (months >= 5) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + months + " miesięcy";
                           }
                       }
                   } else if (months <= 0) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lata";
                           }
                       }
                   }
               } else if (years >= 5) {
                   if (months == 1) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiąc";
                           }
                       }
                   } else if (months >= 2 && months <= 4) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesiące";
                           }
                       }
                   } else if (months >= 5) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + months + " miesięcy";
                           }
                       }
                   } else if (months <= 0) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + years + " lat";
                           }
                       }
                   }
               } else if (years <= 0) {
                   if (months == 1) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiąc";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiąc, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiąc, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiąc";
                           }
                       }
                   } else if (months >= 2 && months <= 4) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiące";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiące, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiące, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesiące";
                           }
                       }
                   } else if (months >= 5) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesięcy";
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesięcy, " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesięcy, " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + months + " miesięcy";
                           }
                       }
                   } else if (months <= 0) {
                       if (daysAll == 1) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dzień, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes;
                           }
                       } else if (daysAll >= 2 || daysAll == 0) {
                           if (days == 1) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + days + " dzień";
                           } else if (days >= 2) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes + "\n - kalendarzowo: " + days + " dni";
                           } else if (days <= 0) {
                               return "Od " + fromResult + " do " + toResult + "\n - mija: " + daysAll + " dni, tygodni " + weeks + "\n - godzin: " + hours + ", minut: " + minutes;
                           }
                       }
                   }
               }
           }
           return null;
        } catch (DateTimeParseException ex) {
            if (ex.getParsedString().contains("T")){
                return "*** " +ex.toString();
            } else {
                return "*** " + firstCatch;
            }
        }
    }
}
