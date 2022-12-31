import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;

public class Main {

    public static void main(String[] args) throws IOException {
        String rawData = fetchData();
        Integer sizeOfText = getSizeOfText(rawData);
        String[] fin = parseData(rawData, getSizeOfText(rawData));

        for (int i = 0; i <= 5; i++){
            System.out.println(fin[i]);
        }
    }

    public static String fetchData() throws IOException {
        URL url = new URL("https://prices.runescape.wiki/api/v1/osrs/latest");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "real time trading project - @notBrN#0540");

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String rawData = br.readLine();
        rawData = rawData.substring(9, rawData.length()-2);

        return rawData;
    }

    public static Integer getSizeOfText(String data)
    {
        int size = 0;
        for (int i = 0; i <= data.length()-1;i++) {
            if (data.charAt(i) == '}') {
                size += 1;
            }
        }
        return size;
    }

    public static String[] parseData(String data, Integer size) {
        String[] itemList = new String[size];
        itemList = data.split("},");
        return itemList;
    }


}
