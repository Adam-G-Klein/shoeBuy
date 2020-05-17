import React from 'react';
import Autosuggest from 'react-autosuggest';
import "../resources/static/theme.css";
import ResultCard from './ResultCard';
<<<<<<< HEAD
import restClient from './restClient.js';
=======
// import { Col } from 'react-bootstrap';
import { Container, Row, Col, Button } from 'react-bootstrap';
>>>>>>> 834b3520563baa586034ba0653b78518ef78f4de

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
      shoes: [],
      testData: [
        {name: 'one',
        brand: 'nike',
        id: 1},
        {name: 'two',
        brand: 'adidas',
        id: 2},
        {name: 'three',
        brand: 'something',
        id:3},
        {name: 'four',
        brand: 'another',
        id:4},
        {name: 'five',
        brand: 'another one',
        id:5},
        {name: 'six',
        brand: 'nike',
        id: 6},
        {name: 'seven',
        brand: 'adidas',
        id: 7},
        {name: 'eight',
        brand: 'something',
        id:8},
        {name: 'nine',
        brand: 'something',
        id:9}
      ],
      currPageIndex: 0,
      pages: []
    };
  }

  componentDidMount(){
    document.querySelector('.react-autosuggest__input').focus();
    restClient({method: 'GET', path: '/api/userShoes'}).done(response => {
			this.setState({shoes: response.entity._embedded.userShoes});
		});
    this.sectionResultPages()
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
 

  sectionResultPages = () => {
    let sections = [];
    for(var i = 0; i < this.state.testData.length; i=i+4){
      var section = this.state.testData.slice(i, i+4)
      console.log("section: ", section);
      sections.push(section)
    }

    let rows = sections.map((section, index) =>{
        let row = section.map((content, i) =>{
          console.log("section content: ", content)
          return (
            <Col>
              <ResultCard shoeInfo={content}/>
            </Col>
          )
        })

      return(
       <Row>
          {row}
        </Row>
      )
    })

    console.log(rows.length)
    let pageRows = []
    for(var j = 0; j < rows.length; j = j+2){
      var pageRow;
      if(j+2 > rows.length){
        console.log("in if")
        pageRow = rows.slice(j, j+1)
        console.log("pagerow: ", pageRow)
      }
      else{
        pageRow = rows.slice(j, j+2)
      }
      pageRows.push(pageRow)
    }

    console.log("pageRows: ", pageRows)

    let pages = pageRows.map((content, index) =>{
      console.log("content: ", content)
      return(
        <div>
          <div style={{margin: '40px'}}/>
          <Container>
            {content[0]}
            <div style={{margin: '20px'}}/>
            {content[1]}
          </Container>
        </div>
      )
    })
    this.setState({pages: pages})
    // return (pages);
  }

  handlePreviousPage() {
    this.setState({currPageIndex: this.state.currPageIndex-1})
  }

  handleNextPage() {
    this.setState({currPageIndex: this.state.currPageIndex+1})
  }

  render() {
    const { value, suggestions } = this.state;
    console.log("state pages: ", this.state.pages)
 
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
      {this.state.pages[this.state.currPageIndex]}

      <div style={{margin: '40px'}}/>
      <Container>
        <Row>
          <Col />
            <Button style={{backgroundColor: 'red', outline: 'none', boxShadow: 'none'}} disabled={this.state.currPageIndex === 0 ? true : false} 
              onClick={() => this.handlePreviousPage()}>Previous
            </Button>
            <Button style={{backgroundColor: 'red', outline: 'none', boxShadow: 'none'}} disabled={this.state.currPageIndex +1 === this.state.pages.length ? true : false} 
              onClick={() => this.handleNextPage()}>Next
            </Button>
          <Col />
        </Row>
      </Container>
      
      </div>
    );
  }
}

export default SearchResults;