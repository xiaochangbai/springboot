package cn.xdd.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Properties;


/**
 *
 * @author xchb
 * @version 1.0
 * @ClassName DataSoureceConfig
 * @description jdbc数据源配置
 * @createTime 2019年09月14日 11:23
 */
@Configuration
public class DataSourceConfig {

    /**
     * 使用dbcp连接池配置数据源
     * @return  数据源
     * @throws Exception 未知
     */
    @Bean
    public DataSource dbcpDataSource() throws Exception {
        Properties properties=new Properties();
        properties.load(DataSourceConfig.class.getClassLoader().getResourceAsStream("db.properties"));
        return BasicDataSourceFactory.createDataSource(properties);
    }


}
