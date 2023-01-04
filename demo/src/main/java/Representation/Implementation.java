package Representation;

public class Implementation extends Relation {
    private Line pointeC;

    public Implementation(String src, String cible) {
        super(src, cible);
    }

    public Implementation(int xd, int yd, int xf, int yf){
        super(xd,yd,xf,yf);
        this.update();
        getChildren().addAll(chemin,pointeA,pointeB,pointeC);
    }

    public void update(){
        int xS =5;
        int yS =5;
        int longueur = (xDebut - xFin) /20;
        int hauteur = (yDebut - yFin) /20;

        if(xDebut>xFin){
            xS = -5;
        }
        if(yDebut>yFin){
            yS = -5;
        }


        if(yDebut == yFin){
            chemin = new Line(xDebut,yDebut,xFin-(xS*2),yFin);
            chemin.getStrokeDashArray().addAll(10d);
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin-(xS*2),yFin+(yS*2));
            pointeC = new Line(xFin-(xS*2),yFin-(yS*2),xFin-(xS*2),yFin+(yS*2));
        }else if(xDebut == xFin){
            chemin = new Line(xDebut,yDebut,xFin,yFin-(yS*2));
            chemin.getStrokeDashArray().addAll(10d);
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin+(xS*2),yFin-(yS*2));
            pointeC = new Line(xFin-(xS*2),yFin-(yS*2),xFin+(xS*2),yFin-(yS*2));
        }else {
            chemin = new Line(xDebut,yDebut,xFin-xS,yFin-yS);
            chemin.getStrokeDashArray().addAll(5d);
            pointeA = new Line(xFin, yFin, xFin - (xS * 2), yFin);
            pointeB = new Line(xFin, yFin, xFin, yFin - (yS * 2));
            pointeC = new Line(xFin - (xS * 2), yFin, xFin, yFin - (yS * 2));
        }
    }

    @Override
    public String toString() {
        return "\nla classe "+this.classeSrc+" implemente l'interface "+this.classeCible;
    }
}
