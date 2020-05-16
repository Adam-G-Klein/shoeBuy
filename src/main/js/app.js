//const React = require('react');
//const ReactDOM = require('react-dom');
import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Home from './Home';
import Login from './Login';
import Header from './NavBar';
import Profile from './Profile';
import AllShoeViewer from './AllShoeViewer/AllShoeViewer.js';
import SizeRecommender from './SizeRecommender';
import ShoeRecommender from './ShoeRecommender';
import Search from './Search';
import SearchResults from './SearchResults';
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import '../resources/static/backgroundImage.css';
//import 'bootstrap/dist/css/bootstrap.min.css';

var BackgroundImage = require('../resources/static/backgroundImage.jpg')

const routes  = (
	<Router>
		<Header />
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
			<Route exact path = '/sizeRecommender' render={
				(props) => <SizeRecommender {...props} />
			} />
			<Route exact path = '/shoeRecommender'>
				<ShoeRecommender />
			</Route>
			<Route exact path = '/search'>
				<Search />
			</Route>
			<Route exact path = '/searchResults'>
				<SearchResults />
			</Route>
			<Route exact path = '/allShoes'>
				<AllShoeViewer />
			</Route>
		</Switch>
	</Router>
)
	


ReactDOM.render(
	routes,
	document.getElementById('Index')
);