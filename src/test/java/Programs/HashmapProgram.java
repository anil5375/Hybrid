package Programs;

import java.util.HashMap;
import java.util.Map;

public class HashmapProgram {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 1);

        for ( Map.Entry<String,Integer> maps : map.entrySet()) {
            if(maps.getValue()==1){
                System.out.println(maps.getKey());
            }
        }
    }
}