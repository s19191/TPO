/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad2;

import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

import javax.sound.sampled.FloatControl;
import java.io.BufferedReader;
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
    String kraj;
    String skrot;
    Locale locale;
    Map<String,String> countryCourrency = new HashMap<>();
    Service(String kraj) {
        this.kraj = kraj;
        locale = new Locale("",kraj);
        locale.setDefault(Locale.ENGLISH);
        for (String loc : Locale.getISOCountries()) {
            try {
                Locale tmp = new Locale("", loc);
                countryCourrency.put(tmp.getDisplayCountry(), Currency.getInstance(tmp).getCurrencyCode());
            } catch (NullPointerException ex) {
                //do nothing
            }
        }
        skrot = locale.getDisplayCountry();
    }
    String getURLConnection(String site) throws IOException {
        //int responseCode = 0;
        StringBuilder response = new StringBuilder();
        String lineToRead;
        URL url = new URL(site);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setRequestMethod("GET");
        //responseCode = httpCon.getResponseCode();
        BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
        while ((lineToRead = br.readLine()) != null) {
            response.append(lineToRead+"\n");
        }
        br.close();
        return response.toString();
    }
    String getWeather(String city) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(getURLConnection("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+"59045bb3edb0ac8183aee91bb2c18ee9"));
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
    Double getRateFor(String currency) {
        if(countryCourrency.get(locale.getDisplayCountry()).equals(currency))
            return 1D;
        else
        {
            JSONObject object = null;
            Double wynik = 0.0;
            try {
                object = new JSONObject(getURLConnection("https://api.exchangeratesapi.io/latest?symbols=PLN,"+currency));
                JSONObject rates = new JSONObject(object.get("rates").toString());
                wynik = Double.parseDouble(rates.get(countryCourrency.get(locale.getDisplayCountry())).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return wynik;
        }
    }
    Double getNBPRate() {
        String xml = null;
        try {
            xml = getURLConnection("http://www.nbp.pl/kursy/kursya.html");
            xml+= getURLConnection("http://www.nbp.pl/kursy/kursyb.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tab = xml.split("\n");

        Pattern p = Pattern.compile(">(d+ "+countryCourrency.get(locale.getDisplayCountry())+")<");
        Matcher m;
        double rate=-1;
        for(int i=0; i<tab.length; i++)
        {
            m = p.matcher(tab[i]);
            if(m.matches())
            {
                p=Pattern.compile(">(.+)<");
                m = p.matcher(tab[i+1]);
                rate=Double.parseDouble(m.group(1));
                break;
            }
        }
        return rate;
    }
}