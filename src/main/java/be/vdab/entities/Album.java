package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

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

	public Artiest getArtiest() {
		return this.artiest;
	}

	public void setArtiest(Artiest artiest) {
		this.artiest = artiest;
	}
	
	public Set<Track> getTracks() {
//		return tracks.stream()
//				//.sorted()
//				.collect(Collectors.toCollection(()-> new TreeSet<Track>((track1, track2) -> track1.getNaam().compareTo(track2.getNaam()))));
		Set<Track> sortedTrack= new TreeSet<Track>((track1, track2) -> track1.getNaam().compareTo(track2.getNaam()));
		sortedTrack.addAll(tracks);
		return sortedTrack;
				
	}
	
	public String getTotaleSpeeltijd() {
		BigDecimal totaal = 
			tracks.stream()
			.map(Track::getTijd)
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return totaal.toString();
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

	@Override
	public String toString() {
		return naam;
	}
	
	

}