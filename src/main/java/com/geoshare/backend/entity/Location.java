package com.geoshare.backend.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.geoshare.backend.parents.Ownable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="location")
public class Location implements Ownable {
	
	public Location(String url, String description, Country country,
			GeoshareUser user, Meta meta, BigDecimal lat, BigDecimal lng,
			Integer fov, BigDecimal heading, BigDecimal pitch, String previewUrl) {
		this.url = url;
		this.description = description;
		this.country = country;
		this.user = user;
		this.lists = new HashSet<>();
		this.listed = Long.valueOf(0);
		this.meta = meta;
		this.lat = lat;
		this.lng = lng;
		this.fov = fov;
		this.heading = heading;
		this.pitch = pitch;
		this.previewUrl = previewUrl;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="url", length=255)
	private String url;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
    
	@ManyToOne
	@JoinColumn(name="user_id")
	private GeoshareUser user;
	
	@ManyToMany(mappedBy="locations", fetch = FetchType.LAZY)
	private Set<LocationList> lists;
	
	@Column(name="listed")
	private Long listed;
	
	//TODO
	//Add numberOfLists field so we can easily determine if a location needs to be marked unlisted ?
	
	@ManyToOne
	@JoinColumn(name="meta_id")
	private Meta meta;
	
	@Column(name="lat")
	private BigDecimal lat;
	
	@Column(name="lng")
	private BigDecimal lng;

	@Column(name="fov")
	private Integer fov;
	
	@Column(name="heading")
	private BigDecimal heading;
	
	@Column(name="pitch")
	private BigDecimal pitch;
	
	@Column(name="preview_url")
	private String previewUrl;
}
