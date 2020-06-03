import React from 'react';
import {Card, Button} from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import PillButton from '@rakuten-rex/button/PillButton';
import Modal from 'react-bootstrap/Modal';

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

class ShoeCollectionShoe extends React.Component {
	handleShowDelete() {
		this.setState({showDelete:true})
	}

	handleCloseDelete() {
		this.setState({showDelete:false})
	}
	handleShowUpdate() {
		this.setState({showUpdate:true})
	}

	handleCloseUpdate() {
		this.setState({showUpdate:false})
	}
    state = {
        redirect: false,
        showDelete: false,
        showUpdate: false,
        shoeInfo: 
            {id: 1,
            brand: 'Nike',
            name: 'Shoe One'}
    }

    render() {
        console.log('props', this.props)
        return (
		    <div>
            <Modal show={this.state.showDelete} onHide={() => this.handleCloseDelete()}
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
                    <h4>Are you sure you want to delete this shoe?</h4>
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
                        }} onClick={() => this.handleCloseDelete()}> No
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
                        }} onClick={() => this.handleCloseDelete()}> Yes
                        </PillButton>
                    </Modal.Footer>
                    </Modal.Body>
			</Modal>
            <Modal show={this.state.showUpdate} onHide={() => this.handleCloseUpdate()}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered>
				<Modal.Header closeButton>
				<Modal.Title id="contained-modal-title-vcenter">
					Update Shoe
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
				<Button onClick={() => this.handleCloseUpdate()}>Close</Button>
				</Modal.Footer>
			</Modal>
                <HorizLine color='lightGray' />
                <Container>
                <Row>
                    <Col style={{paddingRight: '0px',
                        display: 'flex',
                        flexDirection:'column',
                        justifyContent: 'center',
                        alignItems: 'center'}}>
                        <Card style={{ 
                            margin: '0 auto',
                            width: '12rem'}}>
                            <Card.Img variant="top" src={this.props.shoeInfo.imgURL} />
                            {/* <Card.Img variant="top" src={'https://zycada-amzn.zappos.com/images/I/71rsqtFGsbL._AC_SX510_.jpg'} /> */}
                        </Card>
                    </Col>
                    <Col style={{padding: '18px'}} md={{span: 8, offset: 1}}>
                        <Row style = {{fontWeight: 'bold', fontSize: '30px'}}>
                            {this.props.shoeInfo.brand}
                        </Row>
                        <Row style = {{fontSize: '20px'}}>
                            {this.props.shoeInfo.model}
                        </Row>
                        <Row style = {{fontSize: '20px'}}>
                            size: {this.props.shoeInfo.size}
                        </Row>
                        <Row style= {{justifyContent: 'right', textAlign: 'right'}}>
                            <PillButton style = {{
                                borderColor: 'red', 
                                backgroundColor:'red',
                                height: '20px',
                                padding: '2px',
                                fontSize: '10px',
                                width: '50px',
                                marginLeft: '30vw'
                            }} onClick={() => this.handleShowUpdate()}>
                            Edit
                            </PillButton>
                            <PillButton style = {{
                                borderColor: 'red', 
                                backgroundColor:'red',
                                height: '20px',
                                padding: '2px',
                                fontSize: '10px',
                                width: '50px',
                                marginLeft: '5px'                               
                            }} onClick={() => this.handleShowDelete()}>
                            Remove
                            </PillButton>
                        </Row>
                    </Col>
                    <Col />
                </Row>
                </Container>
                
            </div>
        )
    }
}

export default ShoeCollectionShoe;
