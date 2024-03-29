package com.bookstore.entity;
// Generated Aug 27, 2019, 7:32:12 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderDetailId generated by hbm2java
 */
@Embeddable
public class OrderDetailId implements java.io.Serializable {

	private int orderId;
	private Integer bookId;
	private int quantty;
	private float subTotal;

	public OrderDetailId() {
	}

	public OrderDetailId(int orderId, int quantty, float subTotal) {
		this.orderId = orderId;
		this.quantty = quantty;
		this.subTotal = subTotal;
	}

	public OrderDetailId(int orderId, Integer bookId, int quantty, float subTotal) {
		this.orderId = orderId;
		this.bookId = bookId;
		this.quantty = quantty;
		this.subTotal = subTotal;
	}

	@Column(name = "order_id", nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "book_id")
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "quantty", nullable = false)
	public int getQuantty() {
		return this.quantty;
	}

	public void setQuantty(int quantty) {
		this.quantty = quantty;
	}

	@Column(name = "sub_total", nullable = false, precision = 12, scale = 0)
	public float getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderDetailId))
			return false;
		OrderDetailId castOther = (OrderDetailId) other;

		return (this.getOrderId() == castOther.getOrderId())
				&& ((this.getBookId() == castOther.getBookId()) || (this.getBookId() != null
						&& castOther.getBookId() != null && this.getBookId().equals(castOther.getBookId())))
				&& (this.getQuantty() == castOther.getQuantty()) && (this.getSubTotal() == castOther.getSubTotal());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderId();
		result = 37 * result + (getBookId() == null ? 0 : this.getBookId().hashCode());
		result = 37 * result + this.getQuantty();
		result = 37 * result + (int) this.getSubTotal();
		return result;
	}

}
