package banzhuan.io.musiclrcplayer.domian;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalTime;

@Setter
@Getter
@Accessors(chain = true)
public class LrcData {


    private long time;

    private String text;

    /**
     * 歌词中的时间转换为毫秒
     * @param time
     * @return
     */
    public static long convertToTime(String time) {

        long minute = Integer
                .parseInt(time.substring(0, time.lastIndexOf(":")));

        long second = Integer.parseInt(time.substring(time.indexOf(":") + 1,
                time.lastIndexOf(".")));

        long millisecond = Integer
                .parseInt(time.substring(time.indexOf(".") + 1));

        return (long) (minute * 60 * 1000 + second * 1000 + millisecond);


    }


}
