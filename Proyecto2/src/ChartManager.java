import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class ChartManager
{
	public String generateGraph(GraphType pType,ArrayList<Body> pBodies)
	{
		String graphHTML = "Crowly-"+UUID.randomUUID();
		if(pType == GraphType.SCATTER)
		{
			
		}
		else if(pType == GraphType.BAR)
		{
			
		}
		else
		{
			
		}
		return graphHTML;
	}
	
	public void openBrowser(String pFilepath)
	{
		File htmlFile = new File(pFilepath);
		try
		{
			Desktop.getDesktop().browse(htmlFile.toURI());
		}
		catch (IOException e)
		{
			System.out.println("Error while opening html file");
		}
	}
}
