import './heroSection.css';

export default function HeroSection() {
    return(<div className="hero-container">
        <Navbar />
    </div>);
}

function Navbar() {
    return(
        <div className="navbar-container">
            <div className="logo-container">
                Logo
            </div>
            <div className="menu-container">
                <a href="/" className="menu-links">Home</a>
                <a href="/" className="menu-links">About</a>
                <a href="/" className="menu-links">Our Speakers</a>
            </div>
        </div>
    );
}