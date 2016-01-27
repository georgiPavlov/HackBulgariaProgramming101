package week09;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

/**
 * Created by georgipavlov on 27.01.16.
 */
public @interface ClassInfo {
    String author();
    int currentRevision() default 1;
    boolean checked() default true;

}
