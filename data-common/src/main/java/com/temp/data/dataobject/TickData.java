package com.temp.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public final class TickData {
	private Date date; 
	private BigDecimal px;

	public TickData()
	{}
	
	public TickData(Date date, BigDecimal px) {
		super();
		this.date = date;
		this.px = px;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getPx() {
		return px;
	}
	
	public double getPxDouble() {
		return px.doubleValue();
	}

	public void setPx(BigDecimal px) {
		this.px = px;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((px == null) ? 0 : px.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TickData other = (TickData) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (px == null) {
			if (other.px != null)
				return false;
		} else if (!px.equals(other.px))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TickData [date=" + date + ", px=" + px + "]";
	}
	
}
