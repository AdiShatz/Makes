import React from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const pageData= props.data;
    const img = pageData.img;

    return(
    <div className="main-read-book-container">
        <div className="book-page-container-left">
          <img src={require("../../images/KipaAduma.jfif").default}/>
        </div>

        <div className="book-page-container-right">
        <p>{pageData.text}</p>
        {pageData.turningPointExist && <TurningPoint data={pageData.turningPointData} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>
    </div>
  );
}

export default BookPage;
