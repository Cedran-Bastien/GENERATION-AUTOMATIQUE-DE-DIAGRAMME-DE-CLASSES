package Representation;

public abstract class Relation {
    protected String classeSrc;
    protected String classeCible;

    public Relation(String src, String cible) {
        this.classeSrc = src;
        this.classeCible =cible;
    }

    public abstract String toString();

    public String getClasseSrc() {
        return classeSrc;
    }

    public String getClasseCible() {
        return classeCible;
    }
}
