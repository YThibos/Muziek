package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;

	private long albumid;
	private String naam;
	private BigDecimal tijd;
	
	protected Track() {}
	
	public Track(String naam, BigDecimal tijd) {
		this.naam = naam;
		this.tijd = tijd;
	}
	
}
