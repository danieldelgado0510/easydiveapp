package us.easydive.playingaround;

import java.util.*;

public class Store {

    private String STORE_ID = "";
    public static Vector<Valve> VALVES = new Vector(0);

    public Store(String ID){
        this.STORE_ID = ID;
    }

    //add new valve to store, stores can have multiple valves to fill.
    public boolean addValve( String valve_id ){
        int index = valveLocation(valve_id);
        if( index == -1 )
            return false;
        Valve newValve = new Valve(valve_id, 0);
        VALVES.add(newValve);
        return true;
    }

    //same as last function except with preexisting fill count parameter.
    public boolean addValve( String valve_id, int fills ){
        int index = valveLocation(valve_id);
        if( index == -1 )
            return false;
        if( fills < 0 )
            return false;
        else {
            Valve newValve = new Valve(valve_id, fills);
            VALVES.add(newValve);
            return true;
        }
    }

    //delete valve that is no longer in use/ implement
    public boolean delValve( String valve_id)
    {
        int index = valveLocation(valve_id);
        if( index == -1)
            return false;
        VALVES.remove(index);
        return true;
    }

    public static int valveLocation( String valve_id )
    {
        int index = 0;
        for( Valve v : VALVES )
        {
            if( v.getValveID().equals(valve_id))
                return index;
            index++;
        }
        index = -1;
        return index;
    }

    public boolean reFill(String valve_id, int i ){
        int index = valveLocation(valve_id);
        if( index == -1 )
            return false;
        else return VALVES.get(index).updateFills(i);
    }

    public static int findValve(String input){
        int index = 0;
        for( Valve j : VALVES )
        {
            if( input.equals( j.getValveID()) )
                return index;
            index++;
        }
        index = -1;
        return index;
    }

    public static boolean valveExists( String input ){
        return !( findValve(input) == -1);
    }

    public static int valveFills(String valve_id){
        int index = valveLocation(valve_id);
        if( index == -1 )
            return -1;
        else return VALVES.get(index).getValveFills();
    }

    public String getStoreID(){
        return STORE_ID;
    }



}
