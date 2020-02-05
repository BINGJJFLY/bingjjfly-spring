package com.wjz.springmvcAnno.holder;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.web.context.request.async.DeferredResult;

public class UserHolder {

	private static Queue<DeferredResult<String>> users = new ConcurrentLinkedQueue<>();
	
	public static void set(DeferredResult<String> user) {
		users.add(user);
	}
	
	public static DeferredResult<String> get() {
		return users.poll();
	}
}
