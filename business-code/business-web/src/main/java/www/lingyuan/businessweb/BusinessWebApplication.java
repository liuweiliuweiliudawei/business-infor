package www.lingyuan.businessweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("www.lingyuan.businessweb.dao")
public class BusinessWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessWebApplication.class, args);
    }

}
