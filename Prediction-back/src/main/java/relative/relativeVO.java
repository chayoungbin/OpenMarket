package relative;

public class relativeVO {

	String home;
	String away;
	int win;
	int lose;
	int tie;
	
	public relativeVO(String home,String away,int win,int lose,int tie){
		this.home = home;
		this.away = away;
		this.win = win;
		this.lose = lose;
		this.tie = tie;
	}
	public relativeVO(String home,String away){
		this.home = home;
		this.away = away;
	}

	public String getTeam1() {
		return home;
	}

	public void setTeam1(String team1) {
		this.home = team1;
	}

	public String getTeam2() {
		return away;
	}

	public void setTeam2(String team2) {
		this.away = team2;
	}

	public int getTeam1_win() {
		return win;
	}

	public void setTeam1_win(int team1_win) {
		this.win = team1_win;
	}

	public int getTeam2_win() {
		return lose;
	}

	public void setTeam2_win(int team2_win) {
		this.lose = team2_win;
	}

	public int getTie() {
		return tie;
	}

	public void setTie(int tie) {
		this.tie = tie;
	}
	
	
}
