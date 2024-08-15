package online.nebula_cloud;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

public class Generater {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/ec-cube?useSSL=false&serverTimezone=Asia/Tokyo&characterEncoding=UTF-8",
                        "docker",
                        "123456"
                )
                .globalConfig(builder -> builder
                        .author("fengwenhao")
                        .outputDir("output/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("online.nebula_cloud.demo")
                        .entity("entity")
                )
                .templateEngine(new VelocityTemplateEngine())
                .strategyConfig(builder -> builder
                        .entityBuilder().disable()
                        .serviceBuilder().disable()
                        .controllerBuilder().disable()
                        .mapperBuilder().disable()
                )
                .injectionConfig(builder -> builder
                        .customFile(Collections.singletonMap("custom.java", "/templates/entity.java.vm"))
                )
                .execute();
    }
}