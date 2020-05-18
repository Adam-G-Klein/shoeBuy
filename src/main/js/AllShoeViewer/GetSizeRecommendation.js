import React from 'react';
import ShoeList from './ShoeList.js';
import restClient from '../restClient.js';

class GetSizeRecommendation extends React.Component {

	constructor(props) {
		super(props);
		this.state = {};
	}

	componentDidMount() {
		restClient({method: 'GET', path: '/api/userShoes'}).done(response => {
			this.setState({shoes: response.entity._embedded.userShoes});
		});
	}

	render() {
		return (
		    <div>
                <h1 style={{color: 'white'}}> All Shoes in the DataBase: </h1>
                <ShoeList shoes={this.state.shoes}/>
                <AddShoe />
			</div>
		)
	}
}

export default AllShoeViewer;
