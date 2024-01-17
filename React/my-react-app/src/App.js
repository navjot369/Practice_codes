import logo from './images/logo_sample.png';
import './App.css';
import shoppingLogo from './images/shopping-cart-logo.svg';
import mailLogo from './images/mail-logo.svg';
import logoCheck from './images/logo_check.png';
import instaIcon from './images/instagram.png';
import FaceIcon from './images/facebook.png';
import Test from './Test';

function App() {
  return (
    <div className = "container" >
      <Navbar />
      <Container1 />
      <Container2 />
      <Footer />
      <Test />
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
      <GridContainer1 rs={1} re={3} cs={1} ce={2} num={1}/>
      <GridContainer1 rs={1} re={2} cs={2} ce={4} num={2}/>
      <GridContainer1 rs={2} re={3} cs={2} ce={3} num={3}/>
      <GridContainer1 rs={2} re={3} cs={3} ce={4} num={4}/>
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

function Container2() {
  return (
    <div className = "container2">
      <Innercont2 num = {1} />
      <Innercont2 num = {2} />
      <Innercont2 num = {3} />
    </div>
  );
}

function Innercont2(props) {
  let myStyle;
  if(props.num == 1) {
    myStyle = {alignItems: "flex-start"};
  }else if(props.num == 2) {
    myStyle = {alignItems: "center"};
  }else if(props.num == 3){
    myStyle = {alignItems: "flex-end"};
  }
  return (
    <div className = "inner2" style={myStyle}>
      <span className="i2span i2span1">Category {props.num}</span>
      <span className="i2span i2span2">Category {props.num}</span>
    </div>
  );
}
function Footer() {
  return(<div className = "footer-outer">
    <div className="footerUpper">
      <div className="footercont1">
        <img src={logoCheck} />
      </div>
      <div className="footercont2">
        <span className="headfooter">Shop</span>
        <FooterList />
      </div>
      <div className="footercont3">
        <span className="headfooter">Company</span>
        <FooterList />
      </div>
      <div className="footercont4">
        <span className="formTitle">Get the latest news &amp; offers</span>
        <form onsubmit="#" className="form1">
          <input type="email" placeholder="Email Address*"/>
          <button type="submit">Subscribe</button>
        </form>
        <span><a href="#" className="socialLink">Join Us</a><a href="#" className="socialLink">Get Social</a></span>
        <span><a href="#"></a><img src={FaceIcon} className="icon-social"/>
        <a href="#"><img src={instaIcon} className="icon-social"/></a></span>
      </div>
    </div>
    <div className="footerLower">
      <span>Powered By Global Re-Tech</span>
      <span>@2024 Global Re-Tech, All Rights Reserved</span>
    </div>
  </div>);
}
function FooterList() {
  let text = "Category 1";
  let arr = [];
  for(let i = 0; i < 5; i++) {
    arr.push(<li>{text}</li>);
  }
  return (<ul className="list-footer">{arr}</ul>);
}
export default App;
