package Representation;

public abstract class Instance {
    public String nom;
    public boolean visible;
    int x;
    int y;

    /**
     * @param n nom
     */
    public Instance(String n,int x1,int y1) {
        this.nom = n;
        this.x=x1;
        this.y=y1;
    }

    public void VueInstance() {
        //todo
    }

    public VueInstance getModelisation() throws Exception {
        //todo
        throw new Exception("todo");
    }

    public Instance getClasse() throws Exception {
        //todo
        throw new Exception("todo");
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y1) {
        this.y = y1;
    }
    public void setX(int x1){
        this.x=x1;
    }
}
