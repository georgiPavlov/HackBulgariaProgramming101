package week03;

import java.util.HashMap;

/**
 * Created by georgipavlov on 03.12.15.
 */
public class UtilityMethodStringRead {
    public String utility(HashMap<? extends Object, ? extends Object> map){
      StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(HashMap.Entry<?extends Object, ? extends Object> mapE: map.entrySet()){
            builder.append(mapE.getKey());
            builder.append(":");
            builder.append(mapE.getValue());
            builder.append(", ");
        }
        builder.append("}");
        return builder.toString();
    }

    public static void main(String[] args) {
       HashMap<String,Integer> one = new HashMap<>();
        one.put("one",1);
        one.put("two",2);
        one.put("tree",3);
        one.put("four",4);
        UtilityMethodStringRead utilityMethodStringRead = new UtilityMethodStringRead();
        System.out.println(utilityMethodStringRead.utility(one));

    }

}
