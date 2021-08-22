import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const [pageData, setPageData] = useState(null);

    useEffect(
        () => {
            setPageData(props.data);
        },[props]
    )

    return(
        <div>

    <div className="main-read-book-container">
      
      
          <div className="book-page-container-left">
          {pageData && <img src={require("../../images/"+pageData.background).default}/> }
          </div>

          <div className="book-page-container-right">
              {pageData && <p>{pageData.text}</p>}
              {pageData && pageData.turningPointExist && <TurningPoint data={pageData.turningPoint} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>

      </div>
    {pageData && pageData.pageNum && <label style={{paddingLeft:"50%"}}>{pageData.pageNum}</label>}
    </div>
   
  );
}

export default BookPage;
