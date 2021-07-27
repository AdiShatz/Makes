import React from "react";
import './Header.css'

const Header = (props) => {

return(

<header className="header">
    <h1><b>מייקס</b></h1>
    {props.children}
</header>
);
}

export default Header;
