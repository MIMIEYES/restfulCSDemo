package io.nuls.api.client.service;

import io.nuls.api.client.entity.RpcClientResult;
import io.nuls.api.client.utils.RestFulUtils;

public class SystemService {

    private static SystemService instance = new SystemService();

    public static SystemService getInstance() {
        return instance;
    }

    private RestFulUtils restFul = RestFulUtils.getInstance();

    public RpcClientResult getVersion() {
        return restFul.get("/sys/version", null);
    }
}
