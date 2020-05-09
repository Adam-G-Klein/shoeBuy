//const React = require('react');
//const ReactDOM = require('react-dom');

import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Home from './Home';
import Login from './Login';
import AllShoeViewer from './AllShoeViewer/AllShoeViewer.js';
import TestComponent from './TestComponent.js';

const routes  = (
	<Router>
		<Switch>
			<Route exact path = '/'>
				<Home />
			</Route>
			<Route exact path = '/login'>
				<Login />
			</Route>
			<Route exact path = '/allshoes'>
			    <AllShoeViewer />
			</Route>
		</Switch>
	</Router>
)
	


ReactDOM.render(
	routes,
	document.getElementById('Index')
);
