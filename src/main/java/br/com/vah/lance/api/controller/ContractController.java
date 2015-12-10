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
		result.use(json()).from(service.findAll(), "contracts").serialize();
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
    @Post("add")
    public void add(Contract entity) {
    	service.persist(entity);
        result.redirectTo(this).list();
    }
}
