package com.cg.dms.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8033530529788101286L;

	@Id
	private int paymentId;
	private LocalDateTime dateTime;
	@NotNull(message = "Bill number shouble be manadatory*")
	private float bill;
	@NotNull
	private int milkUnits;
	private double unitPrice;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public int getMilkUnits() {
		return milkUnits;
	}

	public void setMilkUnits(int milkUnits) {
		this.milkUnits = milkUnits;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
