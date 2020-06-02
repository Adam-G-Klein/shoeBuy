import React from 'react';
import {Button, Form, Card, Container, Row, Col} from 'react-bootstrap';
import { Redirect } from 'react-router-dom';
import restClient from './restClient.js';


class Login extends React.Component {

	constructor(props) {
		super(props);
		this.state ={
			username: "",
			password: "",
      loginStatus: "",
      redirectRegister: false,
      redirectSearch: false
		};
  }
  
  performRedirectSearch = () => {
    if(this.state.redirectSearch == true){
        return (<Redirect to={{
            pathname: "/search"
      }}/>)
    }
}

	verifyLogin(){
        restClient({method: "GET",
            path: "/api/logIn?email=" + this.state.username + "&password=" + this.state.password,
            headers: {'Accept': 'application/json'}
            }).done(response => {
                console.log(response)
                if(response.entity.response === "LOGIN_SUCCESS"){
                  this.setState({redirectSearch: true});
                }
                else{
                  alert("No account found with this email and password.")
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
      this.verifyLogin();
    }


    performRedirectRegister = () => {
      if(this.state.redirectRegister == true){
          return (<Redirect to={{
              pathname: "/register"
        }}/>)
      }
  }

    handleCreateAccount(){
      this.setState({redirectRegister: true})
    }

	render() {
		return (
		    <div style={{margin: '40px'}}>
          {this.performRedirectRegister()}
          {this.performRedirectSearch()}
          <Container style={{alignContent: 'center', alignItems: 'center'}}>
            <Row>
              <Col />
              <Col >
              <h1 style={{color: 'white', textAlign: 'center'}}>Welcome to TrueSize</h1>
              <div style={{margin: '40px'}}></div>
              <Card style={{width:'30rem', alignContent: 'center'}}>
                <Card.Body>
                  <Form>
                    <Form.Group>
                      <Form.Label>Email</Form.Label>
                      <Form.Control type="text" placeholder="Enter your username" onChange = {(e) => this.handleUsernameChange(e)}/>
                    </Form.Group>
                    <Form.Group>
                      <Form.Label>Password</Form.Label>
                      <Form.Control type="password" placeholder="Enter your password" onChange = {(e) => this.handlePassChange(e)}/>
                    </Form.Group>
                    <Form.Group>
                      <div style={{textAlign: 'center'}}>
                        <Button onClick={(event) => this.handleSubmit(event)}>Login</Button>
                      </div>
                      <div style={{textAlign: 'center'}}>
                        <Button variant="link" onClick={(event) => this.handleCreateAccount(event)}>I don't have an account</Button>
                      </div>
                    </Form.Group>
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

export default Login;