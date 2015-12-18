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
import br.com.vah.lance.api.model.Sector;
import br.com.vah.lance.api.service.SectorService;

@Controller
@Path("sectors")
public class SectorController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject private SectorService service;
    @Inject private Result result;

    @Get("list")
    public void list() {
        result.use(json()).from(service.findAll(), "sectors").serialize();
    }

    @Get("{id}")
    public void get(Long id) {
        result.use(json()).from(service.load(id)).serialize();
    }

    @Consumes("application/json")
    @Post("add")
    public void add(Sector sector) {
    	result.use(json()).from(service.persist(sector)).serialize();
    }
    
    @Consumes("application/json")
    @Post("remove")
    public void remove(Long id) {
    	result.use(json()).from(service.remove(id)).serialize();
    }
}