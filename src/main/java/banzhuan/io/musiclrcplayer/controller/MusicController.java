package banzhuan.io.musiclrcplayer.controller;

import banzhuan.io.musiclrcplayer.service.LrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class MusicController {

    @Value("${lrc.file}")
    private String lrcFile;


    @Autowired
    private LrcService lrcService;

    @GetMapping("start")
    @ResponseBody
    public String start() throws IOException, InterruptedException {
        List<String> lines = lrcService.getLrc(lrcFile);
        lrcService.play(
                lrcService.makeLrc(lines)
        );
        return "start";
    }



    @PostMapping(value = "song")
    public String getSong() {
        return null;
    }

}
