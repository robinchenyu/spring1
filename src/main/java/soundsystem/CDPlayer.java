package soundsystem;

import com.singleton.utils.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/16.
 */
@Component
public class CDPlayer implements MediaPlayer{
    private String band;
    private CompactDisc cd;

    public CDPlayer(String b, CompactDisc cc) {
        this.band = b;
        this.cd = cc;
    }

    public void run() {
        System.out.println("run " + this.band);
        cd.play();
        System.out.println("run end");
    }

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
