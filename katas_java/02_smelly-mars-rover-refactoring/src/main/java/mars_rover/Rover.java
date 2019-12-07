package mars_rover;

import Coordinates.Coordinates;

import java.util.Objects;

public class Rover {

    private static final int DISPLACEMENT = 1;
    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        this.coordinates = new Coordinates(x, y);
    }


    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {
                direction = direction.rotateLeft();
            }

            if (command.equals("r")) {
                direction = direction.rotateRight();
            }

            if (command.equals("f")) {
                coordinates = direction.move(coordinates, DISPLACEMENT);
            }

            if (command.equals("b")) {
                coordinates = direction.move(coordinates, -DISPLACEMENT);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return direction == rover.direction &&
                Objects.equals(coordinates, rover.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, coordinates);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", coordinates=" + coordinates +
                '}';
    }

}
