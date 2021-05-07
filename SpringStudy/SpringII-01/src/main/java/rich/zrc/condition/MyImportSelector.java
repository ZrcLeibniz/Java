package rich.zrc.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// 自定义逻辑返回需要的导入的组件类名数组
public class MyImportSelector implements ImportSelector {
    /*
        返回值就是要注册到容器中的所有组件的全类名
        AnnotationMetadata: 当前标注@Import注解的类的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"rich.zrc.bean.Blue", "rich.zrc.bean.Red"};
    }
}
