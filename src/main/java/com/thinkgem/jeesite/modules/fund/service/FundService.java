/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.fund.entity.Fund;
import com.thinkgem.jeesite.modules.fund.dao.FundDao;

/**
 * 基金CRUDService
 * @author Mars9527
 * @version 2018-04-16
 */
@Service
@Transactional(readOnly = true)
public class FundService extends CrudService<FundDao, Fund> {

	public Fund get(String id) {
		return super.get(id);
	}
	
	public List<Fund> findList(Fund fund) {
		return super.findList(fund);
	}
	
	public Page<Fund> findPage(Page<Fund> page, Fund fund) {
		return super.findPage(page, fund);
	}
	
	@Transactional(readOnly = false)
	public Fund save(Fund fund) {
		return super.save(fund);
	}
	
	@Transactional(readOnly = false)
	public void delete(Fund fund) {
		super.delete(fund);
	}
	
}