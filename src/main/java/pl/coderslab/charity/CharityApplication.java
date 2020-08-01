package pl.coderslab.charity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.coderslab.charity.fixture.InitData;


@SpringBootApplication
public class CharityApplication implements CommandLineRunner {

    private InitData initData;

    public CharityApplication(InitData initData) {
        this.initData = initData;
    }

    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initData.init();
    }
}
