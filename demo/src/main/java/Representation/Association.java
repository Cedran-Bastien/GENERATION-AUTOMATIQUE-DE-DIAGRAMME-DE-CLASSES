package Representation;

import Vue.VueAssociation;
import Vue.VueRelation;

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
    public Association(Instance src, Instance cible, String nsrc, String ncible, String nom) {
        super(src, cible);
        this.nbCible = ncible;
        this.nbSrc = nsrc;
        this.nomAtt = nom;
    }

    public Association(int xd, int yd, int xf, int yf,String tD, String tF){
        super(xd,yd,xf,yd);
        this.nbSrc = tD;
        this.nbCible = tF;
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
            return "la classe " +this.classeSrc + " contient"+phraseCible+ this.classeCible+" de nom "+"'"+this.nomAtt+"'";
        }

    @Override
    public VueRelation getImage() {
        return new VueAssociation(this);
    }

    public String getNbCible(){
            return nbCible;
        }

        public String getNbSrc(){
            return nbSrc;
        }

    }
