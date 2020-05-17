import React from 'react';
import { Redirect } from 'react-router-dom';
import {Card, Button} from 'react-bootstrap';
import shoeImage from '../resources/static/exampleShoe.jpg';

class ResultCard extends React.Component {

    state = {
        redirect: false,
        shoeInfo: 
            {id: 1,
            brand: 'Nike',
            name: 'Shoe One'}
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
        return (
            <div>
            {this.performRedirect()}
            <Button onClick={() => this.setRedirect()} variant="light" style={{padding: '0px'}}>
            <Card style={{ width: '12rem'}}>
                <Card.Img variant="top" src={shoeImage} />
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

export default ResultCard;
