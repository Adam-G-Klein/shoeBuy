import React from 'react';
import "../resources/static/theme.css";
import ResultCard from './ResultCard';
import { Container, Row, Col } from 'react-bootstrap';

 
class ShoeRecommender extends React.Component {
  constructor() {
    super();

    this.state = {
      value: '',
      suggestions: [],
      shoes: [],
      testData: [
        {
            "sex" : "m",
            "model" : "alpha huarache elite 2 turf",
            "brand" : "nike",
            "imgURL" : "https://m.media-amazon.com/images/I/71SbOJr5r4L._AC_SX510_.jpg",
            "uniqueShoeCode" : "alpha huarache elite 2 turfnikem",
            "edges" : [ ],
            "edgesAsShoeCodes" : [ ],
            "_links" : {
              "self" : {
                "href" : "http://localhost:8080/api/shoeNodes/132"
              },
              "shoeNode" : {
                "href" : "http://localhost:8080/api/shoeNodes/132"
              }
            }
          }, {
            "sex" : "m",
            "model" : "renew retaliation tr",
            "brand" : "nike",
            "imgURL" : "https://m.media-amazon.com/images/I/71UgnIgRDcL._AC_SX510_.jpg",
            "uniqueShoeCode" : "renew retaliation trnikem",
            "edges" : [ ],
            "edgesAsShoeCodes" : [ ],
            "_links" : {
              "self" : {
                "href" : "http://localhost:8080/api/shoeNodes/133"
              },
              "shoeNode" : {
                "href" : "http://localhost:8080/api/shoeNodes/133"
              }
            }
          }, {
            "sex" : "m",
            "model" : "fly.by mid nbk",
            "brand" : "nike",
            "imgURL" : "https://m.media-amazon.com/images/I/71pJv9CJDLL._AC_SX510_.jpg",
            "uniqueShoeCode" : "fly.by mid nbknikem",
            "edges" : [ ],
            "edgesAsShoeCodes" : [ ],
            "_links" : {
              "self" : {
                "href" : "http://localhost:8080/api/shoeNodes/134"
              },
              "shoeNode" : {
                "href" : "http://localhost:8080/api/shoeNodes/134"
              }
            }
          }, 
          {
          "sex" : "m",
          "model" : "air zoom structure 22",
          "brand" : "nike",
          "imgURL" : "https://m.media-amazon.com/images/I/71rBx9sWBSL._AC_SX510_.jpg",
          "uniqueShoeCode" : "air zoom structure 22nikem",
          "edges" : [ ],
          "edgesAsShoeCodes" : [ ],
          "_links" : {
            "self" : {
              "href" : "http://localhost:8080/api/shoeNodes/85"
            },
            "shoeNode" : {
              "href" : "http://localhost:8080/api/shoeNodes/85"
            }
          }
        }, {
          "sex" : "m",
          "model" : "odyssey react 2 shield",
          "brand" : "nike",
          "imgURL" : "https://m.media-amazon.com/images/I/71n7d0LMYxL._AC_SX510_.jpg",
          "uniqueShoeCode" : "odyssey react 2 shieldnikem",
          "edges" : [ ],
          "edgesAsShoeCodes" : [ ],
          "_links" : {
            "self" : {
              "href" : "http://localhost:8080/api/shoeNodes/153"
            },
            "shoeNode" : {
              "href" : "http://localhost:8080/api/shoeNodes/153"
            }
          }
        }, {
          "sex" : "m",
          "model" : "flyease air zoom pegasus 36",
          "brand" : "nike",
          "imgURL" : "https://m.media-amazon.com/images/I/81WG8n8l76L._AC_SX510_.jpg",
          "uniqueShoeCode" : "flyease air zoom pegasus 36nikem",
          "edges" : [ ],
          "edgesAsShoeCodes" : [ ],
          "_links" : {
            "self" : {
              "href" : "http://localhost:8080/api/shoeNodes/154"
            },
            "shoeNode" : {
              "href" : "http://localhost:8080/api/shoeNodes/154"
            }
          }
        },
        {
          "sex" : "m",
          "model" : "zoom gravity",
          "brand" : "nike",
          "imgURL" : "https://m.media-amazon.com/images/I/713LbPdrEYL._AC_SX510_.jpg",
          "uniqueShoeCode" : "zoom gravitynikem",
          "edges" : [ ],
          "edgesAsShoeCodes" : [ ],
          "_links" : {
            "self" : {
              "href" : "http://localhost:8080/api/shoeNodes/87"
            },
            "shoeNode" : {
              "href" : "http://localhost:8080/api/shoeNodes/87"
            }
          }
        }, {
          "sex" : "m",
          "model" : "court air zoom zero hc",
          "brand" : "nike",
          "imgURL" : "https://m.media-amazon.com/images/I/71Jz2GxezYL._AC_SX510_.jpg",
          "uniqueShoeCode" : "court air zoom zero hcnikem",
          "edges" : [ ],
          "edgesAsShoeCodes" : [ ],
          "_links" : {
            "self" : {
              "href" : "http://localhost:8080/api/shoeNodes/88"
            },
            "shoeNode" : {
              "href" : "http://localhost:8080/api/shoeNodes/88"
            }
          }
        }, {
          "sex" : "m",
          "model" : "flyease air zoom pegasus 35",
          "brand" : "nike",
          "imgURL" : "https://m.media-amazon.com/images/I/816q9wWjJjL._AC_SX510_.jpg",
          "uniqueShoeCode" : "flyease air zoom pegasus 35nikem",
          "edges" : [ ],
          "edgesAsShoeCodes" : [ ],
          "_links" : {
            "self" : {
              "href" : "http://localhost:8080/api/shoeNodes/89"
            },
            "shoeNode" : {
              "href" : "http://localhost:8080/api/shoeNodes/89"
            }
          }
        }
      ],
    //   testData: [
    //     {name: 'Air Max 90',
		// brand: 'nike',
		// url: 'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/b195d2cd-84b1-4a9c-80ba-d6df7c691440/air-max-90-mens-shoe-Qrqh71.jpg',
    //     id: 1},
    //     {name: 'Air Force 1 \'07 LV8',
		// brand: 'Nike',
		// url: 'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/i1-7c2caddb-b8af-4471-b771-5d4ea47005b9/air-force-1-07-lv8-mens-shoe-9xj4RS.jpg',
    //     id:4},
    //     {name: 'Air Jordan IV',
		// brand: 'Jordan',
		// url: 'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/i1-8abaf942-1dc5-44fb-900f-3791fdab9d4b/air-jordan-iv-shoe-nZg3vX.jpg',
		// id:5},
    //     {name: 'Kyrie 6 By You',
		// brand: 'nike',
		// url: 'https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/d6e338c6-fe5f-43df-b07c-5cb2b4bc77e2/custom-kyrie-6-by-you.jpg',
		// id: 6},
		// {name: 'Free TR8',
		// brand: 'nike',
		// url: 'https://c.static-nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/pmpo4ywrunf6ohhwaapb/free-tr-8-mens-training-shoe-KCv0FL.jpg',
    //     id: 2},
    //     {name: 'Why Not? Zer0.3',
		// brand: 'Jordan',
		// url: 'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/c861f4d5-8328-4491-bf5e-9d1a76bff2ad/jordan-why-not-zer03-basketball-shoe-LJCLGj.jpg',
		// id: 7},
		// {name: 'Zoom 2K',
		// brand: 'nike',
		// url: 'https://c.static-nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/bicqgpc7ir7bnx5qbelb/zoom-2k-mens-shoe-KDhqfM.jpg',
    //     id:3},
    //     {name: 'KD13',
		// brand: 'Nike',
		// url: 'https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/i1-f787fb04-5796-40ec-9c34-671f7ce41fd1/kd13-basketball-shoe-kbKpNV.jpg',
    //     id:8}
    //   ],
      currPageIndex: 0,
      pages: []
    };
  }

  	componentDidMount(){
    	this.sectionResultPages(this.state.testData);
    }
    

 
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
              <div style={{ width: '12rem'}}></div>
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

  render() {
 
    return (
      <div style={{margin: '40px'}}>
		  <h1 style={{color: 'white', textAlign: 'center'}}>We think you'll love these</h1>
      	{this.state.pages[this.state.currPageIndex]}

      	<div style={{margin: '40px'}}/>
      </div>
    );
  }
}

export default ShoeRecommender;