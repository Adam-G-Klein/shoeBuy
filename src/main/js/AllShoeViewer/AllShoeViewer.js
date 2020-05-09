import React from 'react';
import ShoeList from './ShoeList.js';
import Shoe from './Shoe.js';
import restClient from '../restClient.js';

class AllShoeViewer extends React.Component {

	constructor(props) {
		super(props);
		this.state = {shoes: []};
	}

	componentDidMount() {
		restClient({method: 'GET', path: '/api/userShoes'}).done(response => {
			this.setState({shoes: response.entity._embedded.userShoes});
		});
	}

	render() {
		return (
		    <div>
		    <h1> All Shoes in the DataBase: </h1>
			<ShoeList shoes={this.state.shoes}/>
			</div>
		)
	}
}

export default AllShoeViewer;