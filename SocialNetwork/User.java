public class User implements Comparable<User>
{
	private int followers;
	private int following;
	private String name;
	public User(String name, int numFollowers, int numFollowing)
	{
		this.name = name;
		followers = numFollowers;
		following = numFollowing;
	}
	public User(String name)
	{
		this.name = name;
		followers = 0;
		following = 0;
	}
	@Override
	public int compareTo(User aUser)
	{
		if(name.equals(aUser.getName()))
			return 0;
		if(followers > aUser.getFollowers())
			return 1;
		if(followers < aUser.getFollowers())
			return -1;
		if(following > aUser.getFollowing())
			return -1;
		if(following < aUser.getFollowing())
			return 1;
		return -1;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof User)
		{
			User temp = (User) obj;
			return name.equals(temp.getName());
		}
		return false;
	}
	public void addFollower()
	{
		followers++;
	}
	public void follow()
	{
		following++;
	}
	public String getName()
	{
		return name;
	}
	public int getFollowers()
	{
		return followers;
	}
	public int getFollowing()
	{
		return following;
	}
}
