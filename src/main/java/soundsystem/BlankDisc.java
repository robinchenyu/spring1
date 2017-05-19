package soundsystem;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
public class BlankDisc implements CompactDisc {
    private String name;
    private String type;
    private List<String> tracks;

    public BlankDisc(String name, String type, List<String> tracks) {
        this.name = name;
        this.type = type;
        this.tracks = tracks;
    }
    public void play() {
        System.out.println("name " + this.name + "  type " + this.type);
        for (String t : this.tracks) {
            System.out.println("track " + t);
        }
    }
}
