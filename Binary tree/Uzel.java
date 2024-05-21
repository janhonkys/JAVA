package DSA_projekt_GITnew;

public class Uzel {
    private int hodnota;
    private Uzel levy;
    private Uzel pravy;

    public Uzel(int hodnota) {
        this.hodnota = hodnota;
    }

    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    public Uzel getLevy() {
        return levy;
    }
    public void setLevy(Uzel levy) {
        this.levy = levy;
    }
    public Uzel getPravy() {
        return pravy;
    }
    public void setPravy(Uzel pravy) {
        this.pravy = pravy;
    }
}

