package br.com.vah.lance.api.service;

import javax.ejb.Stateless;

import br.com.vah.lance.api.model.Sector;

@Stateless
public class SectorService extends AbstractService<Sector>{

    public SectorService() {
		super(Sector.class);
	}
	
}
