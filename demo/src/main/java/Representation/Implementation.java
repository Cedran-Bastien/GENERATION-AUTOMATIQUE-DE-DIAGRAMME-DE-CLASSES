package Representation;

import javafx.scene.shape.Line;

public class Implementation extends Relation {
    private Line pointeC;

    public Implementation(String src, String cible) {
        super(src, cible);
    }

    public Implementation(int xd, int yd, int xf, int yf){
        super(xd,yd,xf,yf);
    }

    @Override
    public String toString() {
        return "\nla classe "+this.classeSrc+" implemente l'interface "+this.classeCible;
    }
}
