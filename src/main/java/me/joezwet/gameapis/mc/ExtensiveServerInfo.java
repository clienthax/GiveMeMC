package me.joezwet.gameapis.mc;

import java.util.List;

/**
 * 
 * @author JoeZwet
 *
 */
public class ExtensiveServerInfo {

	String hostname;
	int port;
	Status status;
	String software;
	String gameType;
	String gameName;
	String motd;
	String map;
	PlayerCount playercount;
	List<Player> players;
	List<String> plugins;

	ExtensiveServerInfo(Status status, String hostname, int port, String software, String gameType, String gameName,
			String motd, String map, PlayerCount playercount, List<Player> players, List<String> list) {
		this.hostname = hostname;
		this.port = port;
		this.status = status;
		this.software = software;
		this.gameType = gameType;
		this.gameName = gameName;
		this.motd = motd;
		this.map = map;
		this.playercount = playercount;
		this.players = players;
		this.plugins = list;
	}

	public PlayerCount getPlayerCount() {
		return playercount;
	}

	public String getHostname() {
		return hostname;
	}

	public int getPort() {
		return port;
	}

	public String getFullHostname() {
		return hostname + ":" + port;
	}

	public Status getStatus() {
		return status;
	}

	public String getSoftwhere() {
		return software;
	}

	public String getGameType() {
		return gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public String getCleanMotd() {
		return motd;
	}

	public String getWorldName() {
		return map;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<String> getPlugins() {
		return plugins;
	}

}
