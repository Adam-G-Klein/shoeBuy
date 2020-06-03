import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import {Card} from 'react-bootstrap';
import shoeImage from '../resources/static/exampleShoe.jpg';
import PillButton from '@rakuten-rex/button/PillButton';
import ShoeCollectionShoe from './ShoeCollectionShoe';
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';
import restClient from './restClient.js';
import { Redirect } from 'react-router-dom';

const HorizLine = ({ color }) => (
    <hr
        style={{
            color: color,
            backgroundColor: color,
            height: .5,
            marginTop: '0px',
            marginBottom: '0px'
            }}
    />
);

class Profile extends React.Component {
	constructor() {
		super();
	this.state = {
		redirectLogout: false,
		showAdd: false,
		showLogout:false,
		showEditProfile: false,
		userInfo: null,
		userShoeData: undefined,
		testData: [
		  {name: 'one',
		  brand: 'nike',
		  id: 1},
		  {name: 'two',
		  brand: 'adidas',
		  id: 2},
		  {name: 'three',
		  brand: 'something',
		  id:3},
		  {name: 'four',
		  brand: 'another',
		  id:4},
		  {name: 'five',
		  brand: 'another one',
		  id:5},
		  {name: 'six',
		  brand: 'nike',
		  id: 6},
		  {name: 'seven',
		  brand: 'adidas',
		  id: 7},
		  {name: 'eight',
		  brand: 'something',
		  id:8},
		  {name: 'nine',
		  brand: 'something',
		  id:9}
		],
		shoeCollection: []
	  };
	}

	componentDidMount(){
		restClient({method: "GET",
            path: "/api/getUserInfo",
            headers: {'Accept': 'application/json'}
            }).done(response => {
				console.log("response account: ", response)
				this.setState({
					userInfo: {
						name: 'Kevin',
						email: response.entity.email,
						password: response.entity.password
					}
				})
		});
		
		restClient({method: "GET",
            path: "/api/getUserShoes",
            headers: {'Accept': 'application/json'}
            }).done(response => {
				console.log("response shoes: ", response)
				this.setState({
					userShoeData: response.entity
				})
				console.log("in request: ", this.state.userShoeData)
				this.shoeCollectionPage()
		});
		
	}

	handleShowAdd() {
		this.setState({showAdd:true})
	}

	handleCloseAdd() {
		this.setState({showAdd:false})
	}
	handleShowLogout() {
		this.setState({showLogout:true})
	}

	handleCloseLogout() {
		this.setState({showLogout:false})
	}

	handleShowEditProfile() {
		this.setState({showEditProfile:true})
	}

	handleCloseEditProfile() {
		this.setState({showEditProfile:false})
	}

	handleLogout(){
		this.setState({redirectLogout: true})
	}

	redirectLogout() {
		if(this.state.redirectLogout === true){
			return(
				<Redirect to={{
					pathname: "/login"
			}}/>
			)
		}
		else {
			return []
		}
	}

	shoeCollectionPage = () => {
		// let shoeData = this.state.testData
		let shoeData = this.state.userShoeData
		if(shoeData === null || shoeData === undefined){
			let collectionDisplay = [
				<Card style = {{
					// height: '300px',
					overflowY: 'scroll',
					marginTop: '50px'}}>
					<Card.Body style={{textAlign: 'center'}}>
						<h3>Looks like you don't have any shoes in your account :(</h3>
					</Card.Body>
				</Card>
				
			]
			this.setState({shoeCollection: collectionDisplay})
			
		}
		else{
			let collection = shoeData.map((content, i) =>{
				return (
					<ShoeCollectionShoe shoeInfo={content}/>
				)
			})
			let collectionDisplay = 
				<Card style = {{
					height: '600px',
					overflowY: 'scroll',
					marginTop: '50px'}}>
					<Card.Body>
						{collection}
					</Card.Body>
				</Card>
			
			this.setState({shoeCollection: collectionDisplay})
		}
	}

