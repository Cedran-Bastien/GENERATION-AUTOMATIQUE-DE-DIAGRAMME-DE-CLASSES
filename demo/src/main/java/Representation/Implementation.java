package Representation;

public class Implementation extends Relation{
    public Implementation(String src, String cible) {
        super(src, cible);
    }

    @Override
    public String toString() {
        return "\nla classe "+this.classeSrc+" implemente l'interface "+this.classeCible;
    }
}
