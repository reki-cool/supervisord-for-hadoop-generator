package com.duyanhan.controller;

import com.duyanhan.config.GeneratorProperties;
import com.duyanhan.config.property.*;
import com.duyanhan.handler.MvcHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeneratorController {

    @Autowired
    private GeneratorProperties generatorProperties;

    @GetMapping("/")
    public GeneratorProperties test() {
        return generatorProperties;
    }

    @GetMapping("/generate")
    public String generateCode() {
        // 获取所有要生成supervisor配置文件和监控脚本的APP
        List<Application> applications = generatorProperties.getApplications();
        // 获取基本配置信息
        Base base = generatorProperties.getBase();
        // 获取公共配置信息
        Common common = generatorProperties.getCommon();
        // 获取输出路径信息
        Generator generator = generatorProperties.getGenerator();
        // 获取mvcHandler对象
        MvcHandler mvcHandler = new MvcHandler(base.getTemplateFilePath());

        for (Application application : applications) {
            // 获取程序名称
            String applicationName = application.getApplicationName();
            // 获取supervisor配置文件相关信息
            SupervisordConf supervisordConf = application.getSupervisordConf();
            // 获取监控脚本的相关信息
            MonitorShell monitorShell = application.getMonitorShell();

            // 生成supervisor配置文件
            mvcHandler.generateSupervisorConf(applicationName, supervisordConf.getCommand(), supervisordConf.getUser(), common.getLogDirParentPath(), generator.getSupervisordConfOutputPath());

            // 生成监控脚本文件
            mvcHandler.generateMonitorShell(applicationName, monitorShell.getPidFilePath(), monitorShell.getCommand(), monitorShell.getUser(), generator.getMonitorShellOutputPath());
        }

        return generatorProperties.toString();
    }
}
