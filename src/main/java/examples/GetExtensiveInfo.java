package examples;

import java.io.IOException;

import org.json.JSONException;

import me.joezwet.gameapis.mc.ExtensiveServerInfo;
import me.joezwet.gameapis.mc.GiveMeMC;
import me.joezwet.gameapis.mc.Player;
import me.joezwet.gameapis.mc.exceptions.QueryDisabledException;
import me.joezwet.gameapis.mc.exceptions.ServerConnectionException;

public class GetExtensiveInfo {

	public static void main(String[] args) {
		// initialize the api
		GiveMeMC api = new GiveMeMC();
		try {
			// get the ExtensiveServerInfo object
			ExtensiveServerInfo info = api.getExtensiveServerInfo("localhost:25565");

			// Print info
			System.out.print(
					info.getFullHostname() + "\n" + info.getCleanMotd() + "\n" + info.getPlayerCount().getOnline() + "/"
							+ info.getPlayerCount().getMax() + info.getSoftwhere() + "\n");

			// Print player info for each player online
			System.out.println("=== ONLINE PLAYERS ===");
			for (Player p : info.getPlayers()) {
				System.out.println(p.getName() + "[" + p.getFormattedUUID() + "] - " + p.getSkinURL());
			}

			// Spacer
			System.out.println("");

			// Print plugin names
			System.out.println("=== PLUGINS ===");
			for (String s : info.getPlugins()) {
				System.out.println(s);
			}

		} catch (JSONException | IOException | ServerConnectionException | QueryDisabledException e) {
			e.printStackTrace();
		}
	}

}
