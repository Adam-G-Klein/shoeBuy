import React from 'react';
import restClient from '../restClient.js';

class GetSizeRecommendation extends React.Component {

	constructor(props) {
		super(props);
		this.state = {model: "", brand: "", sex: "", recommendation: ""};
	}

	getRecommedation(event){
        restClient({method: "GET",
            path: "/api/sizeRecommend"
                + "?model=" + this.state.model
                + "&brand=" + this.state.brand
                + "&sex=" + this.state.sex,
            headers: {'Accept': 'application/json'}
            }
            )
            .done(response => {
                console.log(response);
                this.setState({recommendation: response.entity.response});
        });
        console.log(this.state.recommendation);

	}

    handleModelChange(event){
        event.preventDefault();
        this.setState({model: event.target.value});
    }

    handleBrandChange(event){
        event.preventDefault();
        this.setState({brand: event.target.value});
    }

    handleSexChange(event){
        event.preventDefault();
        this.setState({brand: event.target.value});
    }

	render() {
		return (
		    <div>
		        <h1 style={{color: 'white'}}> Get a Size Recommendation</h1>
                <div>
                    <p style={{color: 'white'}}>Model</p>
                    <input name="model" onChange={(event) => this.handleModelChange(event)} />
                </div>
                <div>
                    <p style={{color: 'white'}}>Brand</p>
                    <input name="size" onChange={(event) => this.handleBrandChange(event)} />
                </div>
                <div>
                    <p style={{color: 'white'}}>Sex</p>
                    <input name="sex" onChange={(event) => this.handleSexChange(event)} />
                </div>
		        <button style={{margin: "10px 0px 10px"}}
		            onClick={(event) => this.getRecommedation(event)}> Get Size Recommendation</button>
		        <p style={{color: 'white'}}>Your Recommendation: {this.state.recommendation} </p>
			</div>
		)
	}
}

export default GetSizeRecommendation;
