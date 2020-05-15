import React from 'react';
import {Card, Button} from 'react-bootstrap';
var exampleShoePicture = require('../resources/static/exampleShoePicture.jpg')


class ResultCard extends React.Component {

	render() {
		return (
		    <Card style={{ width: '18rem' }}>
                <Card.Img border="primary" variant="top" src="../resources/static/exampleShoePicture.jpg" />
                <Card.Body>
                    <Card.Title>BRAND NAME</Card.Title>
                    <Card.Text>Shoe Name</Card.Text>
                    <Button variant="primary">View Details</Button>
                </Card.Body>
            </Card>
		)
	}
}

export default ResultCard;