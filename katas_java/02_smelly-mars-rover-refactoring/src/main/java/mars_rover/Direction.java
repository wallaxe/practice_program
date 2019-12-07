package mars_rover;

import Coordinates.Coordinates;

public enum Direction {
    N {
        @Override
        public Direction rotateRight() {
            return Direction.E;
        }

        @Override
        public Direction rotateLeft() {
            return Direction.W;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongY(displacement);
        }
    },S {
        @Override
        public Direction rotateRight() {
            return Direction.W;
        }

        @Override
        public Direction rotateLeft() {
            return Direction.E;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.moveAlongY(-displacement);
        }
    },E {
        @Override
        public Direction rotateRight() {
            return Direction.S;
        }

        @Override
        public Direction rotateLeft() {
            return Direction.N;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates.MoveAlongX(displacement);
        }
    },W {
        @Override
        public Direction rotateRight() {
            return Direction.N;
        }

        @Override
        public Direction rotateLeft() {
            return Direction.S;
        }

        @Override
        public Coordinates move(Coordinates coordinates, int displacement) {
            return coordinates = coordinates.MoveAlongX(-displacement);
        }
    };


    public static Direction create(String directionEncoding) {
        if(directionEncoding.equals("S")){
            return S;
        }
        if(directionEncoding.equals("E")){
            return E;
        }
        if(directionEncoding.equals("W")){
            return W;
        }
        if(directionEncoding.equals("N")){
            return N;
        }

        throw new IllegalArgumentException();
    }
    abstract public Direction rotateRight();

    public abstract Direction rotateLeft();

    public abstract Coordinates move(Coordinates coordinates, int displacement);
}
