package DSA_projekt;

public class Uzel {
    private int data;
    private Uzel levy;
    private Uzel pravy;




    public Uzel(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
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

