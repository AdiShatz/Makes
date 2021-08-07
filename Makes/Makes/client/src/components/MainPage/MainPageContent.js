import React, {useState} from "react";
import BooksList from "../Books/BooksList";

import './MainPageContent.css';

const MainPageContent = (props) => {

    return (
        <div class="main-container">
           <BooksList items={props.items} 
           isGalleryItem={'false'} 
           onBookItemClicked={props.onBookItemClicked} 
           onNotLoggedIn={props.onNotLoggedIn}/>
           {props.children}
        </div>
    );
}
export default MainPageContent;