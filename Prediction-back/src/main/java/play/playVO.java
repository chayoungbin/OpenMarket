package play;

public class playVO {

	String matchday;
	String home;
	String away;
	String prediction;
	
	public playVO(String matchday,String home,String away,String prediction){
		this.matchday = matchday;
		this.home = home;
		this.away = away;
		this.prediction = prediction;
	}

	public String getMatchday() {
		return matchday;
	}

	public void setMatchday(String matchday) {
		this.matchday = matchday;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAway() {
		return away;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public String getPrediction() {
		return prediction;
	}

	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}
	
	
}
