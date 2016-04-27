package be.vdab.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artiesten database table.
 * 
 */
@Entity
@Table(name="artiesten")
@NamedQuery(name="Artiest.findAll", query="SELECT a FROM Artiest a")
public class Artiest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String naam;

	//bi-directional many-to-one association to Album
	@OneToMany(mappedBy="artiest")
	private List<Album> albums;

	public Artiest() {
	}

	public long getId() {
		return this.id;
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Album addAlbum(Album album) {
		getAlbums().add(album);
		album.setArtiest(this);

		return album;
	}

	public Album removeAlbum(Album album) {
		getAlbums().remove(album);
		album.setArtiest(null);

		return album;
	}

	@Override
	public int hashCode() {
		return naam.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Artiest)) {
			return false;
		}
		Artiest otherArtiest = (Artiest) obj;
		return this.naam.equals(otherArtiest.naam);
	}

	@Override
	public String toString() {
		return naam;
	}
	
}