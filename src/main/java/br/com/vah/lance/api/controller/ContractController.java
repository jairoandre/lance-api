package br.com.vah.lance.api.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.vah.lance.api.controller.utils.EnumMessages;
import br.com.vah.lance.api.controller.utils.MessageJson;
import br.com.vah.lance.api.model.Contract;
import br.com.vah.lance.api.service.ContractService;
import br.com.vah.lance.api.service.utils.Filter;
import br.com.vah.lance.api.service.utils.FilterType;


@Controller
@Path("contracts")
public class ContractController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject private ContractService service;
    @Inject private Result result;
    

    @Get("list")
    public void list() {
		result.use(json()).from(service.findAll(), "contracts").include("supplier","services","services.service").serialize();
    }

    @Get("{id}")
    public void get(Long id) {
    	Serializable objToJson = service.load(id);
    	if(objToJson == null){
    		objToJson = new MessageJson(EnumMessages.ERROR, "Not found");
    	}
    	result.use(json()).from(objToJson).serialize();
    }
    
    @Consumes("application/json")
    @Post("filter")
    public void get(String title) {
        result.use(json()).from(service.filter(new Filter("title",FilterType.LIKE,title)),"contracts").include("supplier","services","services.service").serialize();
    }

    @Consumes("application/json")
    @Post("add")
    public void add(Contract contract) {
    	result.use(json()).from(service.persist(contract)).serialize();
    }

    @Consumes("application/json")
    @Post("remove")
    public void remove(Long id) {
    	result.use(json()).from(service.remove(id)).serialize();
    }
    
}
