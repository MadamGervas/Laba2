package map;

import dasha.ServiceClients;

public class ServiceClientsMap extends BaseOperationMap<ServiceClients>{
    @Override
    protected Class<ServiceClients> getType() {
        return ServiceClients.class;
    }

    @Override
    protected String getTableName() {
        return "ServiceClients";
    }
}
