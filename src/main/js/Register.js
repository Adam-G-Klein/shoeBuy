import React from 'react';
import {Button, Form, Card, Container, Row, Col} from 'react-bootstrap';
import { Redirect } from 'react-router-dom';
import restClient from './restClient.js';


class Register extends React.Component {

	constructor(props) {
		super(props);
		this.state ={
			username: "",
			password: "",
			creationStatus: ""
		};
	}

	createAccount(){
		console.log("made request")
        restClient({method: "GET",
            path: "/api/createAccount?email=" + this.state.username + "&password=" + this.state.password,
            headers: {'Accept': 'application/json'}
            }
            )
            .done(response => {
                console.log(response);
                this.setState({loginStatus: response.entity.response});
        });
	}

    handleUsernameChange(event){
        event.preventDefault();
        this.setState({username: event.target.value});
    }

    handlePassChange(event){
        event.preventDefault();
        this.setState({password: event.target.value});
    }

    handleSubmit(e){
      this.createAccount();
    }

	render() {
		return (
		    <div style={{margin: '40px'}}>
          <Container style={{alignContent: 'center', alignItems: 'center'}}>
            <Row>
              <Col />
              <Col >
                <h1 style={{color: 'white', textAlign: 'center'}}>Create an Account with TrueSize</h1>
                <div style={{margin: '40px'}}></div>
                    <Card style={{width:'30rem', alignContent: 'center'}}>
                        <Card.Body>
                        <Form>
                            <Form.Group>
                                <Form.Label>Create a Username</Form.Label>
                                <Form.Control type="text" placeholder="Enter a username" onChange = {(e) => this.handleUsernameChange(e)}/>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Create a Password</Form.Label>
                                <Form.Control type="text" placeholder="Enter a password" onChange = {(e) => this.handlePassChange(e)}/>
                            </Form.Group>
                            <Row>
                                <Col>
                                    <Button onClick={(event) => this.handleSubmit(event)}>Submit</Button>
                                </Col>
                                <Col>
                                    <Button >I already have an account</Button>
                                </Col>
                            </Row>
                            
                        </Form>
                        </Card.Body>
                    </Card>
                </Col>
                <Col />
            </Row>
         </Container>
         
      </div>
		)
	}
}

export default Register;