package team;

public class teamDTO {

	int rank;
	String club_name;
	double win;
	int score_s;
	int score_f;
	double win_rate;
	
	public teamDTO(int rank,String club_name,double win,int score_s,int score_f){
		this.rank = rank;
		this.club_name = club_name;
		this.win = win;
		this.score_s = score_s;
		this.score_f = score_f;
	}
	
	public teamDTO(){}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public double getWin() {
		return win;
	}

	public void setWin(double win) {
		this.win = win;
	}

	public int getScore_s() {
		return score_s;
	}

	public void setScore_s(int score_s) {
		this.score_s = score_s;
	}

	public int getScore_f() {
		return score_f;
	}

	public void setScore_f(int score_f) {
		this.score_f = score_f;
	}

	public double getWin_rate() {
		return win_rate;
	}

	public void setWin_rate(double win_rate) {
		this.win_rate = win_rate;
	}
	
	
}
