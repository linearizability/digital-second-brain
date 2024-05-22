//package pers.boyuan.infrastructure.util;
//
//
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * 数据库逆向工程工具类
// *
// * @author ZhangBoyuan
// * @date 2022-06-11
// */
//public class DbGenerator {
//    //JDBC URL
//    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
//    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/digital_second_brain?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
//
//    //数据库用户名
//    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
//    public static final String DB_USER_NAME = "root";
//
//    //数据库用密码
//    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
//    public static final String DB_USER_PWD = "root";
//
//    //包名
//    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
//    public static final String PACKAGE_NAME = "pers.boyuan.infrastructure";
//
//    //模块名
//    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
//    public static final String MODULE_NAME = "db";
//
//    //代码生成路径
//    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
//    public static final String SRC = "/dsb-infrastructure/src/main/java";
//
//    //代码生成路径
//    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
//    public static final String OUT_PUT_SRC = "/dsb-infrastructure/src/main/resources/mybatis/";
//
//
//    //数据schema
////    public static final String DB_SCHEMA = "crm";
//
//    //数据库表
//    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
//    public static final String[] TABLE_NAME = {
//            "data_dictionary",
//    };
//
//    /**
//     * <p>
//     * 读取控制台内容
//     * </p>
//     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotEmpty(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    /**
//     * RUN THIS
//     */
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath + SRC)
//                .setAuthor("ZhangBoyuan")
//                // XML 二级缓存
//                .setEnableCache(false)
//                // 是否覆盖文件
//                .setFileOverride(true)
//                // XML ResultMap
//                .setBaseResultMap(true)
//                .setOpen(false);
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl(JDBC_URL)
////        dsc.setSchemaName(DB_SCHEMA)
//                .setDriverName("com.mysql.cj.jdbc.Driver")
//                .setUsername(DB_USER_NAME)
//                .setPassword(DB_USER_PWD);
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(MODULE_NAME)
//                .setParent(PACKAGE_NAME);
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + OUT_PUT_SRC //+ pc.getModuleName()
//                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel)
//                .setColumnNaming(NamingStrategy.underline_to_camel)
//                .setEntityLombokModel(true)
//                .setInclude(TABLE_NAME)
//        ;
//        mpg.setStrategy(strategy);
//        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//}
