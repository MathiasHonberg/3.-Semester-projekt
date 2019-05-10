package semesterprojekt.demo.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ImageControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return null;
        //return new Class[0];
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[] { "/" };
        //return new String[0];
    }
}
