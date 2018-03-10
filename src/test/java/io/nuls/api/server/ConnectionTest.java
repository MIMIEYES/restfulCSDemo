package io.nuls.api.server;

import io.nuls.api.client.entity.RpcClientResult;
import io.nuls.api.server.service.RpcServerService;
import io.nuls.api.server.service.impl.RpcServerServiceImpl;
import io.nuls.api.server.utils.log.Log;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class ConnectionTest {
    private RpcServerService serverService;
    private String serverUri;
    private Client client;

    @Before
    public void init() {
        client = ClientBuilder.newClient();
        serverUri = "http://127.0.0.1:6666/test";
        serverService = new RpcServerServiceImpl();
        serverService.startServer("127.0.0.1", 6666, "test");
    }

    @Test
    public void connectionTest() {
        RpcClientResult result = get("/tx/hash/0xa9bace87f9e87abc6edf", null);
        Log.debug(result.toString());
        Assert.assertEquals("success", result.getMsg());
    }

    private RpcClientResult get(String path, Map<String, String> params) {
        if (null == serverUri) {
            throw new RuntimeException("service url is null");
        }
        WebTarget target = client.target(serverUri).path(path);
        if (null != params && !params.isEmpty()) {
            for (String key : params.keySet()) {
                target.queryParam(key, params.get(key));
            }
        }
        return target.request(APPLICATION_JSON).get(RpcClientResult.class);
    }

    @After
    public void stop() {
        serverService.shutdown();
    }
}
