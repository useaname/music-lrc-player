package banzhuan.io.musiclrcplayer.service;

import banzhuan.io.musiclrcplayer.domian.LrcData;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class LrcService {

    /**
     * 读取歌词
     * @param path
     * @return
     * @throws IOException
     */
    public List<String> getLrc(String path) throws IOException {
        Resource lrc = new ClassPathResource(path);
        List<String> lines = FileUtils.readLines(lrc.getFile(), "UTF-8");
        return lines;
    }

    /**
     * 转换为歌词对象
     * @param lines
     * @return
     */
    public List<LrcData> makeLrc(List<String> lines) {

        List<LrcData> dataList = new ArrayList<>();

        lines.forEach( e -> {
            LrcData lrcData = new LrcData();
            String[] cut = e.split("]");
            if (cut.length >= 2) {
                for (int i = 0; i < cut.length - 1; i++) {

                    String[] timeText = e.split("]");
                    String timeStr = timeText[0].substring(e.indexOf('[') + 1);

                    lrcData.setTime(
                            LrcData.convertToTime(timeStr)
                    );
                    lrcData.setText(
                            timeText[1]
                    );

                    dataList.add(lrcData);
                }
            }

        });
//        System.err.println(
//                JSON.toJSON(dataList)
//        );
        return dataList;
    }


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void play(List<LrcData> lrcData) throws InterruptedException {


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                long fist = 0L;
                for (int i = 0; i < lrcData.size(); i++) {

                    LrcData _data = lrcData.get(i);

                    if (i == 0) {
                        fist = System.currentTimeMillis();
                    }

                    if (System.currentTimeMillis() > fist + _data.getTime() ) {
                        System.out.println(_data.getText());
                    } else {
                        i--;
                        continue;
                    }

                }

            }
        }, 1000);
        System.err.println();
    }

}
