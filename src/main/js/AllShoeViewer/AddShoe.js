import React from 'react';
import restClient from '../restClient.js';

class AddShoe extends React.Component {

	constructor(props) {
		super(props);
		this.state = {model: "initName", size: -1.0 };
	}

    postShoe(event){
        event.preventDefault();
        const newShoe = {modelName: this.state.model,
        size: this.state.size};
        restClient({method: "POST",
            path: "/api/userShoes",
            entity: newShoe,
            headers: {'Content-Type': 'application/json'}
             });
        window.location.reload(true);

    }
    handleModelChange(event){
        event.preventDefault();
        this.setState({model: event.target.value});
    }

    handleSizeChange(event){
        event.preventDefault();
        this.setState({size: event.target.value});
    }
	render() {
		return (
		    <div>
		        <div>
                    <p style={{color: 'white'}}>New Shoe Model Name:</p>
                    <input name="model" onChange={(event) => this.handleModelChange(event)} />
		        </div>
		        <div>
                    <p style={{color: 'white'}}>Size:</p>
                    <input name="size" onChange={(event) => this.handleSizeChange(event)} />
		        </div>
		        <button style={{position: 'relative', top: '10px'}} onClick={(event) => this.postShoe(event)}> Add Shoe </button>
			</div>
		)
	}
}

export default AddShoe;