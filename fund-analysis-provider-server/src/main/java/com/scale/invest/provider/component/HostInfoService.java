package com.scale.invest.provider.component;

import com.xiaoleilu.hutool.system.HostInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HostInfoService {

    @Value("${server.port}")
    private String serverPort;
    HostInfo hostInfo = new HostInfo();

    public String getServerPort() {
        return serverPort;
    }

    public String getServerIp() {
        return hostInfo.getAddress();
    }

    public String getFormatHostIpInfo() {
        return this.getServerIp() + ":" + this.serverPort;
    }
}
