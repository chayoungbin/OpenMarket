package team_record;

public class team_recordVO {

	String club_name;
	int streak;
	int total;
	int win;
	int draw;
	int lose;
	
	public team_recordVO(){}
	
	public team_recordVO(String club_name,int streak,int total,int win,int draw,int lose){
		this.club_name = club_name;
		this.streak = streak;
		this.total = total;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public int getStreak() {
		return streak;
	}

	public void setStreak(int streak) {
		this.streak = streak;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}
	
}
