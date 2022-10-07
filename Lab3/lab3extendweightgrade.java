package lab.zxsipromise.lab3;

public class lab3extendweightgrade {
    private int totalpoint; //instance private variables
    private double earnpoint;
    private double percentage;
    public void getgrade(int tp,double ea,double per)   //The getgrade method
    {
        this.totalpoint = tp;
        this.earnpoint = ea;
        this.percentage = per;
    }
}
