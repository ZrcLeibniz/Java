package rich.zrc.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    /*
    ConditionContext: 判断条件能使用的上下文环境
    AnnotatedTypeMetadata: 标注了Condition注解的注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 能获取到类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 能获取到环境
        Environment environment = context.getEnvironment();
        // 能获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
