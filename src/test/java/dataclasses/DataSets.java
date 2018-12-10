package dataclasses;

public class DataSets {
	
	private String firstName;
	private String lastName;
	private String avatar;
	private String userId;
	private String userJob;
	
	public void setUserFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getUserFirstName() {		
		return firstName;
	}
	
  public void setUserLastName(String lastName) {
	  this.lastName=lastName;		
	}
	
	public String getUserLastName() {		
		return lastName;
	}
	
    public void setUserAvatar(String avatar) {	
    	this.avatar=avatar;
	}
	
	public String getUserAvatar() {		
		return avatar;
	}
	
	public void setUserId(String userId) {
		this.userId=userId;
	}
	
	public String getUserId() {		
		return userId;
	}

	public void setUsersJob(String firstName) {
		this.userJob=firstName;
	}
	
	public String getUsersJob() {		
		return userJob;
	}
	
	
	public DataSets getUserFName()
	{
		String userName="George";
		setUserFirstName(userName);
		 return this;		
	}
	
	
	public DataSets createUserData()
	{
		String name="morpheus";
		String job="leader";
		setUserFirstName(name);
		setUsersJob(job);
		 return this;		
	}
	
	
	public DataSets updateUserData()
	{
		String userId="2";
		String first_name="Updated_morpheus";
		String last_name="Updated_Bluth";
		String avatar="Updated_Avater";
		
		setUserFirstName(first_name);
		setUserLastName(last_name);
		setUserAvatar(avatar);
		setUserId(userId);
		
		 return this;		
	}
	
	
	public DataSets deleteUserData()
	{
		String userId="2";
		setUserId(userId);		
		 return this;		
	}
}
