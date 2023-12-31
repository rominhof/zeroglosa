package br.com.zeroglosa;

import br.com.zeroglosa.repositories.ZeroGlosaRepository;
import br.com.zeroglosa.services.ZeroGlosaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestZeroGlosaService {

    @TestConfiguration
    static class ZeroGlosaServiceImplTestContextConfiguration {

        @Bean
        public ZeroGlosaService zeroGlosaService() {
            return new ZeroGlosaService();
        }
    }

    @Autowired
    private ZeroGlosaService zeroGlosaService;

    @MockBean
    private ZeroGlosaRepository zeroGlosaRepository;

    // write test cases here
    @Test
    public void test() {
        String name = "alex";
        String found = zeroGlosaService.teste();
        Assert.assertEquals(found, "teste");
    }
}