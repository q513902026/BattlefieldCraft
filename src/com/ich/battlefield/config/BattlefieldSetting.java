package com.ich.battlefield.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import com.ich.battlefield.core.Area;

public class BattlefieldSetting extends PluginSetting
{
    
    /**
     *  以战场的名称为key 以这个战场是否开始为Value
     */
    public HashMap<String,Boolean> battlefieldList = new HashMap<>();
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
        
    }

    /**
     * @param string 战场的名字
     * @return 这个战场是否开始
     */
    public boolean isBattlefield(String string)
    {
        if(!(this.battlefieldList.containsKey(string)))
        {
            return false;
        }
        return battlefieldList.get(string);
    }
    
}
