import React from "react";
import Card from '../UI/Card';

import './BookItem.css'

const BookItem = (props) => {
  
    const ClickedHandler = () => {
      if(props.isGalleryItem === 'false'){
        props.onBookItemClicked();
      }
      else{
        props.onGalleryBookItemClicked();
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
