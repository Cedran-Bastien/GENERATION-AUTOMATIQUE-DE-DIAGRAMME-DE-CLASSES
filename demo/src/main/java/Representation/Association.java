package Representation;

public class Association extends Relation{
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
    public Association(String src, String cible,String nsrc, String ncible, String nom) {
        super(src, cible);
        this.nbCible = ncible;
        this.nbSrc = nsrc;
        this.nomAtt = nom;
    }

    /**
     *
     * @return
     *      un affichage de l'association
     */
    @Override
    public String toString() {
        if (this.nbCible=="1"){
            return "\nla classe " +this.classeSrc + "contient un attribut " +this.nomAtt + "du type de la classe "+ this.classeCible;
        }else {
            return "\nla classe " +this.classeSrc + "contient un attribut " +this.nomAtt + "etant une liste d'objet de la classe  "+ this.classeCible;
        }

    }
}
