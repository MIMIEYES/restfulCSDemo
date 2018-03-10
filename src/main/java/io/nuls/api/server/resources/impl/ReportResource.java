package io.nuls.api.server.resources.impl;

import io.nuls.api.client.entity.RpcClientResult;
import io.nuls.api.server.business.AliasBusiness;
import io.nuls.api.server.entity.Alias;
import io.nuls.api.server.entity.AliasParam;
import io.nuls.api.server.utils.log.Log;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static io.nuls.api.server.utils.SpringContext.CONTEXT;

@Path("/report")
public class ReportResource {

    private AliasBusiness aliasBusiness;

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public RpcClientResult loadBlock(@QueryParam("pageNumber") int pageNumber, @QueryParam("pageSize") int pageSize) {
        RpcClientResult result;
        try {
            System.out.println("this class instance hashcode ==== " + this.hashCode());
            aliasBusiness = CONTEXT.getBean(AliasBusiness.class);
            AliasParam aliasParam = new AliasParam();
            AliasParam.Criteria criteria = aliasParam.createCriteria();
            criteria.andAddressIsNotNull();
            List<Alias> aliases = aliasBusiness.selectAliasList(aliasParam);
            result = RpcClientResult.getSuccess();
            result.setData(aliases);
        } catch (Exception e) {
            result = RpcClientResult.getFailed();
            Log.error(e);
        }
        return result;
    }

}
