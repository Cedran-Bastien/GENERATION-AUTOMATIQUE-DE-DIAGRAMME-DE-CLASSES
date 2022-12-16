package Representation;

public class Heritage extends Relation{

    public Heritage(String src, String cible) {
        super(src, cible);
    }

    @Override
    public String toString() {
        return "\nla classe "+this.classeSrc+" herite de la classe "+this.classeCible;
    }
}
