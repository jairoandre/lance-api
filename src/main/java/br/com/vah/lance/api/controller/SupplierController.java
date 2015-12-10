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
import br.com.vah.lance.api.model.Supplier;
import br.com.vah.lance.api.service.SupplierService;
import br.com.vah.lance.api.service.utils.Filter;
import br.com.vah.lance.api.service.utils.FilterType;

@Controller
@Path("suppliers")
public class SupplierController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject private SupplierService service;
    @Inject private Result result;

    @Get("list")
    public void list() {
        result.use(json()).from(service.findAll(), "suppliers").serialize();
    }

    @Get("{id}")
    public void get(Long id) {
        result.use(json()).from(service.load(id)).serialize();
    }
    
    @Consumes("application/json")
    @Post("filter")
    public void get(String title) {
        result.use(json()).from(service.filter(new Filter("title",FilterType.LIKE,title)),"suppliers").serialize();
    }

    @Consumes("application/json")
    @Post("add")
    public void add(Supplier supplier) {
        service.persist(supplier);
        result.redirectTo(this).list();
    }
}