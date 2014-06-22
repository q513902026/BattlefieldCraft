package com.ich.battlefield.core;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import com.ich.battlefield.core.OccupiedState.Ranks;

public class Flag
{
    private Material type;
    private OccupiedState occupiedState;
    private Ranks ranks;
    public Flag(ItemStack i)
    {
        this.type = i.getType();
        this.occupiedState = OccupiedState.NOT_OCCUPIED;
        this.ranks = Ranks.None;
    }
    public Material getType()
    {
        return this.type;
    }
    public void setOccupiedState(OccupiedState o)
    {
        this.occupiedState = o;
    }
    public void setRanks(Ranks r)
    {
        this.ranks =r;
    }
    public OccupiedState getOccupiedState()
    {
        return this.occupiedState;
    }
    public Ranks getRanks()
    {
        return this.ranks;
    }
}
