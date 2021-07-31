import React, {useState} from "react";
import BooksList from "../Books/BooksList";

import './MainPageContent.css';

const MainPageContent = (props) => {

    return (
        <Fragment>
           <BooksList items={props.items} onBookItemClicked={props.onBookItemClicked} />
           {props.children}
        </Fragment>
    );



}
export default MainPageContent;