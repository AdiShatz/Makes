import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'
import RecordView from '../UI/RecordView'

import './BookPage.css'

const BookPage = (props) => {
    
    const [isRecording, setIsRecording] = useState(false);
    const [isRecordingExist, setIsRecordingExist] = useState(false);

    const pageData= props.data;
    const img = pageData.img;

    return(

    <div className="main-read-book-container">
          <div className="book-page-container-left">
          <img src={require("../../images/KipaAduma.jfif").default}/>
         <RecordView/>
        </div>

        <div className="book-page-container-right">
        <p>{pageData.text}</p>
        {pageData.turningPointExist && <TurningPoint data={pageData.turningPointData} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>
    </div>
  );
}

export default BookPage;
