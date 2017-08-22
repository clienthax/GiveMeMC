package me.joezwet.gameapis.mc;

/**
 * 
 * @author JoeZwet
 *
 */
public class BasicServerInfo {

	String hostname;
	int port;
	Status status;
	String version;
	String motd;
	PlayerCount playercount;

	BasicServerInfo(Status status, String hostname, int port, String version, String motd, PlayerCount playercount) {
		this.hostname = hostname;
		this.port = port;
		this.status = status;
		this.version = version;
		this.motd = motd;
		this.playercount = playercount;

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

	public String getCleanMotd() {
		return motd;
	}

}
