import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;



public class HTTPRequester
{
	public static String postRequest(String pVideoURL,String pMSKey)
    {
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion");

            builder.setParameter("sensitivityLevel", "low");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", pMSKey);
            
            StringEntity reqEntity = new StringEntity("{\"url\":\""+pVideoURL+"\"}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            if(reqEntity != null)
            	return response.getFirstHeader("Operation-Location").getValue();
        }
        catch (Exception e)
        {
            System.out.println("Excepcion: ");
            e.printStackTrace();
        }
        return null;
    }
	
	public static String getOperationResult(String pResultURL,String pMSKey)
    {
        HttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder(pResultURL);

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", pMSKey);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null)
            {
            	InputStream entityContent = entity.getContent();
                Scanner s = new Scanner(entityContent).useDelimiter("\\A");
                String res = s.hasNext() ? s.next() : "";
            	return res;
            }
        }
        catch (Exception e)
        {
            System.out.print("Excepcion: ");
            e.printStackTrace();
        }
        return null;
    }
}