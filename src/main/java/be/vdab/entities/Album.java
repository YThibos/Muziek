package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import be.vdab.valueobjects.Track;


/**
 * The persistent class for the albums database table.
 * 
 */
@Entity
@Table(name="albums")
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String naam;

	//bi-directional many-to-one association to Artiest
	@ManyToOne(fetch=FetchType.LAZY, optional = false)
	@JoinColumn(name="artiestid")
	private Artiest artiest;
	
	@ElementCollection
	@CollectionTable(name = "tracks", joinColumns=@JoinColumn(name="albumid"))
	private Set<Track> tracks;
	
	public Album() {
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

	public Artiest getArtiesten() {
		return this.artiest;
	}

	public void setArtiesten(Artiest artiesten) {
		this.artiest = artiesten;
	}
	
	public Set<Track> getTracks() {
		return tracks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artiest == null) ? 0 : artiest.hashCode());
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Album))
			return false;
		Album other = (Album) obj;
		if (artiest == null) {
			if (other.artiest != null)
				return false;
		} else if (!artiest.equals(other.artiest))
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

}