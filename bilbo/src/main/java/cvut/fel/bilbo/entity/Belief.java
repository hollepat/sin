package cvut.fel.bilbo.entity;

public enum Belief {
    GOOD,
    EVIL;

    /**
     * Method for getting enum from string
     *
     * @param value string value of enum
     * @return enum
     */
    public static Belief getEnum(String value) {
        for(Belief v : values())
            if(v.toString().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
