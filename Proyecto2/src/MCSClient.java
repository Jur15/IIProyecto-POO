public class MCSClient implements IConstants
{
	public String processVideo(String pVideoURL) throws InterruptedException
	{
		String videoResponse = HTTPRequester.postRequest(pVideoURL, SUBSCRIPTION_KEY);
		if(videoResponse != null)
		{
			System.out.println("Post hecho");
			return videoResponse;
		}
		else
		{
			System.out.println("Error post request");
			return null;
		}
	}
	
	public void processJSON(String pOperLocation,int pVidNumber) throws InterruptedException
	{
		String operResult = null;
		while(true)
		{
			operResult = HTTPRequester.getOperationResult(pOperLocation, SUBSCRIPTION_KEY);
			System.out.println(operResult);
			if(operResult.contains("Succeeded") || operResult.contains("Failed") || operResult.contains("error"))
				break;
			Thread.sleep(WAIT_BETWEEN_RESULT_REQUEST);
		}
		if(operResult.contains("Succeeded"))
		{
			System.out.println("Contenido JSON obtenido");
			//String jsonContent = jsonContent.substring(beginIndex)
			//JSONParser.parseStringJSON(jsonContent, pVidNumber);
		}
		else
			System.out.println("Fallo en operacion");
	}
}