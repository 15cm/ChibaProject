package moe.akagi.chibaproject.datatype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunze on 11/30/15.
 */
public class Event {
    // event state
    public final static int READY  = 0; // 发起
    public final static int PLAY   = 1; // 进行中
    public final static int END    = 2; // 结束
    public final static int CANCEL = 3; // 取消

    private int id;
    private int manegerId;
    private long time;
    private String location;
    private List<String> memberIds;
    private int state;
    // private Decision decision;


    public Event() {
        memberIds = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManegerId() {
        return manegerId;
    }

    public void setManegerId(int manegerId) {
        this.manegerId = manegerId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<String> memberIds) {
        this.memberIds = memberIds;
    }
}