	render() {
		console.log("render u info: ", this.state.userInfo)
		if(this.state.userInfo === null){
			return null
		}
		else{
			return (
				<Container style = {{		
					width: '100%',
					marginRight: '0px',
					marginLeft: '0px',
					maxWidth: 'none'
				}}>
					{this.redirectLogout()}
				<Modal show={this.state.showLogout} onHide={() => this.handleCloseLogout()}
				size="sm"
				aria-labelledby="contained-modal-title-vcenter"
				centered>
					<Modal.Header closeButton style= {{
						paddingTop: '8px',
						paddingBottom: '8px'
					}}>
					</Modal.Header>
					<Modal.Body>
						<Col style = {{
							justifyContent: 'center',
							alignItems: 'center',
							textAlign: 'center'
						}}>
						<h4>Are you sure you want logout?</h4>
						</Col>
						<Modal.Footer style = {{
							paddingBottom : '8px'
						}}>
							<PillButton style = {{
											borderColor: 'gray', 
											backgroundColor:'gray',
											height: '40px',
											padding: '2px',
											fontSize: '20px',
											width: '100px'                              
							}} onClick={() => this.handleCloseLogout()}> No
							</PillButton>
							<PillButton style = {{
											borderColor: 'red', 
											backgroundColor:'red',
											height: '40px',
											padding: '2px',
											fontSize: '20px',
											width: '100px',
											marginLeft: '5px',
											marginRight: ' 12px'                               
							}} onClick={() => this.handleLogout()}> Yes
							</PillButton>
						</Modal.Footer>
						</Modal.Body>
				</Modal>
				<Modal show={this.state.showEditProfile} onHide={() => this.handleCloseEditProfile()}
				size="lg"
				aria-labelledby="contained-modal-title-vcenter"
				centered>
					<Modal.Header closeButton>
					<Modal.Title id="contained-modal-title-vcenter">
						Update your login information
					</Modal.Title>
					</Modal.Header>
					<Modal.Body>
						<Col style = {{
							justifyContent: 'center',
							alignItems: 'center'
						}}>
							<Form>
							<Form.Group>
								<Form.Row>
									<Form.Label column lg={2}>
									Email
									</Form.Label>
									<Col>
									<Form.Control type="text" placeholder={this.state.userInfo.email} />
									</Col>
								</Form.Row>
								<br />
								<HorizLine color = 'lightGray'/>
								<br />
								<Form.Row>
									<Form.Label column lg={2}>
									Current Password
									</Form.Label>
									<Col>
									<Form.Control type="text"  />
									</Col>
								</Form.Row>
								<br />
								<HorizLine color = 'lightGray'/>
								<br />
								<Form.Row>
									<Form.Label column lg={2}>
									New Password
									</Form.Label>
									<Col>
									<Form.Control type="text" />
									</Col>
								</Form.Row>
								
							</Form.Group>
							</Form>
						</Col>
						<Modal.Footer style = {{paddingBottom: '0px'}}>
							<PillButton style = {{
												borderColor: 'gray', 
												backgroundColor:'gray',
												height: '40px',
												padding: '2px',
												fontSize: '20px',
												width: '100px'                              
								}} onClick={() => this.handleCloseEditProfile()}> Cancel
								</PillButton>
								<PillButton style = {{
												borderColor: 'red', 
												backgroundColor:'red',
												height: '40px',
												padding: '2px',
												fontSize: '20px',
												width: '100px',
												marginLeft: '5px',
												marginRight: ' 12px'                               
								}} onClick={() => this.handleCloseEditProfile()}> Submit
							</PillButton>	
						</Modal.Footer>
						</Modal.Body>
				</Modal>
				<Modal show={this.state.showAdd} onHide={() => this.handleCloseAdd()}
				size="lg"
				aria-labelledby="contained-modal-title-vcenter"
				centered>
					<Modal.Header closeButton>
					<Modal.Title id="contained-modal-title-vcenter">
						Add a new shoe to your collection
					</Modal.Title>
					</Modal.Header>
					<Modal.Body>
						<Col style = {{
							justifyContent: 'center',
							alignItems: 'center'
						}}>
						<Form>
						<Form.Group>
							<Form.Row>
								<Form.Label column lg={2}>
									Brand
								</Form.Label>
								<Col>
								<Form.Control as="select" defaultValue="Choose a brand">
									<option>Choose a brand</option>
									<option>Adidas</option>
									<option>Nike</option>
									<option>Vans</option>
								</Form.Control>
								</Col>
							</Form.Row>
							<br />
							<HorizLine color = 'lightGray'/>
							<br />
							<Form.Row>
								<Form.Label column lg={2}>
								Shoe Name
								</Form.Label>
								<Col>
									<Form.Control as="select" defaultValue="Choose a model">
										<option>Choose a model</option>
									</Form.Control>
								</Col>
							</Form.Row>	
							<br />					
							<HorizLine color = 'lightGray'/>
							<br />
							<Form.Row>
								<Form.Label column lg={2}>
								Size
								</Form.Label>
								<Col>
									<Form.Control as="select" defaultValue="Choose a size">
										<option>Choose a size</option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
										<option>9</option>
										<option>10</option>
										<option>11</option>
										<option>12</option>
									</Form.Control>
								</Col>
							</Form.Row> 
							<br />
							<HorizLine color = 'lightGray'/>
							<br />
							<Form.Row>
								<Form.Label column lg={2}>
								Comfort
								</Form.Label>
								<Col>
								<Form.Control as="select" defaultValue="Choose a comfort">
									<option>Choose a comfort</option>
									<option>Not comfortable</option>
									<option>Moderately comfortable</option>
									<option>Very comfortable</option>
								</Form.Control>
								</Col>
							</Form.Row>
							<br />
							<HorizLine color = 'lightGray'/>
							<br />
							<Form.Row>
								<Form.Label column lg={2}>
								Width
								</Form.Label>
								<Col>
									<Form.Control as="select" defaultValue="Choose a width">
										<option>Choose a width</option>
										<option>Narrow</option>
										<option>Neither</option>
										<option>Wide</option>
									</Form.Control>
								</Col>
							</Form.Row>
							<br />
							<HorizLine color = 'lightGray'/>
							<br />
							<Form.Row>
								<Form.Label column lg={2}>
								Stiffness
								</Form.Label>
								<Col>
									<Form.Control as="select" defaultValue="Choose a stiffness">
										<option>Choose a stiffness</option>
										<option>Loose</option>
										<option>In between</option>
										<option>Sitff</option>
									</Form.Control>
								</Col>
							</Form.Row>
							<br />
							<HorizLine color = 'lightGray'/>
							<br />
							<Form.Row>
								<Form.Label column lg={2}>
								Buy Again
								</Form.Label>
								<Col>
									<Form.Control as="select" defaultValue="Choose an option">
										<option>Choose an option</option>
										<option>Yes</option>
										<option>No</option>
										<option>Maybe so</option>
									</Form.Control>
								</Col>
							</Form.Row>
						</Form.Group>
						</Form>
					</Col>
					<Modal.Footer style = {{paddingBottom: '0px'}}>
						<PillButton style = {{
											borderColor: 'gray', 
											backgroundColor:'gray',
											height: '40px',
											padding: '2px',
											fontSize: '20px',
											width: '100px'                              
							}} onClick={() => this.handleCloseAdd()}> Cancel
							</PillButton>
							<PillButton style = {{
											borderColor: 'red', 
											backgroundColor:'red',
											height: '40px',
											padding: '2px',
											fontSize: '20px',
											width: '100px',
											marginLeft: '5px',
											marginRight: ' 12px'                               
							}} onClick={() => this.handleCloseAdd()}> Add Shoe
						</PillButton>	
					</Modal.Footer>
					</Modal.Body>
				</Modal>
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
									{/* <Row>
										<Col style = {{
											textAlign: 'center',
											fontWeight: 'bold'}}>
											Username
										</Col>
									</Row> */}
									<Row>
										<Col style = {{
											textAlign: 'center',
											fontWeight: 'bold'}}>
											Email
										</Col>
									</Row>
								</Col>
								<Col md = {8}>
									{/* <Row>
										<Col style = {{textAlign: 'center'}}>
											{this.state.userInfo.name}
										</Col>
									</Row> */}
									<Row>
										<Col style = {{
											textAlign: 'center',
											marginBottom: '10px'}}>
											{this.state.userInfo.email}
										</Col>
									</Row>
								</Col>
							</Row>
						</div>
						<PillButton style={{
							borderColor: 'red', 
							backgroundColor:'red',
							marginTop: '20px',
							width: '200px'}}onClick={() => this.handleShowEditProfile()}>
						Edit Login Information</PillButton> 
						<PillButton style={{
							borderColor: 'red', 
							backgroundColor:'red',
							marginTop: '20px',
							width: '200px'}} onClick={() => this.handleShowLogout()}>
						Logout</PillButton> 
					</Col>
					<Col sm={{ span: 7, offset: 0 }}>
						<Row style = {{
							display: 'table',
							margin: '0 auto',
							marginTop: '10vh',
							marginLeft: '0px',
							color: 'white',
							fontSize: '2.5rem'
						}}>
							Welcome!
							<PillButton style={{
								borderColor: 'red', 
								backgroundColor:'red',
								marginLeft:'28vw',
								width: '200px'}} onClick={() => this.handleShowAdd()}>
							Add Shoe</PillButton>
						</Row>
						
						{this.state.shoeCollection}
					</Col>
					<Col sm={{ span: 1 }}>
					</Col>
				</Row>
				</Container>
		
		)
						}
	}
}

export default Profile;