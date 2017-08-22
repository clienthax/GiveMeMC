package me.joezwet.gameapis.mc;

/**
 * 
 * @author JoeZwet
 *
 */
public class Player {
	String name, UUID, UUIDFormatted, skinURL;

	Player(String name, String UUID, String UUIDFormatted, String skinURL) {
		this.name = name;
		this.UUID = UUID;
		this.UUIDFormatted = UUIDFormatted;
		this.skinURL = skinURL;
	}

	public String getName() {
		return name;
	}

	public String getUUID() {
		return UUID;
	}

	public String getFormattedUUID() {
		return UUIDFormatted;
	}

	public String getSkinURL() {
		return skinURL;
	}

}
