import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import {Card, Button} from 'react-bootstrap';
import shoeImage from '../resources/static/exampleShoe.jpg';
import PillButtonLink from '@rakuten-rex/button/PillButton/PillButtonLink';

class Profile extends React.Component {
	render() {
		return (
			<Container style = {{
				width: '100%',
				marginRight: '0px',
				marginLeft: '0px',
				maxWidth: 'none'
			}}>
			<Row>
				<Col style = {{
					display: 'flex',
					flexDirection: 'column',
					justifyContent: 'center',
					alignItems: 'center',
					marginTop: '10vh'
				}}>
					<Card style={{ 
						margin: '0 auto',
						width: '25rem'}}>
						<Card.Img variant="top" src={shoeImage} />
					</Card>
					<div style = {{
						backgroundColor: 'white',
						textAlign: 'center',
						width: '20rem',
						marginTop: '20px'
					}}>
						<Col style = {{
							textAlign: 'center',
							marginTop: '10px',
							fontWeight:'bold'}}>
							Account Info
						</Col>
						<Row style={{
							marginLeft: '0px',
							marginRight: '0px'
							}}>
							<Col sm = {4}>
								<Row>
									<Col style = {{
										textAlign: 'center',
										fontWeight: 'bold'}}>
										Username
									</Col>
								</Row>
								<Row>
									<Col style = {{textAlign: 'center',
										fontWeight: 'bold'}}>
										Email
									</Col>
								</Row>
							</Col>
							<Col md = {8}>
								<Row>
									<Col style = {{textAlign: 'center'}}>
										JaneDoe
									</Col>
								</Row>
								<Row>
									<Col style = {{
										textAlign: 'center',
										marginBottom: '10px'}}>
										jDone@gmail.com
									</Col>
								</Row>
							</Col>
						</Row>
					</div>
					<PillButtonLink href='/login' style={{
						borderColor: 'red', 
						backgroundColor:'red',
						marginTop: '20px',
						width: '200px'}}>
					Edit Login Information</PillButtonLink> 
					<PillButtonLink href='/login' style={{
						borderColor: 'red', 
						backgroundColor:'red',
						marginTop: '20px',
						width: '200px'}}>
					Logout</PillButtonLink> 
				</Col>
				<Col sm={7}>
					<Row style = {{
						display: 'table',
						margin: '0 auto',
						marginTop: '10vh',
						marginLeft: '0px',
						color: 'white',
						fontSize: '2.5rem'
					}}>
						Welcome, JaneDoe
						<PillButtonLink href='/login' style={{
							borderColor: 'red', 
							backgroundColor:'red',
							marginLeft:'20vw',
							width: '200px'}}>
						Add Shoe</PillButtonLink>
					</Row>
					
				</Col>
			</Row>
			</Container>
		)
	}
}

export default Profile;