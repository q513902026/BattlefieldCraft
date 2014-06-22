package com.ich.battlefield.core;

public enum OccupiedState
{
    NOT_OCCUPIED(0), HALF_OCCUPIED(1), OCCUPIED(2);
    private int type;
    
    private OccupiedState(int type)
    {
        this.type = type;
    }
    public enum Ranks
    {
        None,Red,Black;
    }
}
