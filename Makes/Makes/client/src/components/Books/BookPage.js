import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'
import RecordView from '../UI/RecordView'

import './BookPage.css'

const BookPage = (props) => {
    
    const [isRecording, setIsRecording] = useState(false);
    const [isRecordingExist, setIsRecordingExist] = useState(false);
    const [pageData, setPageData] = useState(null);
    const [img, setImg] = useState(null);

    useEffect(
        () => {
            setPageData(props.data);
        },[props]
    )

    return(

    <div className="main-read-book-container">
      
      
          <div className="book-page-container-left">
              <img src={require("../../images/KipaAduma.jfif").default}/>
          </div>

          <div className="book-page-container-right">
              {pageData!=null && <p>{pageData.text}</p>}
              {pageData!=null && pageData.turningPointExist && <TurningPoint data={pageData.turningPointData} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>
      </div>
   
  );
}

export default BookPage;
