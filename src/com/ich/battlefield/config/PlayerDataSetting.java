package com.ich.battlefield.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.ich.battlefield.BattlefieldCraft;

public class PlayerDataSetting extends PluginSetting
{
    /**
     * Key:玩家名称 Value: 玩家所处于的战场 null或者""为无战场
     */
    private Map<String, String> playerInBattlefield = new HashMap<String, String>();
    /**
     * Key:玩家名称 Value:玩家当前拥有的荣誉值
     */
    private Map<String, Integer> playerInBattlefieldPoint = new HashMap<String, Integer>();
    public ConfigurationSection playerDataSetting;
    public ConfigurationSection ranksDataSetting;
    
    public PlayerDataSetting(FileConfiguration config)
    {
        super(config);
        playerDataSetting = config.getConfigurationSection("Battlefield.playerData");
        ranksDataSetting = config.getConfigurationSection("Battlefield.ranksData");
    }
    public ArrayList<String> getRanks(Player blueLeader)
    {
        String rankName = playerDataSetting.getString(blueLeader.getName() + "rank", null);
        boolean state = rankName == null ? false : ranksDataSetting.getKeys(false).contains(rankName);
        if (!state)
        {
            return null;
        }
        return (ArrayList<String>) ranksDataSetting.getList(rankName);
    }
    public void save()
    {
    }
    /**
     * @param name
     *            玩家的名称
     * @return 是否处于正在开始的战场游戏中
     */
    public boolean inBattlefieldGame(String name)
    {
        return BattlefieldCraft.instance.battlefieldSetting.isBattlefield(playerInBattlefield.get(name));
    }
}
