package Representation;
public class Association extends Relation {
    /**
     * nombre de l'associatio de la classe src
     */
    private String nbSrc;
    /**
     * nombre de l'associatio de la classe cible
     */
    private String nbCible;
    /**
     * nom de l'attribut correspondant a cette association
     */
    private String nomAtt;

    Text textD;
    Text textF;

    /**
     * creer une association
     * @param src
     *      nom de la classe source
     * @param cible
     *      nom de la classe cible
     * @param nsrc
     *      nombre de l'associatio de la classe src
     * @param ncible
     *      nombre de l'associatio de la classe cible
     * @param nom
     *      nom de l'attribut correspondant a cette association
     */
    public Association(String src, String cible,String nsrc, String ncible, String nom) {
        super(src, cible);
        this.nbCible = ncible;
        this.nbSrc = nsrc;
        this.nomAtt = nom;
    }

    public Association(int xd, int yd, int xf, int yf,String tD, String tF){
        super(xd,yd,xf,yd);
        textD = new Text(tD);
        textF = new Text(tF);
        this.update();
        getChildren().addAll(chemin,pointeA,pointeB,textD,textF);
    }

    public void update(){
        int xS =5;
        int yS =5;
        if(xDebut>xFin){
            xS = -5;
        }
        if(yDebut>yFin){
            yS = -5;
        }

        chemin = new Line(xDebut,yDebut,xFin,yFin);
        textD.setX(xDebut+xS);
        textD.setY(yDebut-yS);
        textF.setX(xFin-xS);
        textF.setY(yFin-yS);

        if(yDebut == yFin){
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin-(xS*2),yFin+(yS*2));
        }else if(xDebut == xFin){
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin+(xS*2),yFin-(yS*2));
        }else {
            pointeA = new Line(xFin, yFin, xFin - (xS * 2), yFin);
            pointeB = new Line(xFin, yFin, xFin, yFin - (yS * 2));
        }
    }

    /**
     *
     * @return
     *      un affichage de l'association
     */
    @Override
    public String toString() {
        String phraseCible="";
        switch (this.nbCible){
            case "*":phraseCible=" une liste d'objets de la classe ";
            break;
            case "1":phraseCible=" un attribut de la classe ";
            break;
            default:
                if(this.nbCible.contains("*")) {
                    phraseCible=" une liste ";
                }else if(this.nbCible.contains("..")){
                    phraseCible = " entre " + this.nbCible.replace("..", " et ")+" attributs de la classe ";
                }else{
                    phraseCible=this.nbCible+" attributs de la classe ";
                }
        }
            return "\nla classe " +this.classeSrc + " contient"+phraseCible+ this.classeCible+" de nom "+"'"+this.nomAtt+"'";
        }

    }
