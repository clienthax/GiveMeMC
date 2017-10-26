package me.joezwet.gameapis.mc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import me.joezwet.gameapis.mc.exceptions.QueryDisabledException;
import me.joezwet.gameapis.mc.exceptions.ServerConnectionException;

/**
 * 
 * @author JoeZwet
 *
 */
public class GiveMeMC {

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public ExtensiveServerInfo getExtensiveServerInfo(String hostname)
			throws JSONException, IOException, ServerConnectionException, QueryDisabledException {
		JSONObject serverObject = readJsonFromUrl("https://use.gameapis.net/mc/query/extensive/" + hostname);
		if (serverObject.getBoolean("status")) {
			ArrayList<Player> players = new ArrayList<Player>();
			ArrayList<String> plugins = new ArrayList<String>();

			serverObject.getJSONArray("list").forEach((s) -> {
				try {
					JSONObject p = readJsonFromUrl("https://use.gameapis.net/mc/player/profile/" + s);
					players.add(new Player(p.getString("name"), p.getString("id"), p.getString("uuid_formatted"),
							p.getJSONObject("properties_decoded").getJSONObject("textures").getJSONObject("SKIN")
									.getString("url")));
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			serverObject.getJSONArray("plugins").forEach((s) -> {
				plugins.add((String) s);
			});

			return new ExtensiveServerInfo(Status.ONLINE, serverObject.getString("hostname"),
					serverObject.getInt("port"), serverObject.getString("software"),
					serverObject.getString("game_type"), serverObject.getString("game_name"),
					serverObject.getJSONObject("motd").getString("clean"), serverObject.getString("map"),
					new PlayerCount(serverObject.getJSONObject("players").getInt("online"),
							serverObject.getJSONObject("players").getInt("max")),
					players, plugins);
		} else {
			if (serverObject.getString("error").equalsIgnoreCase("Failed to parse server's response")) {
				throw new QueryDisabledException(
						"enable-query is set to false in the server.properties file (or config.yml file for BungeeCord servers).");
			} else {
				throw new ServerConnectionException(serverObject.getString("error"));
			}
		}
	}

	public BasicServerInfo getServerInfo(String hostname) throws JSONException, IOException, ServerConnectionException {
		JSONObject serverObject = readJsonFromUrl("https://use.gameapis.net/mc/query/info/" + hostname);
		if (serverObject.getBoolean("status")) {

			return new BasicServerInfo(Status.ONLINE, serverObject.getString("hostname"), serverObject.getInt("port"),
					serverObject.getString("version"), serverObject.getJSONObject("motd").getString("clean"),
					new PlayerCount(serverObject.getJSONObject("players").getInt("online"),
							serverObject.getJSONObject("players").getInt("max")));
		} else {
			throw new ServerConnectionException(serverObject.getString("error"));
		}
	}

	public Player getPlayerInfo(String uuid) throws JSONException, IOException, ServerConnectionException {
		JSONObject p = readJsonFromUrl("https://use.gameapis.net/mc/player/profile/" + uuid);

		return new Player(p.getString("name"), p.getString("id"), p.getString("uuid_formatted"),
				p.getJSONObject("properties_decoded").getJSONObject("textures").getJSONObject("SKIN").getString("url"));
	}
}
