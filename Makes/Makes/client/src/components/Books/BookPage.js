import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const [isRecording, setIsRecording] = useState(false);
    const [isRecordingExist, setIsRecordingExist] = useState(false);
    const [pageData, setPageData] = useState(null);
    const [pageText, setPageText] = useState();
    const [img, setImg] = useState(null);

    useEffect(
        () => {
            if(props.data){
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
              {pageData && pageData.turningPointExist && <TurningPoint data={pageData.turningPointData} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>
      </div>
   
  );
}

export default BookPage;
