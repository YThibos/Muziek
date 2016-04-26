package be.vdab.filters;

import java.util.List;

import be.vdab.entities.Album;
import be.vdab.repositories.AlbumRepository;

public class AlbumService {
	
	private final AlbumRepository albumRepository = new AlbumRepository();
	
	public List<Album> findAll() {
		return albumRepository.findAll();
	}

}
