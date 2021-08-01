import React from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const pageData= props.data;
    const img = pageData.img;

    return(
    <React.Fragment >
        <div className="book-page">
          <img src={require("../../images/KipaAduma.jfif").default}/>
        </div>

        <div className="book-page">
        <p>{pageData.text}</p>
        {pageData.turningPointExist && <TurningPoint data={pageData.turningPointData} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>
    </React.Fragment>
  );
}

export default BookPage;
