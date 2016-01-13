package week07;

import java.nio.file.Path;

/**
 * Created by georgipavlov on 12.01.16.
 */
public class ReduceFilePathIn1Line{
    public Path reduceFilePath(Path path){
        return path.normalize();
    }

}
