package be.vdab.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import be.vdab.entities.Album;
import be.vdab.filters.JPAFilter;

public class AlbumRepository {
	
	protected EntityManager getEntityManager() {
		return JPAFilter.getEntityManager();
	}
	
	public List<Album> findAll() {
		return getEntityManager().createNamedQuery("Album.findAll", Album.class)
				.getResultList();
	}

}
