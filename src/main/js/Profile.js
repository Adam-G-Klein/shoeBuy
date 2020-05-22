import React from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import {Card, Button} from 'react-bootstrap';
import shoeImage from '../resources/static/exampleShoe.jpg';
import PillButton from '@rakuten-rex/button/PillButton';
import ShoeCollectionShoe from './ShoeCollectionShoe';
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form';

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
		showAdd: false,
		showLogout:false,
		showEditProfile: false,
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
		this.shoeCollectionPage()
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

	shoeCollectionPage = () => {
		let shoeData = this.state.testData
        let collection = shoeData.map((content, i) =>{
			return (
				<ShoeCollectionShoe shoeInfo={content}/>
			)
		})
		this.setState({shoeCollection: collection})
	}

	render() {
		return (
			<Container style = {{		
				width: '100%',
				marginRight: '0px',
				marginLeft: '0px',
				maxWidth: 'none'
			}}>
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
                        }} onClick={() => this.handleCloseLogout()}> Yes
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
					Update you login information
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
								Name
								</Form.Label>
								<Col>
								<Form.Control type="text" placeholder="JaneDoe" />
								</Col>
							</Form.Row>
							<br />
							<HorizLine color = 'lightGray'/>
							<br />
							<Form.Row>
								<Form.Label column lg={2}>
								Email
								</Form.Label>
								<Col>
								<Form.Control type="text" placeholder="jDoe@gmail.com" />
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
				<h4>Centered Modal</h4>
				<p>
					Cras mattis consectetur purus sit amet fermentum. Cras justo odio,
					dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac
					consectetur ac, vestibulum at eros.
				</p>
				</Modal.Body>
				<Modal.Footer>
				<Button onClick={() => this.handleCloseAdd()}>Close</Button>
				</Modal.Footer>
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
								<Row>
									<Col style = {{
										textAlign: 'center',
										fontWeight: 'bold'}}>
										Username
									</Col>
								</Row>
								<Row>
									<Col style = {{
										textAlign: 'center',
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
						Welcome, JaneDoe
						<PillButton style={{
							borderColor: 'red', 
							backgroundColor:'red',
							marginLeft:'28vw',
							width: '200px'}} onClick={() => this.handleShowAdd()}>
						Add Shoe</PillButton>
					</Row>
					<Card style = {{
						height: '600px',
						overflowY: 'scroll',
						marginTop: '50px'}}>
						<Card.Body>
							{this.state.shoeCollection}
						</Card.Body>
					</Card>
				</Col>
				<Col sm={{ span: 1 }}>
				</Col>
			</Row>
			</Container>
		)
	}
}

export default Profile;