package com.redline.ecoredlinekgback;

import com.redline.ecoredlinekgback.pojo.Instance;
import com.redline.ecoredlinekgback.service.HomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcoRedlineKgBackApplicationTests {
    @Autowired
    HomeService homeService;
    @Test
    void getDetailArrTest() {
        Instance[] arr = homeService.getInstanceArr();
        for (Instance detail : arr) {
            System.out.println(detail);
        }
    }

}
