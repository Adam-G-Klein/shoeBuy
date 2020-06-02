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
        if(this.props.shoeInfo.imgURL === undefined || this.props.shoeInfo.imgURL === null){
            return (
                <div>
                {this.performRedirect()}
                <Button onClick={() => this.setRedirect()} variant="light" style={{padding: '0px'}}>
                <Card style={{ width: '204px'}}>
                    <div style={{outlineWidth: '5px', outline: 'solid', outlineColor: 'red', width: '204px', height: '139px', alignContent: 'center', verticalAlign: 'center'}}>
                        <div style={{paddingTop: '18px', paddingBottom: '18px', paddingRight: '12px', paddingLeft: '12px', verticalAlign: 'middle'}}>
                            <Card.Img style={{objectFit: 'cover', width: '180px', height: '103.76px'}} variant="top" src={'https://zycada-amzn.zappos.com/images/I/71rsqtFGsbL._AC_SX510_.jpg'} />
                        </div>
                    </div>
                    <Card.Body style={{padding: '10px'}}>
                        <Card.Title>{(this.props.shoeInfo.brand).toUpperCase() }</Card.Title>
                        <Card.Text>{this.props.shoeInfo.model}</Card.Text>
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
                <Card style={{ width: '204px'}}>
                    <div style={{outlineWidth: '5px', outline: 'solid', outlineColor: 'red', width: '204px', height: '139px', alignContent: 'center', verticalAlign: 'center'}}>
                        <div style={{paddingTop: '18px', paddingBottom: '18px', paddingRight: '12px', paddingLeft: '12px', verticalAlign: 'middle'}}>
                            <Card.Img style={{objectFit: 'cover', width: '180px', height: '103.76px'}} variant="top" src={this.props.shoeInfo.imgURL} />
                        </div>
                    </div>
                    <Card.Body style={{padding: '10px'}}>
                        <Card.Title>{(this.props.shoeInfo.brand).toUpperCase() }</Card.Title>
                        <Card.Text>{this.props.shoeInfo.model}</Card.Text>
                    </Card.Body>
                </Card>
                </Button>
                </div>
        )
        }
    }
}

export default ResultCard;
