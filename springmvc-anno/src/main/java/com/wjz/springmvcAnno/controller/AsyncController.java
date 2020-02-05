package com.wjz.springmvcAnno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.wjz.springmvcAnno.holder.UserHolder;

@Controller
public class AsyncController {

	@ResponseBody
	@GetMapping("/async")
	public DeferredResult<String> async() {
		DeferredResult<String> rel = new DeferredResult<>((long) 3000, "fail...");
		UserHolder.set(rel);
		return rel;
	}
	
	@ResponseBody
	@GetMapping("/sync")
	public String sync() {
		UserHolder.get().setResult("大家好...");
		return "success";
	}
}
