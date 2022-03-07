package net.maple3142.umleditor;

public enum EditorMode {
    SELECT("select"),
    ASSOCIATE("associate"),
    GENERAL("general"),
    COMPOSITE("composite"),
    CLASS("class"),
    USE_CASE("usecase");

    private final String name;

    EditorMode(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
