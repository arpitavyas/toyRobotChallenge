package com.example.toyRobotChallenge.game;

import java.util.HashMap;
import java.util.Map;

public enum Facing {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    private static Map<Integer, Facing> map = new HashMap<Integer, Facing>();
    private int facingIndex;

     Facing(int index) {
        this.facingIndex = index;
    }

    static {
        for (Facing facingEnum : Facing.values()) {
            map.put(facingEnum.facingIndex, facingEnum);
        }
    }

    public static Facing valueOf(int facing) {
        return map.get(facing);
    }

//    rotate robot facing based on index
    public Facing rotate(int step) {
        int newIndex = (this.facingIndex + step) < 0 ?
                map.size() - 1 :
                (this.facingIndex + step) % map.size();

        return Facing.valueOf(newIndex);
    }
}
