package com.example.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.sun.istack.internal.NotNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class DefaultMybatisPlusGenerator extends AutoGenerator {
    private boolean generateControllers = false;
    private boolean generateServices = false;
    private boolean generateMappers = false;
    private boolean generateXMLs = false;
    private boolean generateEntities = true;
    private boolean fileOverride = false;
    private String database;
    private String author;
    private String moduleName;
    private String[] tableNames;
    private String username;
    private String password;
    private final String url;
    private final String driverName;
    private final String packageName;

    public DefaultMybatisPlusGenerator(@NotNull String database, @NotNull String author, @NotNull String moduleName,
                                       @NotNull String[] tableNames, @NotNull String url, @NotNull String driverName,
                                       @NotNull String packageName, @NotNull String username, @NotNull String password) {
        this.database = Objects.requireNonNull(database);
        this.author = Objects.requireNonNull(author);
        this.moduleName = Objects.requireNonNull(moduleName);
        this.tableNames = Objects.requireNonNull(tableNames);
        this.url = Objects.requireNonNull(url);
        this.driverName = Objects.requireNonNull(driverName);
        this.packageName = Objects.requireNonNull(packageName);
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
    }

    private GlobalConfig getGlobalConfig(@NotNull String author) {
        String projectPath = System.getProperty("user.dir");
        String outputDir = projectPath + "/src/main/java";
        return (new GlobalConfig())
                .setOutputDir(outputDir)
                .setFileOverride(this.isFileOverride())
                .setAuthor(Objects.requireNonNull(author))
                .setOpen(false)
                .setSwagger2(true);
    }

    private DataSourceConfig getDataSourceConfig(@NotNull String database) {
        return (new DataSourceConfig())
                .setUrl(url + Objects.requireNonNull(database) + "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai")
                .setDriverName(driverName)
                .setUsername(this.username)
                .setPassword(this.password);
    }

    private PackageConfig getPackageConfig(@NotNull String moduleName) {
        return (new PackageConfig()).setModuleName(Objects.requireNonNull(moduleName)).setParent(packageName);
    }

    private TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        if (!this.generateControllers) {
            templateConfig.setController(null);
        }

        if (!this.generateServices) {
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
        }

        if (!this.generateMappers) {
            templateConfig.setMapper(null);
        }

        if (!this.generateXMLs) {
            templateConfig.setXml(null);
        }

        if (!this.generateEntities) {
            templateConfig.setEntity(null);
        }

        return templateConfig;
    }

    public DefaultMybatisPlusGenerator setTemplateConfig(@Nullable Boolean generateControllers, @Nullable Boolean generateServices, @Nullable Boolean generateMappers, @Nullable Boolean generateXMLs, @Nullable Boolean generateEntities) {
        this.generateControllers = generateControllers != null && generateControllers;
        this.generateServices = generateServices != null && generateServices;
        this.generateMappers = generateMappers != null && generateMappers;
        this.generateXMLs = generateXMLs != null && generateXMLs;
        this.generateEntities = generateEntities == null || generateEntities;
        return this;
    }

    private FreemarkerTemplateEngine getDefaultTemplateEngine() {
        return new FreemarkerTemplateEngine();
    }

    private StrategyConfig getStrategyConfig(@NotNull String[] tableNames, @NotNull String moduleName) {
        return (new StrategyConfig()).setNaming(NamingStrategy.underline_to_camel).setColumnNaming(NamingStrategy.underline_to_camel).setEntityLombokModel(true).setRestControllerStyle(true).setInclude(Objects.requireNonNull(tableNames)).setControllerMappingHyphenStyle(true).setTablePrefix(Objects.requireNonNull(moduleName) + "_");
    }

    public void execute() {
        if (this.getGlobalConfig() == null) {
            this.setGlobalConfig(this.getGlobalConfig(Objects.requireNonNull(this.author)));
        }

        if (this.getDataSource() == null) {
            this.setDataSource(this.getDataSourceConfig(Objects.requireNonNull(this.database)));
        }

        if (this.getPackageInfo() == null) {
            this.setPackageInfo(this.getPackageConfig(Objects.requireNonNull(this.moduleName)));
        }

        if (this.getTemplateEngine() == null) {
            this.setTemplateEngine(this.getDefaultTemplateEngine());
        }

        if (this.getTemplate() == null) {
            this.setTemplate(this.getTemplateConfig());
        }

        if (this.getStrategy() == null) {
            this.setStrategy(this.getStrategyConfig(Objects.requireNonNull(this.tableNames), Objects.requireNonNull(this.moduleName)));
        }

        super.execute();
    }

    public boolean isGenerateControllers() {
        return this.generateControllers;
    }

    public boolean isGenerateServices() {
        return this.generateServices;
    }

    public boolean isGenerateMappers() {
        return this.generateMappers;
    }

    public boolean isGenerateXMLs() {
        return this.generateXMLs;
    }

    public boolean isGenerateEntities() {
        return this.generateEntities;
    }

    public boolean isFileOverride() {
        return this.fileOverride;
    }

    public String getDatabase() {
        return this.database;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public String[] getTableNames() {
        return this.tableNames;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public DefaultMybatisPlusGenerator setGenerateControllers(final boolean generateControllers) {
        this.generateControllers = generateControllers;
        return this;
    }

    public DefaultMybatisPlusGenerator setGenerateServices(final boolean generateServices) {
        this.generateServices = generateServices;
        return this;
    }

    public DefaultMybatisPlusGenerator setGenerateMappers(final boolean generateMappers) {
        this.generateMappers = generateMappers;
        return this;
    }

    public DefaultMybatisPlusGenerator setGenerateXMLs(final boolean generateXMLs) {
        this.generateXMLs = generateXMLs;
        return this;
    }

    public DefaultMybatisPlusGenerator setGenerateEntities(final boolean generateEntities) {
        this.generateEntities = generateEntities;
        return this;
    }

    public DefaultMybatisPlusGenerator setFileOverride(final boolean fileOverride) {
        this.fileOverride = fileOverride;
        return this;
    }

    public DefaultMybatisPlusGenerator setDatabase(final String database) {
        this.database = database;
        return this;
    }

    public DefaultMybatisPlusGenerator setAuthor(final String author) {
        this.author = author;
        return this;
    }

    public DefaultMybatisPlusGenerator setModuleName(final String moduleName) {
        this.moduleName = moduleName;
        return this;
    }

    public DefaultMybatisPlusGenerator setTableNames(final String[] tableNames) {
        this.tableNames = tableNames;
        return this;
    }

    public DefaultMybatisPlusGenerator setUsername(final String username) {
        this.username = username;
        return this;
    }

    public DefaultMybatisPlusGenerator setPassword(final String password) {
        this.password = password;
        return this;
    }
}