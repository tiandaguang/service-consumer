package com.boot.demo.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + ":");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "D:/demo";
        gc.setOutputDir(projectPath);//生成目文件的输出目录
        gc.setAuthor("***");//开发人员
        gc.setOpen(false);//文件生成后，是否需要打开所在路径
        gc.setFileOverride(true);//是否覆盖已有文件
        gc.setEnableCache(false);//是否在xml中添加二级缓存设置
        gc.setActiveRecord(false);//开启ActiveRecord模式
        gc.setBaseResultMap(true);//开启BaseResultMap
        gc.setBaseColumnList(true);//开启BaseColumnList
        gc.setDateType(DateType.TIME_PACK);//时间类型对应策略
        gc.setControllerName("%sController");
        gc.setEntityName("%s");//实体命名方式
        gc.setServiceName("%sService");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setIdType(IdType.AUTO);

        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.117.10:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);


        //包配置
        PackageConfig pc = new PackageConfig();
        //父包名，如果为空，将下面子包名必须写全部，否则就只需写子包名
        pc.setParent("com.qb.nft");
        //父包模块名称
        pc.setModuleName(scanner("模块名"));
        mpg.setPackageInfo(pc);

        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        //自定义输出配置
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        //自定义配置会被优先输出
        fileOutConfigs.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件名
                return projectPath + "/mapper/mapping/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(fileOutConfigs);//配置FileOutConfig指定模板文件、输出文件达到自定义文件生成目的
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                //这里结合Lombok使用，有true,无false
                .setEntityLombokModel(true)
                .setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        //strategyConfig.setInclude();
        strategyConfig.setSuperEntityColumns("id");
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategyConfig);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }

}