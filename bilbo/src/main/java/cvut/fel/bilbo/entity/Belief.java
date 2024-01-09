package cvut.fel.bilbo.entity;

public enum Belief {
    GOOD,
    EVIL;

    public static Belief getEnum(String value) {
        for(Belief v : values())
            if(v.toString().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
