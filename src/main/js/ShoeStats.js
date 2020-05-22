import React from 'react';
import { Row, Container, Col } from 'react-bootstrap';

const HorizLine = ({ color }) => (
    <hr
        style={{
            color: color,
            backgroundColor: color,
            height: .5,
            // marginRight: 10,
            // marginLeft: 10
        }}
    />
);

class ShoeStats extends React.Component {
    constructor(props){
        super(props)

    }

	render() {
		return (
		    <div>
                <HorizLine color='lightGray' />
                <Container>
                <Row>
                    <Col style={{paddingRight: '0px'}}>
                        <p style={{backgroundColor: 'red', width: '65px', textAlign: 'center', fontSize: '24px', margin: '5px', padding: '7px', borderRadius: '10px'}}>
                            {this.props.percentage}
                        </p>
                    </Col>
                    <Col style={{padding: '18px'}} md={{span: 8}}>
                        {this.props.quality}
                    </Col>
                    <Col />
                </Row>
                </Container>
                
            </div>
		)
	}
}

export default ShoeStats;