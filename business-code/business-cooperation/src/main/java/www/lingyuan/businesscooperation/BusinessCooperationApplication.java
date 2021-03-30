package www.lingyuan.businesscooperation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("www.lingyuan.businesscooperation.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class BusinessCooperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessCooperationApplication.class, args);
    }

}
