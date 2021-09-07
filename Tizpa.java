package Tizpa;

public class Tizpa {
    private static int[][] fees={{1,2,2,4,3,},{2,1,4,2,3,},{3,5,1,3,2},{4,3,3,1,2},{3,3,2,2,1} };
    private int from;
    private int to;
    private int feeCoef;
    public Tizpa(int from , int to , TripMethod tp , boolean isTraffic , boolean isRaining ){
        this.from = from;
        this.to = to;
        if(isRaining&&isRaining){
            feeCoef = tp.getTraffAndRainCoef();
        }else if(isTraffic) {
            feeCoef = tp.getTrafficCoef();
        }else if(isRaining){
            feeCoef = tp.getRainCoef();
        }else{
            feeCoef =tp.getBaseCoef();
        }

    }
    public int getTotalFee(){
        return fees[from][to] * feeCoef;
    }
}
enum TripMethod{
    ECCO(5000 , 1.4 , 1.2, 1.2),
    VIP(10000,3, 2 , 2 ),
    CYCLE(4000 , 1.5 , 2 , .8);

    private int baseFee;
    private double traffCoef;
    private double rainingCoef;
    private double traffAndRainCoef;
    private TripMethod(int fee , double traffAndRainCoef , double traffCoef , double rainingCoef){
        this.baseFee = fee;
        this.traffAndRainCoef =traffAndRainCoef;
        this.traffCoef =traffCoef;
        this.rainingCoef = rainingCoef;
    }
    public int getTraffAndRainCoef(){
        return (int) ( baseFee * traffAndRainCoef);
    }
    public int getTrafficCoef(){
        return (int)(baseFee * traffCoef);
    }
    public int getRainCoef(){
        return (int)(baseFee * rainingCoef);
    }
    public int getBaseCoef() { return baseFee;}
}