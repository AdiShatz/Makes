import React, {useState} from "react";
import BooksList from "../Books/BooksList";

import './GalleryPageContent.css';

const GalleryPageContent = (props) => {

    return (
        <React.Fragment>
           <BooksList items={props.items} />
           {props.children}
        </React.Fragment>
    );



}
export default GalleryPageContent;