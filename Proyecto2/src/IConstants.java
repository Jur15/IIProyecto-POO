
public interface IConstants
{
	public final String POST_BODY = "HTTP/1.1 "+
            "Content-Type: application/json\n"+
            "Host: westus.api.cognitive.microsoft.com\n"+
            "Ocp-Apim-Subscription-Key: 8e0aec20a0d045e8a30b5031829753f2\n"+
            "{ \"url\":\"@@URL@@\" } ";
	public final String MCS_URL = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion";
	
	public final String[] VIDEO_LIST = {"https://drive.google.com/file/d/0Bz6E4YKgL2v_T2lfbzFfOUlLcEk/"};
	public final int WAIT_BETWEEN_VID = 1000*60;
}
