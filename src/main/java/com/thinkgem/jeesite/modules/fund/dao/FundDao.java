/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.fund.entity.Fund;

/**
 * 基金CRUDDAO接口
 * @author Mars9527
 * @version 2018-04-16
 */
@MyBatisDao
public interface FundDao extends CrudDao<Fund> {
	
}