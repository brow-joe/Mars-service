package br.com.jonathan.machine.domain.robot;

import br.com.jonathan.machine.application.exceptions.InvalidPositionException;
import br.com.jonathan.machine.domain.enumeration.DirectionEnum;
import br.com.jonathan.machine.domain.service.action.Action;

import java.util.function.Function;

public class MachineDomain {

    private Integer x;
    private Integer y;
    private DirectionEnum direction;

    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;
    private static final int MAX_X = 5;
    private static final int MAX_Y = 5;

    public MachineDomain() {
        this(0, 0, DirectionEnum.NORTH);
    }

    public MachineDomain(int x, int y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public void increaseX() {
        x++;
    }

    public void increaseY() {
        y++;
    }

    public void decreaseX() {
        x--;
    }

    public void decreaseY() {
        y--;
    }

    private boolean isValid() {
        return inRange(x, MIN_X, MAX_X) && inRange(y, MIN_Y, MAX_Y);
    }

    private boolean inRange(int value, int min, int max) {
        return min <= value && value <= max;
    }

    public String move(String command, Function<Character, Action> function) {
        command.toUpperCase().chars()
            .forEach(action -> {
                function.apply((char) action)
                    .execute(this);
            });
        return toString();
    }

    @Override
    public String toString() {
        if (isValid()) {
            return String.format("(%d, %d, %c)", x, y, direction.getCode());
        } else {
            throw new InvalidPositionException();
        }
    }

}
