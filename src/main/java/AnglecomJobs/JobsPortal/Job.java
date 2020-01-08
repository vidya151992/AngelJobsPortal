package AnglecomJobs.JobsPortal;

public class Job {
	
	private String jobType;
	private String jobTitle;
	private String jobLocation;
	
	public Job(String jobType, String jobTitle, String jobLocation)
	{
		this.jobType = jobType;
		this.jobTitle = jobTitle;
		this.jobLocation = jobLocation;
		
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	
	

}
