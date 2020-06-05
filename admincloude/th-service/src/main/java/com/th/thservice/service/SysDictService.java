package com.th.thservice.service;


import com.th.thservice.common.CurdService;
import com.th.thservice.entity.SysDict;

import java.util.List;

/**
 * 字典管理
 * @author Louis
 * @date Jan 13, 2019
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
