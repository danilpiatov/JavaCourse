package service3;

public class IntToTime {
    public static String convert(Integer mins){
        String str = "";
        int d = mins/1440;
        mins = mins - d*1440;
        int h = mins/60;
        mins = mins - h*60;
        str = d+":"+h+":"+mins;
        return str;
    }
}
