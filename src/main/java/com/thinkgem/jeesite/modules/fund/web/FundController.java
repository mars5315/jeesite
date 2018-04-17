/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fund.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.fund.entity.Fund;
import com.thinkgem.jeesite.modules.fund.service.FundService;

/**
 * 基金CRUDController
 * @author Mars9527
 * @version 2018-04-16
 */
@Controller
@RequestMapping(value = "${adminPath}/fund/fund")
public class FundController extends BaseController {

	@Autowired
	private FundService fundService;
	
	@ModelAttribute
	public Fund get(@RequestParam(required=false) String id) {
		Fund entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fundService.get(id);
		}
		if (entity == null){
			entity = new Fund();
		}
		return entity;
	}
	
	@RequiresPermissions("fund:fund:view")
	@RequestMapping(value = {"list", ""})
	public String list(Fund fund, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Fund> page = fundService.findPage(new Page<Fund>(request, response), fund); 
		model.addAttribute("page", page);
		return "modules/fund/fundList";
	}

	@RequiresPermissions("fund:fund:view")
	@RequestMapping(value = "form")
	public String form(Fund fund, Model model) {
		model.addAttribute("fund", fund);
		return "modules/fund/fundForm";
	}

	@RequiresPermissions("fund:fund:edit")
	@RequestMapping(value = "save")
	public String save(Fund fund, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fund)){
			return form(fund, model);
		}
		fundService.save(fund);
		addMessage(redirectAttributes, "保存基金成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fund/?repage";
	}
	
	@RequiresPermissions("fund:fund:edit")
	@RequestMapping(value = "delete")
	public String delete(Fund fund, RedirectAttributes redirectAttributes) {
		fundService.delete(fund);
		addMessage(redirectAttributes, "删除基金成功");
		return "redirect:"+Global.getAdminPath()+"/fund/fund/?repage";
	}

}