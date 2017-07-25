package game_result;

public class game_resultDTO {

	String matchday;
	String home;
	String away;
	int home_score;
	int away_score;
	String forecate;
	
	public game_resultDTO(String matchday,String home,String away,int home_score,int away_score,String forecate){
		this.matchday = matchday;
		this.home = home;
		this.away = away;
		this.home_score = home_score;
		this.away_score = away_score;
		this.forecate = forecate;
	}
	public game_resultDTO(String matchday){
		this.matchday = matchday;
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

	public int getHome_score() {
		return home_score;
	}

	public void setHome_score(int home_score) {
		this.home_score = home_score;
	}

	public int getAway_score() {
		return away_score;
	}

	public void setAway_score(int away_score) {
		this.away_score = away_score;
	}

	public String getForecate() {
		return forecate;
	}

	public void setForecate(String forecate) {
		this.forecate = forecate;
	}
	
	
}
