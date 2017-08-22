package me.joezwet.gameapis.mc;

/**
 * 
 * @author JoeZwet
 *
 */
public class PlayerCount {

	private int maxPlayers;
	private int onlinePlayers;

	PlayerCount(int online, int max) {
		maxPlayers = max;
		onlinePlayers = online;
	}

	public int getMax() {
		return maxPlayers;
	}

	public int getOnline() {
		return onlinePlayers;
	}

}
