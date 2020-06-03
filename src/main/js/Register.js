import React from 'react';
import {Button, Form, Card, Container, Row, Col} from 'react-bootstrap';
import { Redirect } from 'react-router-dom';
import restClient from './restClient.js';
import PillButton from '@rakuten-rex/button/PillButton';

class Register extends React.Component {

	constructor(props) {
		super(props);
		this.state ={
			username: "",
            password: "",
            loginStatus: "",
			redirectSearch: false
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
                if(response.entity.response === "LOGIN_SUCCESS"){
                    this.setState({redirectSearch: true});
                }                
                else if(response.entity.response === "CREATEACCOUNT_FAILURE"){
                    alert("This username already exists")
                }  
                else {
                    alert("Failed to login")
                }
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

    performRedirectSubmit = () => {
        if(this.state.redirectSearch == true){
            return (<Redirect to={{
                pathname: "/Search"
          }}/>)
        }
    }

	render() {
		return (
		    <div style={{margin: '40px'}}>
            {this.performRedirectSubmit()}
          <Container style={{alignContent: 'center', alignItems: 'center'}}>
            <Row>
              <Col />
              <Col >
                <h1 style={{color: 'white', textAlign: 'center'}}>Create an Account with TrueSize</h1>
                <div style={{margin: '40px'}}></div>
                    <Card style={{width:'30rem', alignContent: 'center'}}>
                        <Card.Body>
                        <Form>
                            <Form.Group style = {{marginBottom: '8px'}}>
                                <Button size = 'sm' href = "/login" style = {{
                                    backgroundColor : '#777777',
                                    borderColor: '#777777'
                                }}>&lt;</Button>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Create a Username</Form.Label>
                                <Form.Control type="text" placeholder="Enter a username" onChange = {(e) => this.handleUsernameChange(e)}/>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Create a Password</Form.Label>
                                <Form.Control type="text" placeholder="Enter a password" onChange = {(e) => this.handlePassChange(e)}/>
                            </Form.Group>
                            <Row style={{textAlign: 'center'}} >
                                <Col style={{textAlign: 'center'}}>
                                    <PillButton style = {{
                                            borderColor: 'red', 
                                            backgroundColor:'red',
                                            height: '35px',
                                            padding: '2px',
                                            fontSize: '18px',
                                            width: '150px',                              
                                    }} onClick={(event) => this.handleSubmit(event)}> Create Account
                                    </PillButton>
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