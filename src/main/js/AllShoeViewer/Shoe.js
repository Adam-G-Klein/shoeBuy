import React from 'react';
class Shoe extends React.Component{
    render(){
        return (
            <li>
                <h4 style={{color: 'white'}}> Model: {this.props.shoe.model} </h4>
                <p style={{color: 'white'}}> sex: {this.props.shoe.sex} </p>
                <p style={{color: 'white'}}> brand: {this.props.shoe.brand} </p>
            </li>
        )

    }
}

export default Shoe;