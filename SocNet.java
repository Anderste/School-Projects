import java.util.*;

public class SocNet 
{
	private DiGraph network;
	public SocNet(String filename)
	{
		network = new DiGraph();
		Scanner input = new Scanner(new File(filename));
		while(input.hasNextLine())
		{
			network.addVertex(input.next());
			network.addVertex(input.next());
			input.nextLine();
		}
		input.close();
	}
}
