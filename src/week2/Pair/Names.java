package week2.Pair;

/**
 * Created by georgipavlov on 25.11.15.
 */
public class Names {
    String name;
    String secondName;

    Names (String name,String secondName){
        this.name=name;
        this.secondName=secondName;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((secondName == null) ? 0 : secondName.hashCode());
        return result;
    }


}
