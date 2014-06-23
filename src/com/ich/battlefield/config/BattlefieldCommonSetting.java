package com.ich.battlefield.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import com.ich.battlefield.BattlefieldCraft;

public class BattlefieldCommonSetting extends PluginSetting
{
    public ConfigurationSection commandSetting;
    private ConfigurationSection langSetting;
    public BattlefieldCommonSetting(FileConfiguration config)
    {
        super(config);
        langSetting = config.getConfigurationSection("BattlefieldCommon.langSetting");
        commandSetting = config.getConfigurationSection("BattlefieldCommon.commandSetting");
    }
    
    public String getDefLanguager(String path,String def)
    {
        return langSetting.getString(path, def);
    }
    public String getMainCommandUsage()
    {
        return commandSetting.getString("usage", "/<BattlefieldCraft|battle> [子命令]");
    }
    public String getMainCommandDescription()
    {
        return commandSetting.getString("description", "使用此命令来操作battle插件");
    }
    public String getCommandUsage(String commandName)
    {
        return commandSetting.getString(commandName + ".usage", "/<BattlefieldCraft|battle> <" + commandName + "> [参数[ ...]]");
    }
    public String getCommandDescription(String commandName)
    {
        return commandSetting.getString(commandName + ".description", "battle插件" + commandName + "指令");
    }
    public String getCommandPermission(String commandName)
    {
        return commandSetting.getString(commandName + ".permission", "");
    }
    public String getCommandPermissionMessage(String commandName)
    {
        return commandSetting.getString(commandName + ".permission-message", "");
    }

    public void save()
    {
        BattlefieldCraft.instance.saveConfig();
        BattlefieldCraft.instance.reloadConfig();
    }
}
