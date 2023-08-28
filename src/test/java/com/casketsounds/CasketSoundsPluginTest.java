package com.casketsounds;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CasketSoundsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(CasketSoundsPlugin.class);
		RuneLite.main(args);
	}
}