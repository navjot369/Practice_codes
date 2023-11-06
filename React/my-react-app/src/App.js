import logo from './images/logo_sample.png';
import './App.css';
import shoppingLogo from './images/shopping-cart-logo.svg';
import mailLogo from './images/mail-logo.svg';

function App() {
  return (
    <div className = "container" >
      <Navbar />
      <Container1 />
    </div>
  );
}

function Navbar() {
  return (
    <div className = "navbar">
      <div className = "logo-container">
        <img src = {logo} />
      </div>
      <div className = "top-links-container">
        <a href="#">Home</a>
        <a href="#">Shop</a>
        <a href="#">Blog</a>
        <a href="#">About</a>
      </div>
      <div className = "search-container">
      <input type="text" placeholder="Search" name="searchQuery" />
      <a href=""><img src = {shoppingLogo} /></a>
      <a href=""><img src= {mailLogo} /></a>
      </div>
    </div>
  );
}

function Container1() {
  return (
    <div className = "outerContainer1">
      <GridContainer1 rs={1} re={3} cs={1} ce={2}/>
      <GridContainer1 rs={1} re={2} cs={2} ce={4}/>
      <GridContainer1 rs={2} re={3} cs={2} ce={3}/>
      <GridContainer1 rs={2} re={3} cs={3} ce={4}/>
    </div>
  );
}

function GridContainer1(props) {
    let rowStart = props.rs;
    let rowEnd = props.re;
    let colStart = props.cs;
    let colEnd = props.ce;
    let myStyles = {
      gridRowStart: rowStart,
      gridRowEnd: rowEnd,
      gridColumnStart: colStart,
      gridColumnEnd: colEnd
    };
    return (
    <div className = "innerCont1" style={myStyles}>
      <span className = "span1">X items</span>
      <h1 className="innerHeading">Item {props.num}</h1>
      <span className = "span2">Read More</span>
    </div>
  );
}

export default App;
