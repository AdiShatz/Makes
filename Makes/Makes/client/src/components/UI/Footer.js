import React from "react";
import './Footer.css'

const date = new Date();
const year = date.getFullYear();

const Footer = (props) =>{
   return( 
       <footer className="footer">
   <p> © Makes {year}</p>
          {props.children}
   </footer>
   );
}
export default Footer;