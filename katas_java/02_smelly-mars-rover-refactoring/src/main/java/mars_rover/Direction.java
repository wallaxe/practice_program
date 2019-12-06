package mars_rover;

public enum Direction {
    N,S,E,W;


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
}
