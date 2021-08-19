import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const [pageData, setPageData] = useState(null);

    useEffect(
        () => {
            if(props.data){
                console.log("bookPage props.data:");
                console.log(props.data);
            setPageData(props.data);
            }
        },[props]
    )

    return(

    <div className="main-read-book-container">
      
      
          <div className="book-page-container-left">
              <img src={require("../../images/KipaAduma.jfif").default}/>
          </div>

          <div className="book-page-container-right">
              {pageData && <p>{pageData.text}</p>}
              {pageData && pageData.turningPointExist && <TurningPoint data={pageData.turningPoint} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>
      </div>
   
  );
}

export default BookPage;
