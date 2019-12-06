package mars_rover;

import Coordinates.Coordinates;

import java.util.Objects;

public class Rover {

    private Direction direction;
    private Coordinates coordinates;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        setCoordinate(x, y);
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
            this.direction = Direction.E;
        } else if (faceSouth()) {
            this.direction = Direction.W;
        } else if (faceWest()) {
            this.direction = Direction.N;
        } else  {
            this.direction = Direction.S;
        }
    }

    private boolean faceWest() {
        return direction.equals(Direction.W);
    }

    private boolean faceSouth() {
        return direction.equals(Direction.S);
    }

    private boolean faceNorth() {
        return direction.equals(Direction.N);
    }

    private void rotateLeft() {
        if (faceNorth()) {
            this.direction = Direction.W;
        } else if (faceSouth()) {
            this.direction = Direction.E;
        } else if (faceWest()) {
            this.direction = Direction.S;
        } else  {
            this.direction = Direction.N;
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
            setCoordinate(x, getY() + displacement);
        } else if (faceSouth()) {
            setCoordinate(x, getY() - displacement);
        } else if (faceWest()) {
            setCoordinate(getX() - displacement, y);
        } else  {
            setCoordinate(getX() + displacement, y);
        }
    }

    private void setCoordinate(int x, int y) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return getY() == rover.getY() &&
                getX() == rover.getX() &&
                direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, getY(), getX());
    }

    @Override
    public String toString() {
        return "Rover{" +
                "directionType=" + direction +
                ", y=" + getY() +
                ", x=" + getX() +
                '}';
    }

    private int getY() {
        return y;
    }

    private int getX() {
        return x;
    }
}
