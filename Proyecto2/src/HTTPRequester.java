import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class HTTPRequester
{
	private final static String USER_AGENT = "Mozilla/5.0";
	
	public static String postMalo(String pURL,String pPayload) throws Exception
	{
		URL url = new URL(pURL);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		
		connection.setRequestMethod("POST");
		connection.setRequestProperty("User-Agent", USER_AGENT);
		connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		connection.setDoOutput(true);
		DataOutputStream conOut = new DataOutputStream(connection.getOutputStream());
		conOut.writeBytes(pPayload);
		conOut.flush();
		conOut.close();
		
		int responseCode = connection.getResponseCode();
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader conIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = conIn.readLine()) != null) {
			response.append(inputLine);
		}
		conIn.close();
		
		return response.toString();
	}
	
	public static ArrayList<String> postRequest(String pVideoURL)
    {
		ArrayList<String> valuesResponse = new ArrayList<String>();
		
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion");

            builder.setParameter("sensitivityLevel", "low");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "8e0aec20a0d045e8a30b5031829753f2");

            StringEntity reqEntity = new StringEntity("{\"url\":\""+pVideoURL+"\"}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            valuesResponse.add(response.getFirstHeader("Operation-Location").getValue());
            valuesResponse.add(response.getFirstHeader("apim-request-id").getValue());

            HttpEntity entity = response.getEntity();
            if (entity != null) 
            {
                System.out.println(EntityUtils.toString(entity));
            }
            
            return valuesResponse;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
