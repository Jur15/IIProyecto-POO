import java.util.ArrayList;

public class VideoProcesor implements IConstants
{
	private MCSClient Client;
	private ArrayList<Body> AllBodies;
	private ArrayList<String> VideoResponses;
	
	public VideoProcesor()
	{
		Client = new MCSClient();
	}
	
	public void processVideos()
	{
		try
		{
			for(String video : VIDEO_LIST)
			{
				VideoResponses.addAll(Client.processVideo(video));
				Thread.sleep(1);
				//AllBodies.addAll(Client.getBodies());
			}
		}
		catch (InterruptedException e) 
		{	
			e.printStackTrace();
		}
	}
	
	public String getResult()
	{
		return "";
	}
}
