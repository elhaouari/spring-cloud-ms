package com.elhaouari.servicecompany;

import com.elhaouari.servicecompany.dao.CompanyRepository;
import com.elhaouari.servicecompany.entities.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCompanyApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompanyRepository companyRepository){
        return args -> {
          Stream.of("A", "B", "C").forEach(cn->{
              companyRepository.save(new Company(null, cn, new Date(), 100+Math.random()*1000));
          });
          companyRepository.findAll().forEach(System.out::println);
        };
    }
}
