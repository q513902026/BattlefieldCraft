package com.ich.battlefield.config;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import com.ich.battlefield.core.Area;

public class BattlefieldSetting extends PluginSetting
{
    public Set<String> battlefieldList = new HashSet<>();
    public ConfigurationSection battleListSetting;
    public ConfigurationSection battleDataSetting;
    
    public BattlefieldSetting(FileConfiguration config)
    {
        super(config);
        battleListSetting = config.getConfigurationSection("Battlefield.battlefieldList");
        battleDataSetting = config.getConfigurationSection("battlefield.battlefieldData");
    }
    
    @Override
    public void save()
    {
        // TODO 自动生成的方法存根
        
    }
    
}
