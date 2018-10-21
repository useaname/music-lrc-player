package banzhuan.io.musiclrcplayer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;



@SpringBootApplication
@EnableWebSocket
public class MusicLrcPlayerApplication {

	public static void main(String[] args) {


		SpringApplication.run(MusicLrcPlayerApplication.class, args);


	}

//	@Bean
//	public ServerEndpointExporter serverEndpointExporter() {
//		return new ServerEndpointExporter();
//	}


}
