package com.perpro.rest.common.controller;

import com.perpro.rest.common.mapper.BaseMapper;

public interface BaseController {

	public BaseMapper<?, ?> getMapper();

}
