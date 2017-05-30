import java.util.ArrayList;

public class VideoProcesor implements IConstants
{
	private MCSClient Client;
	private ArrayList<Body> Bodies;
	
	public VideoProcesor()
	{
		Client = new MCSClient();
	}
	
	public void processVideos()
	{
		try
		{
			int vidCount = 0;
			for(String videoURL : VIDEO_LIST)
			{
				vidCount++;
				String operation = Client.processVideo(videoURL);
				if(operation!= null)
				{
					Client.processJSON(operation, vidCount);
					createBodyArray("json\\Video"+vidCount+".json");
				}
				else
				{
					System.out.println("Error en el post");
					break;
				}
			}
		}
		catch (InterruptedException e) 
		{	
			e.printStackTrace();
		}
	}
	
	private void createBodyArray(String pJSONFile)
	{
		
	}
	
	public ArrayList<Body> getBodies()
	{
		return Bodies;
	}
}