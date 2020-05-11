import React from 'react';
import restClient from '../restClient.js';

class AddShoe extends React.Component {

	constructor(props) {
		super(props);
		this.state = {model: "initName", size: -1.0 };
	}

    postShoe(){
        const newShoe = {modelName: this.state.model,
        size: this.state.size};
        restClient({method: "POST",
            path: "/api/userShoes",
            entity: newShoe,
            headers: {'Content-Type': 'application/json'} });

    }
    handleModelChange(event){
        this.setState({model: event.target.value});
    }

    handleSizeChange(event){
        this.setState({size: event.target.value});
    }
	render() {
		return (
		    <div>
		        <div>
                    <p>New Shoe Model Name:</p>
                    <input name="model" onChange={(event) => this.handleModelChange(event)} />
		        </div>
		        <div>
                    <p>Size:</p>
                    <input name="size" onChange={(event) => this.handleSizeChange(event)} />
		        </div>
		        <button onClick={this.postShoe()}> Add Shoe </button>
			</div>
		)
	}
}

export default AddShoe;