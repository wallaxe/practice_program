package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateRight() {
            return Direction.E;
        }
    },S {
        @Override
        public Direction rotateRight() {
            return Direction.W;
        }
    },E {
        @Override
        public Direction rotateRight() {
            return Direction.S;
        }
    },W {
        @Override
        public Direction rotateRight() {
            return Direction.N;
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
}
