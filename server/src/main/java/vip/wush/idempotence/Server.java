package vip.wush.idempotence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: Server
 * @Description: springboot 启动入口
 * @Author: wush
 * Date: 2019/6/12 11:46
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan({
        "vip.wush.idempotence"
})
//@SpringBootApplication
public class Server {

    public static void main(String[] args) {

        SpringApplication.run(Server.class, args);

    }

    /**
     * 注册内嵌式Undertow Servlet容器
     * @return
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        return factory;
    }
}
