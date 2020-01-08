package AnglecomJobs.JobsPortal;

public class CompanyPageObjects {
  @FindBy(how = How.XPATH , using = "//div[@class='jobList_9cc29']/div/div/a/div[1]/h6")
	public  List<WebElement> jobType;
	
	@FindBy(how = How.TAG_NAME , using = "h4")
	public  List<WebElement> jobTitle;
	
	@FindBy(how = How.XPATH , using = "//div[@class='jobList_9cc29']/div/div/div[1]/div/div/span")
	public  List<WebElement> jobLocation;*/
	
	private  String xpathOfCompanyNames = "//a[contains(text(),'companyName')]";
	

}
