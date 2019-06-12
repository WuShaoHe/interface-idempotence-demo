package vip.wush.idempotence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: RunTest
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/12 14:50
 */
@Component
public class RunTest implements ApplicationRunner {

    @Autowired
    private MyRestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("执行多线程测试");
        String url="http://localhost:8080/hello";
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for(int i=0; i<50; i++){
            String userId = "userId" + i;
            HttpEntity request = buildRequest(userId);
            executorService.submit(() -> {
                try {
                    countDownLatch.await();
                    System.out.println("Thread:"+Thread.currentThread().getName()+", time:"+System.currentTimeMillis());
                    ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
                    System.out.println("Thread:"+Thread.currentThread().getName() + "," + response.getBody());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        countDownLatch.countDown();
    }


    private HttpEntity buildRequest(String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "yourToken");
        Map<String, Object> body = new HashMap<>();
        body.put("name", userId);
        return new HttpEntity<>(body, headers);
    }



}
