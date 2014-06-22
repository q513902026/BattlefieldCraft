package com.ich.battlefield.config;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

public class PlayerDataSetting extends PluginSetting
{
    public Map<String,String> playerInBattlefield = new HashMap<String,String>();
    public Map<String,Integer> playerInBattlefieldPoint = new HashMap<String,Integer>();
    public PlayerDataSetting(FileConfiguration config)
    {
        super(config);
    }

    public void save()
    {
        
    }
}
