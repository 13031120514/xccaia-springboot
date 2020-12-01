package com.xc.exclude;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: xiaochuan.cai
 * @Date: 2020/12/1
 * @Description:  
 */  
@SpringBootApplication
@ComponentScan(basePackages = "com.sgcc.eip.cmc.cable.acquisition.listener," +
        "com.sgcc.eip.cmc.cable.acquisition.job",
        useDefaultFilters = true,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        }
//        excludeFilters = @ComponentScan.Filter(RocketMQMessageListener.class)
)
public class CableAcquisitionApplication {

  public static void main(String[] args) {
    SpringApplication.run(CableAcquisitionApplication.class, args);
    System.out.println("1111111111111");
  }
}
