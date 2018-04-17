/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 基金CRUDEntity
 * @author Mars9527
 * @version 2018-04-16
 */
public class Fund extends DataEntity<Fund> {
	
	private static final long serialVersionUID = 1L;
	private String fundname;		// 基金名称
	private String fundno;		// 基金编号
	private Date releasedate;		// 发布时间
	private String type;		// 基金类型
	private String profit;		// 万份收益
	private String profit7d;		// 7日年化
	private String profit14d;		// 14日年化
	private String profit28d;		// 28日年化
	private String profit35d;		// 35日年化
	private String profit1m;		// 近1月年化
	private String profit3m;		// 近3月年化
	private String profit6m;		// 近6月年化
	private String profit1y;		// 近1年年化
	private String profity;		// 今年来年化
	private String charge;		// 手续费
	private String minibuy;		// 起购金额
	
	public Fund() {
		super();
	}

	public Fund(String id){
		super(id);
	}

	@Length(min=0, max=20, message="基金名称长度必须介于 0 和 20 之间")
	public String getFundname() {
		return fundname;
	}

	public void setFundname(String fundname) {
		this.fundname = fundname;
	}
	
	@Length(min=0, max=20, message="基金编号长度必须介于 0 和 20 之间")
	public String getFundno() {
		return fundno;
	}

	public void setFundno(String fundno) {
		this.fundno = fundno;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	
	@Length(min=0, max=20, message="基金类型长度必须介于 0 和 20 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}
	
	public String getProfit7d() {
		return profit7d;
	}

	public void setProfit7d(String profit7d) {
		this.profit7d = profit7d;
	}
	
	public String getProfit14d() {
		return profit14d;
	}

	public void setProfit14d(String profit14d) {
		this.profit14d = profit14d;
	}
	
	public String getProfit28d() {
		return profit28d;
	}

	public void setProfit28d(String profit28d) {
		this.profit28d = profit28d;
	}
	
	public String getProfit35d() {
		return profit35d;
	}

	public void setProfit35d(String profit35d) {
		this.profit35d = profit35d;
	}
	
	public String getProfit1m() {
		return profit1m;
	}

	public void setProfit1m(String profit1m) {
		this.profit1m = profit1m;
	}
	
	public String getProfit3m() {
		return profit3m;
	}

	public void setProfit3m(String profit3m) {
		this.profit3m = profit3m;
	}
	
	public String getProfit6m() {
		return profit6m;
	}

	public void setProfit6m(String profit6m) {
		this.profit6m = profit6m;
	}
	
	public String getProfit1y() {
		return profit1y;
	}

	public void setProfit1y(String profit1y) {
		this.profit1y = profit1y;
	}
	
	public String getProfity() {
		return profity;
	}

	public void setProfity(String profity) {
		this.profity = profity;
	}
	
	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	public String getMinibuy() {
		return minibuy;
	}

	public void setMinibuy(String minibuy) {
		this.minibuy = minibuy;
	}

	@Override
	public String toString() {
		return "Fund{" +
				"fundname='" + fundname + '\'' +
				", fundno='" + fundno + '\'' +
				", releasedate=" + releasedate +
				", type='" + type + '\'' +
				", profit='" + profit + '\'' +
				", profit7d='" + profit7d + '\'' +
				", profit14d='" + profit14d + '\'' +
				", profit28d='" + profit28d + '\'' +
				", profit35d='" + profit35d + '\'' +
				", profit1m='" + profit1m + '\'' +
				", profit3m='" + profit3m + '\'' +
				", profit6m='" + profit6m + '\'' +
				", profit1y='" + profit1y + '\'' +
				", profity='" + profity + '\'' +
				", charge='" + charge + '\'' +
				", minibuy='" + minibuy + '\'' +
				'}';
	}
}