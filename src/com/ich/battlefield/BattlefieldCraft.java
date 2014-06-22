package com.ich.battlefield;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.ich.battlefield.config.BattlefieldCommonSetting;
import com.ich.battlefield.config.BattlefieldSetting;
import com.ich.battlefield.config.PlayerDataSetting;

public class BattlefieldCraft extends JavaPlugin
{
    public static BattlefieldCraft instance;
    public BattlefieldSetting battlefieldSetting;
    public FileConfiguration battlefieldConfig;
    public BattlefieldCommonSetting battlefieldCommonSetting;
    public FileConfiguration battlefieldCommonConfig;
    public PlayerDataSetting playerDataSetting;
    public FileConfiguration playerDataConfig;
    
    @Override
    public void onEnable()
    {
        instance = this;
        loadSetting();
    }
    
    @Override
    public void onDisable()
    {
        instance = null;
    }
    
    private void loadSetting()
    {
        this.saveDefaultConfig();
        battlefieldCommonConfig = this.getConfig();
        battlefieldCommonSetting = new BattlefieldCommonSetting(battlefieldCommonConfig);
        
        saveCustomResource("battlefield");
        battlefieldConfig = this.getFileData("battlefield");
        battlefieldSetting = new BattlefieldSetting(battlefieldConfig);
        
        saveCustomResource("playerdata");
        playerDataConfig = this.getFileData("playerdata");
        playerDataSetting = new PlayerDataSetting(playerDataConfig);
    }
    
    public FileConfiguration getFileData(String name)
    {
        FileConfiguration data = new YamlConfiguration();
        File dataFile = new File(this.getDataFolder(), name + ".yml");
        if (!dataFile.exists())
        {
            try
            {
                dataFile.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            data.load(dataFile);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return data;
    }
    public void saveCustomResource(String name)
    {
        File configFile = new File(this.getDataFolder(), name + ".yml");
        if (!configFile.exists())
        {
            saveResource(name + ".yml", false);
        }
    }
}
