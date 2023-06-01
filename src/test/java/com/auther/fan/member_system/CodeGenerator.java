package com.auther.fan.member_system;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/member_system";
        String username = "root";
        String password = "root";
        String moduleName = "sys";//输出目录名
        String mapperLocation = "D:\\maven-wrokspace\\member_system\\src\\main\\resources\\mapper\\" + moduleName;
        String tables = "admin,card,combine_member_tag,coupon,growth,member,member_level,member_tag,member_ship,order,product,record,score,tag_condition";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("fan") // 设置作者
                           // .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\maven-wrokspace\\member_system\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.auther.fan.member_system") // 设置父包名   .outputDir("D:\\maven-wrokspace\\member_system\\src\\main\\java"+父包名);
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("x_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
