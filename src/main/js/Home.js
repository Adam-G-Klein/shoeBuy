import React from 'react';
import PillButtonLink from '@rakuten-rex/button/PillButton/PillButtonLink';

class Home extends React.Component {
	render() {
		return (
		    <div style = {{
				height: 'calc(90vh)',
				display: 'flex',
				flexDirection: 'column',
				justifyContent: 'center',
				alignItems: 'center'}}>
				<h1 style={{
					color: 'white',
					fontSize: '80px',
					marginBottom: '0'}}>
					Find Your </h1>
				<h1 style={{
					marginBottom: '0',
					fontSize: '80px',
					color: 'white'}}>
					TrueSize</h1>
					<PillButtonLink href='/login' style={{
						borderColor: 'red', 
						backgroundColor:'red',
						marginTop: '50px',
						width: '100px'}}>
					Sign In</PillButtonLink>
		    </div>
		)
	}
}

export default Home;