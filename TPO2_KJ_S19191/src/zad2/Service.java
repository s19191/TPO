/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad2;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {
    final static String klucz = "925c59b6a7c5c50591681595e52ef090";
    Locale locale;
    String kraj;
    String kod;
    String waluta;
    Map<String,String> krajKod = new HashMap<>();
    Map<String,String> kodyWaluty = new HashMap<>();

    Service(String kraj) {
        this.kraj = kraj.trim().toUpperCase();
        locale = new Locale("",this.kraj);
        locale.setDefault(Locale.ENGLISH);
        String[] localTab = Locale.getISOCountries();
        for (String loc : localTab) {
            try {
                Locale tmp = new Locale("", loc);
                if (tmp.getDisplayCountry().trim().toUpperCase().equals(locale.getDisplayCountry().trim().toUpperCase())) {
                    kod = loc;
                    waluta = Currency.getInstance(tmp).getCurrencyCode();
                }
                krajKod.put(tmp.getDisplayCountry().toUpperCase(),loc);
                kodyWaluty.put(loc, Currency.getInstance(tmp).getCurrencyCode());
            } catch (NullPointerException ex) {
                //ex.printStackTrace();
                //do nothing
            }
        }
    }
    String getURLConnection(String site) throws IOException {
        try {
            StringBuilder response = new StringBuilder();
            String lineToRead;
            URL url = new URL(site);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            while ((lineToRead = br.readLine()) != null) {
                response.append(lineToRead + "\n");
            }
            br.close();
            return response.toString();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return "Nie ma takiego miasta";
        }
    }
    String getWeather(String miasto) {
        JSONObject jsonObject;
        try {
            String pogoda = "Pogoda dla: " + miasto.substring(0,1).toUpperCase() + miasto.substring(1).toLowerCase() + "\n";
            jsonObject = new JSONObject(getURLConnection("http://api.openweathermap.org/data/2.5/weather?q=" + miasto + "&appid=" + klucz));
            pogoda += "Temperatura: " + jsonObject.getJSONObject("main").getDouble("temp") + "\n";
            pogoda += "Temperatura minimalna: " + jsonObject.getJSONObject("main").getDouble("temp_min") + "\n";
            pogoda += "Temperatura maksymalna: " + jsonObject.getJSONObject("main").getDouble("temp_max") + "\n";
            pogoda += "Temperatura odczuwalna: " + jsonObject.getJSONObject("main").getDouble("feels_like") + "\n";
            pogoda += "Wilgotność: " + jsonObject.getJSONObject("main").getDouble("humidity") + "\n";
            pogoda += "Ciśnienie: " + jsonObject.getJSONObject("main").getDouble("pressure") + "\n";
            return pogoda;
        } catch (JSONException | IOException ex) {
            ex.printStackTrace();
            return "ex";
        }
    }
    Double getRateFor(String s) {
        Double kurs = 0.0;
        String podanaWaluta = s.trim().toUpperCase();
        if(podanaWaluta.equals(waluta)) {
            kurs = 1.0;
        } else {
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(getURLConnection("https://api.exchangeratesapi.io/latest?base=" + podanaWaluta + "&symbols=" + waluta));
                JSONObject kursy = new JSONObject(jsonObject.get("rates").toString());
                kurs = kursy.getDouble(waluta);
            } catch (JSONException | IOException ex) {
                //ex.printStackTrace();
                //do nothing
            }
        }
        return kurs;
    }
    Double getNBPRate() {
        Double kurs = 0.0;
        if (kraj.equals("POLAND")) {
            kurs = 1.0;
        } else {
            try {
                String strona = getURLConnection("http://www.nbp.pl/kursy/kursya.html");
                strona+= getURLConnection("http://www.nbp.pl/kursy/kursyb.html");
                Pattern p = Pattern.compile("<td class=\"bgt\\d.? right\">\\d{1,5} " + waluta + "</td>");
                Matcher m;
                String[] tab = strona.split("\n");
                for(int i=0; i<tab.length; i++) {
                    m = p.matcher(tab[i].trim());
                    if(m.matches())
                    {
                        p = Pattern.compile("(<td class=\"bgt\\d.? right\">(\\d{1,2},\\d{4})</td>)");
                        m = p.matcher(tab[i+1].trim());
//                        System.out.println(m.matches());
//                        System.out.println(m.group(1));
//                        System.out.println(m.group(2));
                        kurs = Double.parseDouble(m.group(2).replace(",","."));
                        break;
                    }
                }
            } catch (IOException ex) {
                //ex.printStackTrace();
                //do nothing
            }
        }
        return kurs;
    }
}