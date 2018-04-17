package com.thinkgem.jeesite.test;

import com.thinkgem.jeesite.common.utils.NetworkUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.fund.entity.Fund;
import com.thinkgem.jeesite.modules.fund.service.FundService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml"})//
public class Test_Fund {
	@Resource
	private FundService fundService;

	@Test
	public void testConn() {
		System.out.println("打印："+fundService);
	}


	@Test
	public void test_spiderFundDatas() {
		boolean end=false;
		int page=1;
		while (!end) {
			String url="https://fundapi.eastmoney.com/fundtradenew.aspx?ft=hb&sc=ljjz&st=desc&pi="+page+"&pn=100&cp=&ct=&cd=&ms=100&fr=&plevel=&fst=&ftype=&fr1=&fl=0&isab=";
			String result = NetworkUtils.sendGet(url);
			String pre="var rankData = ";
			String content = result.substring(pre.length(),result.length()-1);
			JSONObject json = JSONObject.fromObject(content);
			JSONArray jsonArray = (JSONArray) json.get("datas");
			for (Object object : jsonArray) {
				String entityStr=object.toString();
				String[] entityArray = entityStr.split("\\|");
				Fund fund=getFundByArray(entityArray);
				fundService.save(fund);
			}
			int allPages = Integer.parseInt(json.get("allPages")+"");
			int pageIndex = Integer.parseInt(json.get("pageIndex")+"");
			if(pageIndex==allPages) end=true;
			page++;
			System.out.println("page:"+pageIndex+"已存储");


		}
	}

	@Test
	public void test_getFundDatas() {
		List<Fund> list = fundService.findList(new Fund());
		for (Fund fund : list) {
			System.out.println(fund);
		}
	}



	private Fund getFundByArray(String[] entityArray) {
		Fund fund;
		try {
			fund=new Fund();
			fund.setFundno(entityArray[0]);
			fund.setFundname(entityArray[1]);
			fund.setType(entityArray[2]);
			fund.setReleasedate(new SimpleDateFormat("yyyy-MM-dd").parse(entityArray[3]));
			fund.setProfit(getBigDecimal(entityArray[4])+"");
			fund.setProfit7d(getBigDecimal(entityArray[5])+"");
			fund.setProfit14d(getBigDecimal(entityArray[6])+"");
			fund.setProfit28d(getBigDecimal(entityArray[7])+"");
			fund.setProfit35d(getBigDecimal(entityArray[8])+"");
			fund.setProfit1m(getBigDecimal(entityArray[17])+"");
			fund.setProfit3m(getBigDecimal(entityArray[18])+"");
			fund.setProfit6m(getBigDecimal(entityArray[19])+"");
			fund.setProfit1y(getBigDecimal(entityArray[20])+"");
			fund.setProfity(getBigDecimal(entityArray[21])+"");
			String chargeStr=entityArray[26];
			chargeStr=chargeStr.substring(0, chargeStr.length()-1);
			fund.setCharge(getBigDecimal(chargeStr)+"");
			String miniBuyStr=entityArray[24];
			miniBuyStr=miniBuyStr.substring(0, miniBuyStr.length()-1);
			fund.setMinibuy(getBigDecimal(miniBuyStr)+"");
		}catch (ParseException e) {
			fund=null;
			e.printStackTrace();
		}catch (Exception e) {
			fund=null;
			e.printStackTrace();
		}
		return fund;
	}

	BigDecimal getBigDecimal(String str){
		return StringUtils.isNull(str) ? BigDecimal.ZERO : new BigDecimal(str);
	}
}
