package mars_rover;

import java.util.Objects;

public class Rover {

    private Direction directionType;
    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.setDirection(direction);
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {
                rotateLeft();
            }

            if (command.equals("r")) {
                rotateRight();
            }

            if (command.equals("f")) {
                moveForwards();
            }

            if (command.equals("b")) {
                moveBackwards();
            }
        }
    }

    private void rotateRight() {
        if (faceNorth()) {
            setDirection("E");
        } else if (faceSouth()) {
            setDirection("W");
        } else if (faceWest()) {
            setDirection("N");
        } else  {
            setDirection("S");
        }
    }

    private boolean faceWest() {
        return getDirection().equals("W");
    }

    private boolean faceSouth() {
        return getDirection().equals("S");
    }

    private boolean faceNorth() {
        return getDirection().equals("N");
    }

    private void rotateLeft() {
        if (faceNorth()) {
            setDirection("W");
        } else if (faceSouth()) {
            setDirection("E");
        } else if (faceWest()) {
            setDirection("S");
        } else  {
            setDirection("N");
        }
    }

    private void moveBackwards() {
        int displacement = -1;
        move(displacement);
    }

    private void moveForwards() {
        int displacement = 1;
        move(displacement);
    }

    private void move(int displacement) {
        if (faceNorth()) {
            y += displacement;
        } else if (faceSouth()) {
            y -= displacement;
        } else if (faceWest()) {
            x -= displacement;
        } else  {
            x += displacement;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return y == rover.y &&
                x == rover.x &&
                directionType == rover.directionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directionType, y, x);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "directionType=" + directionType +
                ", y=" + y +
                ", x=" + x +
                '}';
    }

    private String getDirection() {
        return direction;
    }

    private void setDirection(String direction) {
        this.direction = direction;
        this.directionType = Direction.create(direction);
    }
}
