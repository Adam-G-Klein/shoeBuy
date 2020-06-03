//const React = require('react');
//const ReactDOM = require('react-dom');
import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Home from './Home';
import Login from './Login';
import Header from './Header';
import Profile from './Profile';
import AllShoeViewer from './AllShoeViewer/AllShoeViewer.js';
import SizeRecommender from './SizeRecommender';
import ShoeRecommender from './ShoeRecommender';
import Search from './Search';
import SearchResults from './SearchResults';
import Register from './Register';
import '../resources/static/backgroundImage.css';
//import 'bootstrap/dist/css/bootstrap.min.css';

const routes  = (
	<Router>
		<Switch>
			<Route exact path = '/'>
				<Header loggedIn = {false} pathname = {'/'}/>
				<Home />
			</Route>
			<Route exact path = '/login'>
				<Header loggedIn = {false} pathname = {'/login'}/>
				<Login />
			</Route>
			<Route exact path = '/profile'>
				<Header loggedIn = {true} pathname = {'/profile'}/>
				<Profile />
			</Route>
			<Route exact path = '/sizeRecommender' render={
				(props) => <div> <Header loggedIn = {true} pathname = {'/search'}/> <SizeRecommender {...props} /> </div>
			}/>
			<Route exact path = '/shoeRecommender'>
				<Header loggedIn = {true} pathname = {'/shoeRecommender'}/>			
				<ShoeRecommender />
			</Route>
			<Route exact path = '/search'>
				<Header loggedIn = {true} pathname = {'/search'}/>	
				<Search />
			</Route>
			<Route exact path = '/searchResults'>
				<Header loggedIn = {true} pathname = {'/search'}/>	
				<SearchResults />
			</Route>
			<Route exact path = '/allShoes'>
				<Header loggedIn = {true} pathname = {'/'}/>	
				<AllShoeViewer />
			</Route>
			<Route exact path = '/register'>
				<Header loggedIn = {false} pathname = {'/login'}/>	
				<Register />
			</Route>
		</Switch>
	</Router>
)
	


ReactDOM.render(
	routes,
	document.getElementById('Index')
);