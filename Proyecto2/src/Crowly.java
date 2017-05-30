import java.util.Scanner;

public class Crowly
{
	private VideoProcesor vidProc;
	private ChartManager chartMgr;
	
	public Crowly()
	{
		vidProc = new VideoProcesor();
		chartMgr = new ChartManager();
	}
	
	public void run()
	{
		vidProc.processVideos();
		Scanner graphOption = new Scanner(System.in);
		String graphFile;
		int selectedOption = 0;
		while(selectedOption != 0)
		{
			System.out.println("Select an option: 1-Scatter, 2-Bar, 3-Line, 4-Exit	");
			selectedOption = graphOption.nextInt();
			switch(selectedOption)
			{
				case 1: graphFile = chartMgr.generateGraph(GraphType.SCATTER, vidProc.getBodies());
						chartMgr.openBrowser(graphFile);
						break;
				case 2: graphFile = chartMgr.generateGraph(GraphType.BAR, vidProc.getBodies());
						chartMgr.openBrowser(graphFile);
						break;
				case 3: graphFile = chartMgr.generateGraph(GraphType.LINE, vidProc.getBodies());
						chartMgr.openBrowser(graphFile);
				default:break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Crowly program = new Crowly();
		program.run();
	}

}
