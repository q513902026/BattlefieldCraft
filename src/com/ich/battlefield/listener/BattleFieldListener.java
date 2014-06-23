package com.ich.battlefield.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.ich.battlefield.BattlefieldCraft;

public class BattleFieldListener implements Listener
{
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        
        Player aPlayer = e.getEntity();
        boolean state = BattlefieldCraft.instance.playerDataSetting.inBattlefieldGame(aPlayer.getName());
        if(!state)
        {
            return;
        }
        e.setKeepLevel(true);
        

    }
}
