package model;

import java.util.Date;

public class SMS {

	private int nummer;
	private String text;
	private boolean incommingSms;
	private Date time;

	public SMS(String text, int nummer, boolean incommingSms) {
		this.setText(text);
		this.setNummer(nummer);
		this.setIncommingSms(incommingSms);
		setTime(new Date());
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getNummer() {
		return nummer;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setIncommingSms(boolean incommingSms) {
		this.incommingSms = incommingSms;
	}

	public boolean isIncommingSms() {
		return incommingSms;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

}
