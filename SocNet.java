import java.util.*;
import java.io.*;

public class SocNet 
{
	private DiGraph network;
	private ArrayList<User> userList;
	public SocNet(String filename)
	{
		network = new DiGraph();
		userList = new ArrayList<User>();
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
					int i = userList.indexOf(userV);
					userList.get(i).follow();
				}
				else
				{
					User userV = new User(v, 0, 1);
					userList.add(userV);
				}
				if(!addedW)
				{
					User userW = new User(w);
					int i = userList.indexOf(userW);
					userList.get(i).addFollower();
				}
				else
				{
					User userW = new User(w, 1, 0);
					userList.add(userW);
				}
				input.nextLine();
			}
			input.close();
			// I am paying for a sort here in order to make top follower
			// constant I also avoid the complicated way i would have
			// to find this using the graph. Also since we are only
			// making this once I only need to pay for sorting it once
			userList.sort(null);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File " + filename + " not found");
			System.out.println(e.getMessage());
		}
	}
	public String topFollower()
	{
	 	return userList.get(userList.size()-1).getName();
	}
	public String mostPopular()
	{
		User mPU = userList.get(0);
		for(int i = 1; i < userList.size(); i++)
		{
			User u = userList.get(i);
			if(u.getFollowers() > mPU.getFollowers())
				mPU = u;
		}
		return mPU.getName();
	}
	
}
