package com.ltts.demoapplication.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {
	@Id
	@GeneratedValue
	private int mid;
	private String mname;
	private String production;
	private String hero;
	private String heroine;
	private String mtype;
	private String lang;
	private LocalDate releasedate;
	public Movie(int mid, String mname, String production, String hero, String heroine, String mtype, String lang,
			LocalDate releasedate) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.production = production;
		this.hero = hero;
		this.heroine = heroine;
		this.mtype = mtype;
		this.lang = lang;
		this.releasedate = releasedate;
	}
	public Movie() {
		super();
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public String getHeroine() {
		return heroine;
	}
	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public LocalDate getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(LocalDate releasedate) {
		this.releasedate = releasedate;
	}
	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", mname=" + mname + ", production=" + production + ", hero=" + hero + ", heroine="
				+ heroine + ", mtype=" + mtype + ", lang=" + lang + ", releasedate=" + releasedate + "]";
	}
	
}
