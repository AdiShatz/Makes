import React, {useEffect} from "react";
import BooksList from "../Books/BooksList";

import './GalleryPageContent.css';

const GalleryPageContent = (props) => {

    useEffect(
        () => {},[props]
    );

    return (
        <React.Fragment>
           <BooksList items = {props.items} 
           isGalleryItem={'true'}
           onGalleryBookItemClicked = {props.onGalleryBookItemClicked} 
           onGalleryItemDeletion={props.onGalleryItemDeletion}/>
           {props.children}
        </React.Fragment>
    );
}
export default GalleryPageContent;