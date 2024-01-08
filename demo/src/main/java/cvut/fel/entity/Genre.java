package cvut.fel.entity;

public enum Genre {
    SCIFI,
    FANTASY,
    DRAMA,
    COMEDY,
    THRILLER,
    HORROR,
    TRAGEDY;



    public static Genre getEnum(String value) {
        for(Genre v : values())
            if(v.toString().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }


}
