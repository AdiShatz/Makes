import React from "react";
import Card from '../UI/Card';

import './BookItem.css'

const BookItem = (props) => {
  
    const ClickedHandler = () => {
      console.log(props.isGalleryItem)
      if(props.isGalleryItem === 'false'){
        props.onBookItemClicked(props);
      }
      else{
        console.log("GALLERY?!!?!?!?!?!");

      }
      };

      
    return(

    <Card className='book-item'>

        <img 
        src={require("../../images/"+ props.coverPhoto).default}  
        alt= "Photo Unavailable"
        className='book-item__img' 
        onClick={ClickedHandler}/>

        <label className='book-item__name'>{props.name}</label>
        {props.isGalleryItem==='true' && <button>מחק</button> }       
    </Card>
  
  );
}

export default BookItem;
