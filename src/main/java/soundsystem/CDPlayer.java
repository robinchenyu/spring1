package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/16.
 */
public class CDPlayer {
    public static void main(String[] args) {
//        System.out.println("Hello ");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CompactDisc cd = (CompactDisc) ac.getBean("compactDisc");
        cd.play();
    }
}
