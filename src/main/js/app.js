//const React = require('react');
//const ReactDOM = require('react-dom');
import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Home from './Home';
import Login from './Login';
import Header from './NavBar';
import Profile from './Profile';
import SizeRecommender from './SizeRecommender';
import ShoeRecommender from './ShoeRecommender';
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
//import 'bootstrap/dist/css/bootstrap.min.css';
import backgroundImage from '../resources/static/backgroundImage.jpg';

const routes  = (
	<Router>
		<Header />
		{/* <Image style = {{
			backgroundRepeat: 'no-repeat',
			backgroundSize: 'cover'
			}} src= {backgroundImage}/>		 */}
		<Switch>
			<Route exact path = '/'>
				<Home />
			</Route>
			<Route exact path = '/login'>
				<Login />
			</Route>
			<Route exact path = '/profile'>
				<Profile />
			</Route>
			<Route exact path = '/sizeRecommender'>
				<SizeRecommender />
			</Route>
			<Route exact path = '/shoeRecommender'>
				<ShoeRecommender />
			</Route>
		</Switch>
	</Router>
)
	


ReactDOM.render(
	routes,
	document.getElementById('Index')
);