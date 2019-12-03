package com.duyanhan.config.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Common {
    private String monitorDirParentPath;
    private String pidDirParentPath;
    private String logDirParentPath;
    private String supervisordConfUser;
    private String monitorShellUser;
}
