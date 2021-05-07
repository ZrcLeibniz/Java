package rich.zrc.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import rich.zrc.bean.Rainbow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    // AnnotationMetadata: 当前类的注解信息
    // BeanDefinitionRegistry: BeanDefinition注册类，把需要注册的组件添加到容器中
    // 调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        boolean red = registry.containsBeanDefinition("rich.zrc.bean.Red");
        boolean blue = registry.containsBeanDefinition("rich.zrc.bean.Blue");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
        if (red && blue) {
            registry.registerBeanDefinition("rainbow", rootBeanDefinition);
        }
    }
}
