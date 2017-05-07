import java.util.*;
import java.io.*;

public class SocNet 
{
	private DiGraph network;
	private TreeMap<User, User> userList;
	public SocNet(String filename)
	{
		network = new DiGraph();
		userList = new TreeMap<User, User>();
		try
		{
			Scanner input = new Scanner(new File(filename));
			while(input.hasNextLine())
			{
				String v = input.next();
				String w = input.next();
				boolean addedV = network.addVertex(v);
				boolean addedW = network.addVertex(w);
				network.addEdge(v, w);
				if(!addedV)
				{
					User userV = new User(v);
					userList.get(userV).follow();
				}
				else
				{
					User userV = new User(v, 0, 1);
					userList.put(userV, userV);
				}
				if(!addedW)
				{
					User userW = new User(w);
					userList.get(userW).addFollower();
				}
				else
				{
					User userW = new User(w, 1, 0);
					userList.put(userW, userW);
				}
				input.nextLine();
			}
			input.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File " + filename + " not found");
			System.out.println(e.getMessage());
		}
	}
	
}
