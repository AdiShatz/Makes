import React, {useState} from "react";
import BooksList from "../Books/BooksList";

import './MainPageContent.css';

const MainPageContent = (props) => {

    return (
        <div>
           <BooksList items={props.items} onBookItemClicked={props.onBookItemClicked} />
           {props.children}
        </div>
    );



}
export default MainPageContent;