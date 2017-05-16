package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/14.
 */
@Component("compactDisc")
public class SgtPeppers implements CompactDisc {
    public void play(){
        System.out.println("Hello World");
    }
}
