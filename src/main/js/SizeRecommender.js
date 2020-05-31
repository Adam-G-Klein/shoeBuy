import React from 'react';
import { Card, Col, Container, Row } from 'react-bootstrap';
import shoeImage from '../resources/static/exampleShoe.jpg';
import ShoeStats from './ShoeStats';

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
			size: 10.5
		}
	}

	render() {
		console.log("props: ", this.props.location)
		let imageDisplay = [];
		if(this.props.location.shoeInfo.url === undefined || this.props.location.shoeInfo.url == null){
			imageDisplay.push(
				<Card.Img variant="top" src={shoeImage} />
			)
		}
		else{
			imageDisplay.push(
				<Card.Img variant="top" src={this.props.location.shoeInfo.url} />
			)
		}
		return (
		    <div>
			<div style={{margin: '40px'}} />
			<Container>
				<Row>
				<Col lg={6} style={{textAlign: 'center'}}>
					<h1 style={{color: 'white', fontSize: '80px'}}>{"TrueSize: " + (this.state.size).toString()}</h1>
					<div style={{margin: '20px'}} />
					<h2 style={{color: 'white', fontSize: '40px'}}>{this.props.location.shoeInfo.brand + " " + this.props.location.shoeInfo.name}</h2>
					<div style={{margin: '20px'}} />
					<Row>
						<Col style={{position: 'relative', left: 0, right: 0, top: 0, bottom: 0}} >
							<Container>
								<Row>
								<Col />
									<Col>
										<div style={{width: '350px', height: '350px', alignContent: 'center', alignItems: 'center'}}>
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

export default SizeRecommender;