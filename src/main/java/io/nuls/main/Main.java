package io.nuls.main;

import io.nuls.api.server.constant.RpcConstant;
import io.nuls.api.server.resources.impl.ReportResource;
import io.nuls.api.server.service.RpcServerService;
import io.nuls.api.server.utils.PropertiesUtils;
import io.nuls.api.server.utils.StringUtils;

import static io.nuls.api.server.utils.SpringContext.CONTEXT;

public enum  Main {
    MAIN;

    private String ip;
    private String port;
    private String moduleUrl;
    private RpcServerService serverService;

    public synchronized void init() {
        // initialize spring
        CONTEXT.initialize();
        this.ip = PropertiesUtils.readProperty(RpcConstant.CFG_RPC_SERVER_IP);
        this.port = PropertiesUtils.readProperty(RpcConstant.CFG_RPC_SERVER_PORT);
        this.moduleUrl = PropertiesUtils.readProperty(RpcConstant.CFG_RPC_SERVER_URL);
        this.serverService = (RpcServerService) CONTEXT.getBean("rpcServerServiceImpl");
    }

    public void startUp() {
        if (StringUtils.isBlank(ip) || StringUtils.isBlank(port)) {
            serverService.startServer(RpcConstant.DEFAULT_IP, RpcConstant.DEFAULT_PORT, RpcConstant.DEFAULT_URL);
        } else {
            serverService.startServer(ip, Integer.parseInt(port), moduleUrl);
        }
    }

    public static void main(String[] args) {
        Main.MAIN.init();
        Main.MAIN.startUp();
    }
}
