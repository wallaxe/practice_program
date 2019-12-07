package mars_rover;

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
    },S {
        @Override
        public Direction rotateRight() {
            return Direction.W;
        }

        @Override
        public Direction rotateLeft() {
            return Direction.E;
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
    },W {
        @Override
        public Direction rotateRight() {
            return Direction.N;
        }

        @Override
        public Direction rotateLeft() {
            return Direction.S;
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
}
