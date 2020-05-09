import React from 'react';
class Shoe extends React.Component{
    render(){
        return (
            <li>
                <h4> Model: {this.props.shoe.modelName} </h4>
                <p> size: {this.props.shoe.size} </p>
            </li>
        )

    }
}

export default Shoe;