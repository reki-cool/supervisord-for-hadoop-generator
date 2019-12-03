package com.duyanhan.handler;

import com.duyanhan.util.FreeMarkerUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 作用：根据模板生成文件
 */
@Slf4j
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MvcHandler {

    // 获取模板路径
    private String templateFilePath;

    public void generateSupervisorConf(String applicationName, String command, String user, String logDirParentPath, String supervisordConfOutputPath) {
        Map input = new HashMap();
        input.put("applicationName", applicationName);
        input.put("command", command);
        input.put("user", user);
        input.put("logDirParentPath", logDirParentPath);

        // 获取文件名
        String fileName = applicationName + ".conf";

        // 获取supervisor文件生成保存路径
        String savePath = supervisordConfOutputPath;

        // 获取模板名
        String templateName = "supervisord_configuration_for_application";

        // 生成文件
        FreeMarkerUtils.genteratorFile(input, templateFilePath, templateName, savePath, fileName);
    }

    public void generateMonitorShell(String applicationName,String pidFilePath, String command, String user, String monitorShellOutputPath) {
        Map input = new HashMap();
        input.put("applicationName", applicationName);
        input.put("pidFilePath", pidFilePath);
        input.put("command", command);
        input.put("user", user);

        // 获取文件名
        String fileName = applicationName + "_monitor.sh";

        // 获取supervisor文件生成保存路径
        String savePath = monitorShellOutputPath;

        // 获取模板名
        String templateName = "monitor_shell_for_application";

        // 生成文件
        FreeMarkerUtils.genteratorFile(input, templateFilePath, templateName, savePath, fileName);
    }

}
