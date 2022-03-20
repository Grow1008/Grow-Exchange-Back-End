package com.grow.exchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coin_transaction_log")
public class CoinTransactionLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trn_id")
	private Long trnId;
	@Column(name = "trn_date")
	private String trnsDate ;
	@Column(name = "user_id")
	private String userId ;
	@Column(name="pre_coin")
	private String preCoin;
	@Column(name="req_coin")
	private String reqCoin;
	@Column(name="updated_coin")
	private String updatedCoin;
	@Column(name="event_name")
	private String eventName;
	
	public CoinTransactionLog() {
		super();
	}

	public CoinTransactionLog(Long trnId, String trnsDate, String userId, String preCoin, String reqCoin,
			String updatedCoin, String eventName) {
		super();
		this.trnId = trnId;
		this.trnsDate = trnsDate;
		this.userId = userId;
		this.preCoin = preCoin;
		this.reqCoin = reqCoin;
		this.updatedCoin = updatedCoin;
		this.eventName = eventName;
	}

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	public String getTrnsDate() {
		return trnsDate;
	}

	public void setTrnsDate(String trnsDate) {
		this.trnsDate = trnsDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPreCoin() {
		return preCoin;
	}

	public void setPreCoin(String preCoin) {
		this.preCoin = preCoin;
	}

	public String getReqCoin() {
		return reqCoin;
	}

	public void setReqCoin(String reqCoin) {
		this.reqCoin = reqCoin;
	}

	public String getUpdatedCoin() {
		return updatedCoin;
	}

	public void setUpdatedCoin(String updatedCoin) {
		this.updatedCoin = updatedCoin;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Override
	public String toString() {
		return "CoinTransactionLog [trnId=" + trnId + ", trnsDate=" + trnsDate + ", userId=" + userId + ", preCoin="
				+ preCoin + ", reqCoin=" + reqCoin + ", updatedCoin=" + updatedCoin + ", eventName=" + eventName + "]";
	}
	
	
	
}
