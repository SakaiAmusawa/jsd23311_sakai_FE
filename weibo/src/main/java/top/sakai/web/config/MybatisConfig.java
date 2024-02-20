package top.sakai.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("top.sakai.web")
public class MybatisConfig {
}
