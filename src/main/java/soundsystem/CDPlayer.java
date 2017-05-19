package soundsystem;

import com.singleton.utils.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/16.
 */
public class CDPlayer {
    public static void main(String[] args) {
//        System.out.println("Hello ");
//        ApplicationContext ac = new ClassPathXmlApplicationContext("soundsystem/applicationContext.xml");
//        CompactDisc cd = (CompactDisc) ac.getBean("compactDisc");
//        cd.play();
        CompactDisc cd = (CompactDisc) ApplicationContextUtil.getInstance().getBean("compactDisc");
        cd.play();

        CompactDisc cd2 = (CompactDisc) ApplicationContextUtil.getInstance().getBean("compactDisc2");
        cd2.play();
    }
}
