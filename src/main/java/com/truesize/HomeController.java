/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.truesize;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Arrays;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

	//list of Urls that don't require user to be logged in 
	List<String> preLoginRoutes = Arrays.asList("home", "login", "search", "SearchResults", "main.css", "favicon.ico");

	@Autowired
	private Logger logger;

	@Autowired
	public AccountService ac;

	@RequestMapping("/{path}")
	public String index(@PathVariable String path) {

		System.out.println("path: " + path + " loggedIN?: " + ac.loggedIn);

		if (!ac.loggedIn){
			if (!preLoginRoutes.contains(path)){
			 	System.out.println(path + " redirected to login");
			    return "redirect:/login";
			}	
		}	

		return "index";
	}

}
// end::code[]