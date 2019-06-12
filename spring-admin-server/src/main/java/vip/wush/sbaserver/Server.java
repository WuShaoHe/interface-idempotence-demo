package vip.wush.sbaserver;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: Server
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/12 21:44
 */

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class Server {

    public static void main(String[] args) {

        SpringApplication.run(Server.class, args);

    }

}
