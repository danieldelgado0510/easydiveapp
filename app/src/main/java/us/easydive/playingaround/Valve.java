package us.easydive.playingaround;

public class Valve {

    private String VALVE_ID = "";
    private int VALVE_FILLS = 0;

    public boolean updateFills(int input){
        if( input > 0 ){
            VALVE_FILLS += input;
            return true;
        }
        else return false;
    }

    public Valve(String v, int f) {
        this.VALVE_FILLS = f;
        this.VALVE_ID = v;
    }

    public String getValveID() {
        return VALVE_ID;
    }

    public int getValveFills(){
        return VALVE_FILLS;
    }


}
