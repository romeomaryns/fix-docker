package eu.maryns.fix.service.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
@EnableZuulProxy
@RestController
@EnableHystrix
public class Application {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(80000);
        return "timeout";
    }

    @Bean
    public ZuulFallbackProvider zuulFallbackProvider() {
        return new ZuulFallbackProvider() {
            @Override
            public String getRoute() {
                return "zuul-service";
            }

            @Override
            public ClientHttpResponse fallbackResponse() {
                return new ClientHttpResponse() {
                    @Override
                    public HttpStatus getStatusCode() throws IOException {
                        return HttpStatus.OK;
                    }

                    @Override
                    public int getRawStatusCode() throws IOException {
                        return 200;
                    }

                    @Override
                    public String getStatusText() throws IOException {
                        return "OK";
                    }

                    @Override
                    public void close() {

                    }

                    @Override
                    public InputStream getBody() throws IOException {
                        return new ByteArrayInputStream("fallback".getBytes());
                    }

                    @Override
                    public HttpHeaders getHeaders() {
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        return headers;
                    }
                };
            }
        };
    }
}