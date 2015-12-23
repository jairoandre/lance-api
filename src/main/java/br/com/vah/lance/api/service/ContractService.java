package br.com.vah.lance.api.service;

import javax.ejb.Stateless;

import br.com.vah.lance.api.model.Contract;
import br.com.vah.lance.api.model.ServiceContract;

@Stateless
public class ContractService extends AbstractService<Contract>{

    public ContractService() {
		super(Contract.class);
	}
    
    @Override
    public Contract persist(Contract entity) {
    	if(entity.getServices() != null){
    		for(ServiceContract service : entity.getServices()){
    			service.setContract(entity);
    		}
    	}
    	return super.persist(entity);
    }
	
}
