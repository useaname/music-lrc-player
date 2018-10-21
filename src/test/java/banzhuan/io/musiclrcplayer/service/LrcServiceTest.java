package banzhuan.io.musiclrcplayer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LrcServiceTest {

    @Autowired
    private LrcService lrcService;

    @Value("${lrc.file}")
    private String lrcFile;

    @Test
    public void getLrcTeet() throws IOException, InterruptedException {
        List<String> lines = lrcService.getLrc(lrcFile);
        lrcService.play(
                lrcService.makeLrc(lines)
        );

    }




}
