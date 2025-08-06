package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // For root application context (services, repositories, etc.)
        return new Class<?>[] {
                // Add other configuration classes if needed
                WebConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // For web-related components (controllers, view resolvers)
        return new Class<?>[] {
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        // Add any filters you need (e.g., for encoding)
        return new Filter[] {};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // Configure multipart support for file uploads
        registration.setMultipartConfig(new MultipartConfigElement(
                "", // temporary location (default)
                2097152, // max file size (2MB)
                4194304, // max request size (4MB)
                0 // file size threshold (stored in memory)
        ));

        // Enable throwExceptionIfNoHandlerFound
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }
}