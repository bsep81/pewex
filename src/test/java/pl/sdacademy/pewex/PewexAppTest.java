package pl.sdacademy.pewex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PewexAppTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void shoulStartContext() {
        assertThat(dataSource).isNotNull();
    }
}
