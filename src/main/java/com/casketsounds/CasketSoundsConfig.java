package com.casketsounds;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("CasketSounds")
public interface CasketSoundsConfig extends Config
{
	@Range(
		min = 0,
		max = 200
	)
	@ConfigItem(
		keyName = "announcementVolume",
		name = "Casket Sounds volume",
		description = "Adjust how loud the sounds are played.",
		position = 0
	)
	default int announcementVolume() {
		return 100;
	}
}
