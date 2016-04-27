package be.vdab.services;

import java.util.List;

import be.vdab.entities.Album;
import be.vdab.repositories.AlbumRepository;

public class AlbumService {
	
	private final AlbumRepository albumRepository = new AlbumRepository();
	
	public List<Album> findAll() {
		return albumRepository.findAll();
	}
	
	public Album read(long id) {
		return albumRepository.read(id);
	}

}
