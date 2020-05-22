import React from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';


const headerStyle = { 'marginLeft': 20 }


class Header extends React.Component {
	render() {
		return (
            <>
            <Navbar bg="dark" variant="dark">
                <Navbar.Brand href="/">TrueSize</Navbar.Brand>
                <Nav  className="ml-auto">
                <Nav.Link style={headerStyle} href="/shoeRecommender">Find a Shoe</Nav.Link>
                <Nav.Link style={headerStyle} href="/search">Find a Size</Nav.Link>
                <Nav.Link style={headerStyle} href="/profile">Profile</Nav.Link>
                <Nav.Link style={headerStyle} href="/login">Login</Nav.Link>
                </Nav>
            </Navbar>
            </>
		)
	}
}

export default Header;