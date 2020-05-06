const React = require('react');
const ReactDOM = require('react-dom');

class Index extends React.Component {
	render() {
		return (
		    <div>
		    <h1> Login to find your perfect fit! </h1>
		    <h3> this is the login page </h3>
		    </div>
		)
	}
}


ReactDOM.render(
	<Index /> ,
	document.getElementById('Index')
);
