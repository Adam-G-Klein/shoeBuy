import React from 'react';
import { Redirect } from 'react-router-dom';
import {Card, Button} from 'react-bootstrap';
import shoeImage from '../resources/static/exampleShoe.jpg';

class ResultCard extends React.Component {

    state = {
        redirect: false,
    }

    setRedirect() {
        this.setState({
            redirect: true
        })
    }

    performRedirect = () => {
        if(this.state.redirect == true){
            return (<Redirect to={{
                pathname: "/sizeRecommender",
                shoeInfo: this.props.shoeInfo
          }}/>)
        }
    }

    render() {
        if(this.props.shoeInfo.url === undefined || this.props.shoeInfo.url === null){
            return (
                <div>
                {this.performRedirect()}
                <Button onClick={() => this.setRedirect()} variant="light" style={{padding: '0px'}}>
                <Card style={{ width: '12rem'}}>
                    <div style={{outlineWidth: '5px', outline: 'solid', outlineColor: 'red', width: '190px', height: '190px', alignContent: 'center'}}>
                        <Card.Img style={{objectFit: 'cover', width: '190px', height: '190px'}} variant="top" src={shoeImage} />
                    </div>
                    <Card.Body style={{padding: '10px'}}>
                        <Card.Title>{(this.props.shoeInfo.brand).toUpperCase() }</Card.Title>
                        <Card.Text>{this.props.shoeInfo.name}</Card.Text>
                    </Card.Body>
                </Card>
                </Button>
                </div>
            )
        }
        else{
        
            return (
                <div>
                {this.performRedirect()}
                <Button onClick={() => this.setRedirect()} variant="light" style={{padding: '0px'}}>
                <Card style={{ width: '12rem'}}>
                    <div style={{outlineWidth: '5px', outline: 'solid', outlineColor: 'red', width: '190px', height: '190px', alignContent: 'center'}}>
                        <Card.Img style={{objectFit: 'cover', width: '190px', height: '190px'}} variant="top" src={this.props.shoeInfo.url} />
                    </div>
                    <Card.Body style={{padding: '10px'}}>
                        <Card.Title>{(this.props.shoeInfo.brand).toUpperCase() }</Card.Title>
                        <Card.Text>{this.props.shoeInfo.name}</Card.Text>
                    </Card.Body>
                </Card>
                </Button>
                </div>
        )
        }
    }
}

export default ResultCard;
