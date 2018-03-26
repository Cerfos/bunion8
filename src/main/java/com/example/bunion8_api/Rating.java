package com.example.bunion8_api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="series_id", nullable=false)
	private SeriesInfo seriesInfo;
	
	
	private int stars;
	

	public SeriesInfo getSeriesInfo() {
		return seriesInfo;
	}

	public void setSeriesInfo(SeriesInfo seriesInfo) {
		this.seriesInfo = seriesInfo;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Long getId() {
		return id;
	}
	
	

}