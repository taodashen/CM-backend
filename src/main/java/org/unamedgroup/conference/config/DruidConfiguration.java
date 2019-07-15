package org.unamedgroup.conference.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Druid的配置类
 * @author zhoutao
 * @date 2019-7-12
 */
@Configuration
public class DruidConfigure {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }

    /**
     * 注册后台Servlet，用于显示后台
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> param = new HashMap<String, String>(3);
        // 设置登录用户名
        param.put("loginUsername", "zhoutao");
        //设置登录密码
        param.put("loginPassword", "zhoutao");
        param.put("reset-enable", "false");
;        // 指定所有IP均可访问
        param.put("allow", "");
        servletRegistrationBean.setInitParameters(param);
        return servletRegistrationBean;
    }

    /**
     * 过滤器，用于监听请求和过滤请求
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        // 监听所有请求
        filterRegistrationBean.addUrlPatterns("/*");
        // 过滤所有加载静态资源的请求
        filterRegistrationBean.addInitParameter("exclusions", "*.js, *.gif, *.jpg, *.png, *.css, *.ico, /druid/*");
        return filterRegistrationBean;
    }


}
