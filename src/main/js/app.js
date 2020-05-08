//const React = require('react');
//const ReactDOM = require('react-dom');

import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Home from './Home';
import Login from './Login';

const routes  = (
	<Router>
		<Switch>
			<Route exact path = '/'>
				<Home />
			</Route>
			<Route exact path = '/login'>
				<Login />
			</Route>
		</Switch>
	</Router>
)
	


ReactDOM.render(
	routes,
	document.getElementById('Index')
);
