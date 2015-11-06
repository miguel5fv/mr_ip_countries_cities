import org.json.JSONObject;
import org.json.JSONException;
import java.net.*;
import java.io.*;

public class IpDecoder {
        public String getCity(String ip) throws Exception {
                String ipCityDetails = this.retrieveContentFromApi(ip);

                if (null != ipCityDetails) {
                        return this.retrieveCityName(ipCityDetails);
                }

                return null;
        }

        protected String retrieveContentFromApi(String ip) throws Exception {
                String urlAddress       = "http://ip-api.com/json/" + ip;
                URL url                 = new URL(urlAddress);
                String outputJson       = "";
                String line;

                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                while((line = reader.readLine()) != null)
                {
                        outputJson      += line;
                }

                return outputJson;
        }

        protected String retrieveCityName(String ipCityDetails) throws Exception {
                JSONObject jsonObject = new JSONObject(ipCityDetails);
                return jsonObject.getString("city");
        }
}
