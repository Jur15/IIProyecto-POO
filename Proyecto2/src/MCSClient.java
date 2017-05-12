import java.util.ArrayList;

public class MCSClient implements IConstants
{
	private ArrayList<Body> Bodies;
	private JSONParser Parser;
	
	public ArrayList<String> processVideo(String pVideoURL)
	{
		ArrayList<String> postResponse = HTTPRequester.postRequest(pVideoURL);
		return postResponse;
	}
	
	private void addBodies(String pJSONResult)
	{
		//Adds each body to the arraylist
	}
	
	public ArrayList<Body> getBodies()
	{
		return Bodies;
	}
}
