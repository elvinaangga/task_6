package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfig implements WebMvcConfigurer {


    private final ServletContext servletContext;

    @Autowired
    public WebConfig(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Bean
        public ITemplateResolver templateResolver() {
            ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContext);
            resolver.setPrefix("/WEB-INF/pages/");  // Points to webapp/WEB-INF/pages/
            resolver.setSuffix(".html");
            resolver.setTemplateMode(TemplateMode.HTML);
            resolver.setCharacterEncoding("UTF-8");
            resolver.setCacheable(false);
            return resolver;
        }

        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine engine = new SpringTemplateEngine();
            engine.setTemplateResolver(templateResolver());
            engine.setEnableSpringELCompiler(true);
            return engine;
        }

        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
            viewResolver.setTemplateEngine(templateEngine());
            viewResolver.setCharacterEncoding("UTF-8");
            viewResolver.setOrder(1);
            registry.viewResolver(viewResolver);
        }
}
