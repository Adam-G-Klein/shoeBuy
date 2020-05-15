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
		return (
		    <div>
			<div style={{margin: '40px'}} />
			<Container>
				<Row>
				<Col lg={6} style={{textAlign: 'center'}}>
					<h1 style={{color: 'white', fontSize: '80px'}}>{"TrueSize: " + (this.state.size).toString()}</h1>
					<div style={{margin: '20px'}} />
					<h2 style={{color: 'white', fontSize: '40px'}}>{this.props.location.shoeInfo.brand + " " + this.props.location.shoeInfo.name}</h2>
					<div style={{margin: '60px'}} />
					<Row>
						<Col md={{span: 10, offset: 1}}>
							<Card>
								<Card.Img variant="top" src={shoeImage} />
							</Card>
						</Col>
					</Row>
				</Col>

				<Col md={{ span: 5, offset: 1 }}>
					<div style={{margin: '20px'}}/>
					<Card style={{textAlign: 'center'}}>
					<Card.Body>
						<Card.Title style={{fontWeight:'bold'}}>What Other's Are Saying About This Shoe</Card.Title>
						<ShoeStats percentage={"75%"} quality={"stiffness"}/>
						<ShoeStats percentage={"70%"} quality={"another thing"}/>
						<ShoeStats percentage={"85%"} quality={"something else"}/>
						<ShoeStats percentage={"80%"} quality={"one more quality here"}/>
						<ShoeStats percentage={"73%"} quality={"a last one goes here"}/>
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