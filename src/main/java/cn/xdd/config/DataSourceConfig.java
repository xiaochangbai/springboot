package cn.xdd.config;

import com.mysql.cj.jdbc.MysqlDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

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
