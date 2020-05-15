import React from 'react';
import {Button, Form, Card, Container, Row, Col} from 'react-bootstrap';
//import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
// import AppBar from 'material-ui/AppBar';
// import RaisedButton from 'material-ui/RaisedButton';
// import TextField from 'material-ui/TextField';

class Login extends React.Component {

	constructor(props) {
		super(props);
		this.state ={
			username: "",
			password: "",
			loginStatus: ""
		};
	}

	verifyLogin(){
		console.log("made request")
        // restClient({method: "GET",
        //     path: "/api/login?username=" + this.state.username + "&password=" + this.state.password,
        //     headers: {'Accept': 'application/json'}
        //     }
        //     )
        //     .done(response => {
        //         console.log(response);
        //         this.setState({loginStatus: response.entity.response});
        // });
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

	render() {
		return (
		    <div style={{margin: '40px'}}>
          <Container style={{alignContent: 'center', alignItems: 'center'}}>
            <Row>
              <Col />
              <Col >
              <h1 style={{color: 'white', textAlign: 'center'}}>Welcome to TrueSize</h1>
              <div style={{margin: '40px'}}></div>
          <Card style={{width:'30rem', alignContent: 'center'}}>
            <Card.Body>
              <Form>
                <Form.Label>Username</Form.Label>
                <Form.Control type="text" placeholder="Enter your username" onChange = {(e) => this.handleUsernameChange(e)}/>
                <Form.Label>Password</Form.Label>
                <Form.Control type="text" placeholder="Enter your password" onChange = {(e) => this.handlePassChange(e)}/>
                <Button onClick={(event) => this.handleSubmit(event)}>Submit</Button>
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