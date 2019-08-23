package br.com.jonathan.machine.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum DirectionEnum {

    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private final int value;
    private final char code;

    private DirectionEnum(int value, char code) {
        this.value = value;
        this.code = code;
    }

    private static final Map<Integer, DirectionEnum> VALUE_MAP = new HashMap();

    static {
        for (DirectionEnum direction : values())
            VALUE_MAP.put(direction.getValue(), direction);
    }

    public int getValue() {
        return value;
    }

    public char getCode() {
        return code;
    }

    public static DirectionEnum getByValue(Integer value) {
        return VALUE_MAP.get(value);
    }

}
