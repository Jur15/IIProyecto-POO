import java.io.FileWriter;
import java.io.IOException;

public class JSONParser
{
	public static void parseStringJSON(String pContent,int pVidNumber)
	{
		try (FileWriter file = new FileWriter("json\\Video"+pVidNumber+".json"))
		{
	        file.write(pContent);
	        file.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
