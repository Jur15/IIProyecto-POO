import java.util.Date;
import java.util.UUID;

public class Body
{
	private Date Time;
	private int XPos;
	private int YPos;
	private UUID ID;
	
	public Body(Date pVideoDate,int posX,int posY)
	{
		ID = UUID.randomUUID();
		Time = pVideoDate;
		XPos = posX;
		YPos = posY;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date pTime) {
		Time = pTime;
	}

	public int getXPos() {
		return XPos;
	}

	public void setXPos(int pXPos) {
		XPos = pXPos;
	}

	public int getYPos() {
		return YPos;
	}

	public void setYPos(int pYPos) {
		YPos = pYPos;
	}

	public UUID getID() {
		return ID;
	}

	public void setID(UUID pID) {
		ID = pID;
	}
}
