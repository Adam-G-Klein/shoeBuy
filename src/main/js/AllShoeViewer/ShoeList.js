import React from 'react';
import Shoe from './Shoe.js';

class ShoeList extends React.Component{
	render() {
		const shoeElements= this.props.shoes.map(shoe =>
			<Shoe key={shoe._links.self.href} shoe={shoe}/>
		);
		return (
            <ul> {shoeElements} </ul>
		)
	}
}

export default ShoeList;