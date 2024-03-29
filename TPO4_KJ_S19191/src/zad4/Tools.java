/**
 *
 *  @author Kwasowski Jan S19191
 *
 */

package zad4;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Tools {

    static Options createOptionsFromYaml(String fileName) throws Exception {
        // tu mi nadal nie działa mądrzejsza kwestia

//        Yaml yaml = new Yaml();
//        InputStream inputStream = Options.class.getClass()
//                .getClassLoader()
//                .getResourceAsStream(fileName);
//        Options result = yaml.load(inputStream);
//        System.out.println(result);
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(fileName);
        Map map = (Map) yaml.load(inputStream);
        String host = map.get("host").toString();
        int port = Integer.parseInt(map.get("port").toString());
        boolean concurMode = (boolean) map.get("concurMode");
        boolean showSendRes = (boolean) map.get("showSendRes");
        Map<String, List<String>> clientsMap = (Map<String, List<String>>) map.get("clientsMap");
        Options result = new Options(host,port,concurMode,showSendRes,clientsMap);
        return result;
    }
}