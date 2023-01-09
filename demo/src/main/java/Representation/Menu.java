package Representation;

import java.util.List;

public class Menu {
    private List<String> elements;
    private boolean orientation;
    private int x;
    private int y;

    /**
     * Constructeur prenant une liste de String correspondant au boutton un boolean pour l'orientation du menu et un int X et Y pour la position
     * @param l
     * @param o
     * @param x
     * @param y
     */
    public Menu(List<String> l,boolean o,int x,int y){
        elements = l;
        orientation = o;
        this.x = x;
        this.y = y;
    }

    public List<String> getElements() {
        return elements;
    }

    public boolean getOrientation() {
        return orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
