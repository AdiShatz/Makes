import React from "react";
import './Header.css'

const Header = (props) => {

return(

<header className="header">
    {props.children}
    <img src={require("../../images/Makes-logos.jpeg").default}></img>
</header>
);
}

export default Header;
