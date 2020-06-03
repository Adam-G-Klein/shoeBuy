import React from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';


const headerStyle = { 'marginLeft': 20 }

const linkToTextLoggedOut = {
    "/shoeRecommender" : "Find a Shoe",
    "/search" : "Search",
    "/profile" : "Profile",
    "/login" : "Login"
};

const linkToTextLoggedIn = {
    "/shoeRecommender" : "Find a Shoe",
    "/search" : "Search",
    "/profile" : "Profile",
    "/login" : "Logout"
};

class Header extends React.Component {
    getAppropriateLinkType = (linkName) => {
        const linkAt = this.props.pathname;
        if (linkAt === linkName) {
            if(this.props.loggedIn === false)
            {
                return (
                    <Nav.Link style = {{'marginLeft': 20, color: 'white'}} href={linkName}>{linkToTextLoggedOut[linkName]}</Nav.Link>
                  );
            }
            else
            {
                return (
                    <Nav.Link style = {{'marginLeft': 20, color : 'white'}} href={linkName}>{linkToTextLoggedIn[linkName]}</Nav.Link>
                  );
            }

        }
        else{
            if(this.props.loggedIn === false)
            {
                return (
                    <Nav.Link style={headerStyle} href={linkName}>{linkToTextLoggedOut[linkName]}</Nav.Link>
                );
            }
            else
            {
                return (
                    <Nav.Link style={headerStyle} href={linkName}>{linkToTextLoggedIn[linkName]}</Nav.Link>
                );
            }
        }
      }
	render() {
        if(this.props.loggedIn === false)
        {
            return (
                <>
                <Navbar bg="dark" variant="dark">
                    <Navbar.Brand href="/">TrueSize</Navbar.Brand>
                    <Nav  className="ml-auto">
                    { Object.keys(linkToTextLoggedOut).map(this.getAppropriateLinkType) }
                    </Nav>
                </Navbar>
                </>
            )
        }
        else{
            return (
                <>
                <Navbar bg="dark" variant="dark">
                    <Navbar.Brand href="/">TrueSize</Navbar.Brand>
                    <Nav  className="ml-auto">
                    { Object.keys(linkToTextLoggedIn).map(this.getAppropriateLinkType) }
                    </Nav>
                </Navbar>
                </>
            )
        }
	}
}

export default Header;