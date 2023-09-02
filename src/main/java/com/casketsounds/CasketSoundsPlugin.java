package com.casketsounds;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.InventoryID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;

import java.util.concurrent.ScheduledExecutorService;

@Slf4j
@PluginDescriptor(
	name = "Casket Sounds"
)
public class CasketSoundsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private CasketSoundsConfig config;

	@Inject
	private SoundEngine soundEngine;

	@Inject
	private ScheduledExecutorService executor;

	@Inject
	private OkHttpClient okHttpClient;

	@Override
	protected void startUp() throws Exception
	{
		executor.submit(() -> {
			FileManager.ensureDownloadDirectoryExists();
			FileManager.downloadAllMissingSounds(okHttpClient);
		});

		log.info("CasketSounds started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		soundEngine.close();
		log.info("CasketSounds stopped!");
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage) {
		if (chatMessage.getType() == ChatMessageType.MESBOX && chatMessage.getMessage().toLowerCase().contains("casket")) {
			int whichSound = (Math.random() <= 0.5) ? 1 : 2;

			if(whichSound == 1)
			{
				soundEngine.playClip(Sound.CASKET);
			}
			else
			{
				soundEngine.playClip(Sound.CASKET2);
			}
		}
	}

	@Provides
	CasketSoundsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CasketSoundsConfig.class);
	}
}
