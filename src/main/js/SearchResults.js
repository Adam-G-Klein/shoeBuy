import React from 'react';
import Autosuggest from 'react-autosuggest';
import "../resources/static/theme.css";
import ResultCard from './ResultCard';
import restClient from './restClient.js';
import { Button } from 'react-bootstrap';
import { Container } from 'react-bootstrap';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';


class SearchResults extends React.Component {
  constructor() {
    super();

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
        brand: 'something 1',
        id:9},
        {name: 'nine',
        brand: 'something 2',
        id:9},
        {name: 'nine',
        brand: 'something 3',
        id:9},
        {name: 'nine',
        brand: 'something 4',
        id:9},
        {name: 'nine',
        brand: 'something 5',
        id:9}
      ],
      currPageIndex: 0,
      pages: []
    };
  }

  componentDidMount(){
    document.querySelector('.react-autosuggest__input').focus();
    restClient({method: 'GET', path: '/api/shoeNodes'}).done(response => {
      console.log("response!: ", response.entity._embedded)
      this.setState({shoes: response.entity._embedded.shoeNodes});
      //this.setState({shoes: this.state.testData});
      this.sectionResultPages(this.state.shoes);

    });
    }

    getSuggestions = value => {
      var inputValue = value.trim().toLowerCase();
      var inputLength = inputValue.length;

      return inputLength === 0 ? [] : this.state.shoes.filter(shoes =>
        shoes.model.toLowerCase().slice(0, inputLength) === inputValue ||
        shoes.brand.toLowerCase().slice(0, inputLength) === inputValue ||
        (shoes.brand.toLowerCase() + ' ' + shoes.model.toLowerCase()).slice(0, inputLength) === inputValue
      );
    };

    getSuggestionValue = suggestion => suggestion.model;

    renderSuggestion = suggestion => (
      <div>
        {suggestion.model}
      </div>
    );

    onChange = (event, { newValue }) => {
      if(newValue === ""){
        this.sectionResultPages(this.state.shoes)
      }
      this.setState({
        value: newValue
      });

    };

  onSuggestionsFetchRequested = ({ value }) => {
    this.setState({
      suggestions: this.getSuggestions(value)
    });
    let s = this.getSuggestions(value);
    this.sectionResultPages(s);
  };


  onSuggestionsClearRequested = () => {
    this.setState({
      suggestions: []
    });

    if(this.state.value == ""){
      console.log("empty value")
      this.sectionResultPages(this.state.shoes)
    }
  };

  sectionResultPages = (suggestions) => {
    if(suggestions.length == 0){
      let emptyMessage =
          (<div>
          <div style={{margin: '40px'}}/>
          <Container>
          <Row>
            <Col>
              <h1 style={{color: 'white', textAlign: 'center'}}>Sorry, no shoes found :(</h1>
            </Col>
          </Row>
          </Container>
        </div>);

      this.setState({pages: [emptyMessage]})
      return;
    }
    let sections = [];
    for(var i = 0; i < suggestions.length; i=i+4){
      var section = suggestions.slice(i, i+4)
      sections.push(section)
    }

    let rows = sections.map((sec) =>{
        let row = sec.map((content) =>{
          return (
            <Col>
              <ResultCard shoeInfo={content}/>
            </Col>
          )
        })

      if(row.length < 4){
        for(var k = row.length-1; k < 4; k++){
          row.push(
            <Col>
              <div style={{ width: '204px'}}></div>
            </Col>
          )
        }
      }
      return(
       <Row>
          {row}
        </Row>
      )
    })

    let pageRows = []
    for(var j = 0; j < rows.length; j = j+2){
      var pageRow;
      if(j+2 > rows.length){
        pageRow = rows.slice(j, j+1)
      }
      else{
        pageRow = rows.slice(j, j+2)
      }
      pageRows.push(pageRow)
    }

    let pages = pageRows.map((content, index) =>{
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
  }

  handlePreviousPage() {
    this.setState({currPageIndex: this.state.currPageIndex-1})
  }

  handleNextPage() {
    this.setState({currPageIndex: this.state.currPageIndex+1})
  }

  render() {
    const { value, suggestions } = this.state;

    const inputProps = {
      placeholder: 'Seach for your dream shoes',
      value,
      onChange: this.onChange
    };

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