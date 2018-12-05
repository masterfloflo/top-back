package dev.top.entities;

public class Avis {
	public enum Action {AIMER, DETESTER};
	private Action action;
	
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
}
