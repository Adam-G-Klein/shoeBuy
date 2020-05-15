import React from 'react';
import { Redirect } from 'react-router-dom';
import {Card, Button} from 'react-bootstrap';
import shoeImage from '../resources/static/exampleShoe.jpg';

class ResultCard extends React.Component {
    state = {
        redirect: false,
        shoesList: [
                {id: 1,
                brand: 'Nike',
                name: 'Shoe One'}
        ]
    }

    setRedirect() {
        this.setState({
            redirect: true
        })
    }

    performRedirect = () => {
        if(this.state.redirect == true){
            return (<Redirect to='/sizeRecommender'/>)
        }
    }

    render() {
        return (
            <div>
            {this.performRedirect()}
            <Button onClick={() => this.setRedirect()} variant="light" style={{padding: '0px'}}>
            <Card style={{ width: '18rem'}}>
                <Card.Img variant="top" src={shoeImage} />
                <Card.Body>
                    <Card.Title>BRAND NAME</Card.Title>
                    <Card.Text>Shoe Name</Card.Text>
                </Card.Body>
            </Card>
            </Button>
            </div>
        )
    }
}

export default ResultCard;
