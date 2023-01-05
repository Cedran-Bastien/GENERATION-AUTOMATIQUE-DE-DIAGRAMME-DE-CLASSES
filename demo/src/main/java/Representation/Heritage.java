package Representation;

import javafx.scene.shape.Line;

public class Heritage extends Relation{
    private Line pointeC;

    public Heritage(String src, String cible) {
        super(src, cible);
    }

    public Heritage(int xd, int yd, int xf, int yf){
        super(xd,yd,xf,yf);
    }

    @Override
    public String toString() {
        return "\nla classe "+this.classeSrc+" herite de la classe "+this.classeCible;
    }

    @Override
    public VueRelation getImage() {
        return new VueHeritage(this);
    }
}
