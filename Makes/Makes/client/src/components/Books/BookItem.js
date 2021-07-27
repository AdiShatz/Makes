import React from "react";
import Card from '../UI/Card';

import ph2 from "../../images/photo2.jpg"

import './BookItem.css'

const BookItem = (props) => {
  
    const ClickedHandler = () => {
    props.onBookItemClicked(props);

    console.log(props.coverPhoto);

      };
      
      // var tst= require(props.coverPhoto).default;

    return(

    <Card className='book-item'>

        <img 
        src={require("../../images/photo2.jpg").default}  
        alt= "Photo Unavailable"
        className='book-item__img' 
        onClick={ClickedHandler}/>

        <label className='book-item__name'>{props.name}</label>
    </Card>
  
  );
}

export default BookItem;
