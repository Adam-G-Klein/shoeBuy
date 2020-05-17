import React from 'react';
import Autosuggest from 'react-autosuggest';
import "../resources/static/theme.css";
import ResultCard from './ResultCard';
import restClient from './restClient.js';

// Imagine you have a list of languages that you'd like to autosuggest.
const languages = [
	{
	  name: 'C',
	  year: 1972
	},
	{
	  name: 'C#',
	  year: 2000
	},
	{
	  name: 'C++',
	  year: 1983
	},
	{
	  name: 'Clojure',
	  year: 2007
	},
	{
	  name: 'Elm',
	  year: 2012
	},
	{
	  name: 'Go',
	  year: 2009
	},
	{
	  name: 'Haskell',
	  year: 1990
	},
	{
	  name: 'Java',
	  year: 1995
	},
	{
	  name: 'Javascript',
	  year: 1995
	},
	{
	  name: 'Perl',
	  year: 1987
	},
	{
	  name: 'PHP',
	  year: 1995
	},
	{
	  name: 'Python',
	  year: 1991
	},
	{
	  name: 'Ruby',
	  year: 1995
	},
	{
	  name: 'Scala',
	  year: 2003
	}
  ];
 
// Teach Autosuggest how to calculate suggestions for any given input value.
 
// When suggestion is clicked, Autosuggest needs to populate the input
// based on the clicked suggestion. Teach Autosuggest how to calculate the
// input value for every given suggestion.
 
// Use your imagination to render suggestions.

 
class SearchResults extends React.Component {
  constructor() {
    super();
 
    // Autosuggest is a controlled component.
    // This means that you need to provide an input value
    // and an onChange handler that updates this value (see below).
    // Suggestions also need to be provided to the Autosuggest,
    // and they are initially empty because the Autosuggest is closed.
    this.state = {
      value: '',
      suggestions: [],
      shoes: []
    };
  }

  componentDidMount(){
    document.querySelector('.react-autosuggest__input').focus();
    restClient({method: 'GET', path: '/api/userShoes'}).done(response => {
			this.setState({shoes: response.entity._embedded.userShoes});
		});
    }
    
    getSuggestions = value => {
      var inputValue = value.trim().toLowerCase();
      var inputLength = inputValue.length;
     
      return inputLength === 0 ? [] : this.state.shoes.filter(shoes =>
        shoes.modelName.toLowerCase().slice(0, inputLength) === inputValue
      );
    };

    getSuggestionValue = suggestion => suggestion.modelName;

    renderSuggestion = suggestion => (
      <div> 
        {suggestion.modelName}
      </div>
    );

    onChange = (event, { newValue }) => {
      this.setState({
        value: newValue
      });
    };
 
  // Autosuggest will call this function every time you need to update suggestions.
  // You already implemented this logic above, so just use it.
  onSuggestionsFetchRequested = ({ value }) => {
    this.setState({
      suggestions: this.getSuggestions(value)
    });
  };
 
  // Autosuggest will call this function every time you need to clear suggestions.
  onSuggestionsClearRequested = () => {
    this.setState({
      suggestions: []
    });
  };
 
  render() {
    const { value, suggestions } = this.state;
 
    // Autosuggest will pass through all these props to the input.
    const inputProps = {
      placeholder: 'Seach for your dream shoe',
      value,
      onChange: this.onChange
    };
 
    // Finally, render it!
    return (
      <div>
      <Autosuggest
        autoFocus
        suggestions={suggestions}
        onSuggestionsFetchRequested={this.onSuggestionsFetchRequested}
        onSuggestionsClearRequested={this.onSuggestionsClearRequested}
        getSuggestionValue={this.getSuggestionValue}
        renderSuggestion={this.renderSuggestion}
        inputProps={inputProps}
      />
      <ResultCard />
      </div>
    );
  }
}

export default SearchResults;