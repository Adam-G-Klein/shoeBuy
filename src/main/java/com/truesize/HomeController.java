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

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Controller
public class HomeController {

	@Autowired
	private Logger logger;

	@RequestMapping(value = "/{path:?:(^(?!api)).*$}")
	public String index(@PathVariable("path") String variablePath) {
		logger.info("hit the controller!");
		System.out.println("hit path " + variablePath);
		return "index";
	}///src/main/etmpaltes

}
// end::code[]