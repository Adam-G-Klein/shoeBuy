import React from 'react';
class Shoe extends React.Component{
    render(){
        return (
            <li>
                <h4 style={{color: 'white'}}> Model: {this.props.shoe.modelName} </h4>
                <p style={{color: 'white'}}> size: {this.props.shoe.size} </p>
            </li>
        )

    }
}

export default Shoe;