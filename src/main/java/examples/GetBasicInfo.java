package examples;

import java.io.IOException;

import org.json.JSONException;

import me.joezwet.gameapis.mc.BasicServerInfo;
import me.joezwet.gameapis.mc.GiveMeMC;
import me.joezwet.gameapis.mc.exceptions.ServerConnectionException;

public class GetBasicInfo {

	public static void main(String[] args) {
		// initialize the api
		GiveMeMC api = new GiveMeMC();
		try {
			// get the BasicServerInfo object
			BasicServerInfo info = api.getServerInfo("localhost:25565");

			// Print info
			System.out.print(info.getFullHostname() + "\n" + info.getCleanMotd() + "\n"
					+ info.getPlayerCount().getOnline() + "/" + info.getPlayerCount().getMax());

		} catch (JSONException | IOException | ServerConnectionException e) {
			e.printStackTrace();
		}
	}
}
