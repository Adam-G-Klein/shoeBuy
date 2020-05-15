import React from 'react';

class SizeRecommender extends React.Component {
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
			</div>
		)
	}
}

export default SizeRecommender;