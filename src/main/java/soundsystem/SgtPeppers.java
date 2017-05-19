package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/14.
 */
@Component("compactDisc")
public class SgtPeppers implements CompactDisc {
    private String name;

    public SgtPeppers() {
        this(null);
    }

    public SgtPeppers(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println("Hello World " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
