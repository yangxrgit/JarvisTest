package Jarvis.test.util;

import com.vimalselvam.testng.SystemInfo;
import org.testng.collections.Maps;

import java.util.Map;

//修改extentReport中的Dashboard的信息 ---加入testLogin.xml
public class TestSystemInfo implements SystemInfo {

    public Map<String, String> getSystemInfo() {
            Map<String, String> systemInfo = Maps.newHashMap();
            systemInfo.put("Test Env", "QA");
            systemInfo.put("Browser", "Chrome");
            systemInfo.put("测试执行人", "杨晓茹");
            return systemInfo;
    }
}