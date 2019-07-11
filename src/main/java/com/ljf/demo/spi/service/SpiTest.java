package com.ljf.demo.spi.service;

import java.util.ServiceLoader;

/**
 * @author liujf05
 * @date 2019/3/21
 */
public class SpiTest {

    public static void main(String[] args){
        ServiceLoader<SpiService>spiServices = ServiceLoader.load(SpiService.class);
        for(SpiService spiService:spiServices) {
            spiService.hello();
        }
    }
}
