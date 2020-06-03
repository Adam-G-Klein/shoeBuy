import React from 'react';
import ShoeList from './ShoeList.js';
import AddShoe from './AddShoe.js';
import GetSizeRecommendation from './GetSizeRecommendation.js';
import restClient from '../restClient.js';

class AllShoeViewer extends React.Component {

	constructor(props) {
		super(props);
		this.state = {shoes: []};
	}

	componentDidMount() {
		restClient({method: 'GET', path: '/api/shoeNodes'}).done(response => {
			this.setState({shoes: response.entity._embedded.shoeNodes});
		});
	}

	render() {
		return (
		    <div style={{display: 'flex',flexDirection: 'row'}}>
		        <div>
                    <h1 style={{color: 'white'}}> All Shoes in the DataBase: </h1>
                    <ShoeList shoes={this.state.shoes}/>
                    <AddShoe />
                </div>
		        <div>
		            <GetSizeRecommendation />
                </div>
			</div>
		)
	}
}

export default AllShoeViewer;