import React from 'react';
import { Card, Col, Container, Row } from 'react-bootstrap';
import shoeImage from '../resources/static/exampleShoe.jpg';
import ShoeStats from './ShoeStats';
import restClient from './restClient.js';

const HorizLineBottom = ({ color }) => (
    <hr
        style={{
            color: color,
            backgroundColor: color,
			height: .5,
			marginBottom: 0
        }}
    />
);

const HorizLineTop = ({ color }) => (
    <hr
        style={{
            color: color,
            backgroundColor: color,
			height: .5,
        }}
    />
);

class SizeRecommender extends React.Component {
	constructor(props) {
		super(props)
		this.state ={
			size: null
		}
	}

	componentDidMount() {
		restClient({method: "GET",
			path: "/api/sizeRecommend?model=" + this.props.location.shoeInfo.model + "&brand=" + this.props.location.shoeInfo.brand +
				"&sex=" + this.props.location.shoeInfo.sex,
            headers: {'Accept': 'application/json'}
            }).done(response => {
				console.log("response size: ", response.entity.response)
				this.setState({
					size: response.entity.response
				})
		});
	}

	render() {
		console.log("props: ", this.props.location)
		let imageDisplay = [];
		if(this.props.location.shoeInfo.imgURL === undefined || this.props.location.shoeInfo.imgURL == null){
			imageDisplay.push(
				<div style={{padding: '20px', border: 'solid', borderColor: 'red'}}>
					<Card.Img variant="top" src={shoeImage} />
				</div>
			)
		}
		else{
			imageDisplay.push(
				<div style={{padding: '20px', border: 'solid', borderColor: 'red'}}>
					<Card.Img variant="top" src={this.props.location.shoeInfo.imgURL} />
				</div>
			)
		}

		console.log("state size: ", this.state.size)
		if(this.state.size === null || this.state.size === undefined){
			return null
		}
		else if(this.state.size === "Shoe_Not_Found"){
			return (
				<div>
          <div style={{margin: '40px'}}/>
          <Container>
          <Row>
			  
            <Col>
			<h3 style={{color: 'white'}}>Sorry, we can't seem to find any connection from your profile to the shoe you're looking at. Try adding more shoes to your account.</h3>
            </Col>
			
          </Row>
          </Container>
        </div>
			)
		}
		else{
			return (
				<div>
				<div style={{margin: '40px'}} />
				<Container>
					<Row>
					<Col lg={6} style={{textAlign: 'center'}}>
						<h1 style={{color: 'white', fontSize: '80px'}}>{"TrueSize: " + (this.state.size).toString()}</h1>
						<div style={{margin: '20px'}} />
						<h2 style={{color: 'white', fontSize: '40px'}}>{this.props.location.shoeInfo.brand + " " + this.props.location.shoeInfo.model}</h2>
						<div style={{margin: '40px'}} />
						<Row>
							<Col style={{position: 'relative', left: 0, right: 0, top: 0, bottom: 0}} >
								<Container>
									<Row>
									<Col />
										<Col>
											<div style={{width: '390px', height: '390px', alignContent: 'center', alignItems: 'center'}}>
												<Card>
													{imageDisplay}
												</Card>
											</div>
										</Col>
										<Col />
									</Row>
								</Container>
							</Col>
						</Row>
					</Col>

					<Col md={{ span: 5, offset: 1 }}>
						<div style={{margin: '20px'}}/>
						<Card style={{textAlign: 'center'}}>
						<Card.Body>
							<Card.Title style={{fontWeight:'bold'}}>What Other's Are Saying About This Shoe</Card.Title>
							<ShoeStats percentage={"75%"} quality={"say this shoe is stiff"}/>
							<ShoeStats percentage={"70%"} quality={"say this shoe is comfortable"}/>
							<ShoeStats percentage={"85%"} quality={"say this shoe is lightweight"}/>
							<ShoeStats percentage={"73%"} quality={"say this shoe is narrow"}/>
							<ShoeStats percentage={"80%"} quality={"would buy this shoe again"}/>
							<HorizLineBottom color='lightGray'/>
						</Card.Body>
						</Card>
					</Col>
					</Row>
					<div style={{margin: '20px'}} />
					<Row>
						<Col>
						<Card style={{height: '200px', overflowY: 'scroll'}}>
							<Card.Body>
								<Card.Title style={{fontWeight:'bold'}}>Comments</Card.Title>
								<HorizLineTop color='lightGray'/>
								<Card.Text>"One user said they really like this shoe a lot"</Card.Text>
								<Card.Text>"this shoe is horrible don't buy it"</Card.Text>
								<Card.Text>"this shoe is great but your website sucks"</Card.Text>
								<Card.Text>"i am a user"</Card.Text>
							</Card.Body>
						</Card>
						<div style={{ margin: '20px'}} />
						</Col>
					</Row>
				</Container>
				</div>
			)
		}
	}
}

export default SizeRecommender;