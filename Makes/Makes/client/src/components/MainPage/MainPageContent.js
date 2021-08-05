import React, {useState} from "react";
import BooksList from "../Books/BooksList";

import './MainPageContent.css';

const MainPageContent = (props) => {

    return (
        <React.Fragment>
           <BooksList items={props.items} 
           isGalleryItem={'false'} 
           onBookItemClicked={props.onBookItemClicked} />
           {props.children}
        </React.Fragment>
    );
}
export default MainPageContent;