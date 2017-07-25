package relative;

public class relativeDTO {

	String home;
	String away;
	int win;
	int lose;
	int tie;
	public relativeDTO(){
		
	}
	public relativeDTO(String home,String away){
		this.home = home;
		this.away = away;
	}
	public relativeDTO(String home,String away,int win,int lose,int tie){
		this.home = home;
		this.away = away;
		this.win = win;
		this.lose = lose;
		this.tie = tie;
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

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getTie() {
		return tie;
	}

	public void setTie(int tie) {
		this.tie = tie;
	}
	
	
}
