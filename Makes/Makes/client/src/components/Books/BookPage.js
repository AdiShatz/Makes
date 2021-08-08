import React, {useState} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const [isRecording, setIsRecording] = useState(false);
    const [isRecordingExist, setIsRecordingExist] = useState(false);

    const pageData= props.data;
    const img = pageData.img;

    const recordButtonHandler = () => {
      setIsRecording(!isRecording);
      setIsRecordingExist(true);
    }

    return(
    <React.Fragment >
        <div className="book-page">
          <button onClick={recordButtonHandler}> {isRecording ? 'עצור' : 'הקלט'}</button>
          <img src={require("../../images/KipaAduma.jfif").default}/>
        </div>

        <div className="book-page">
        <p>{pageData.text}</p>
        {isRecordingExist && <audio controls></audio>}
        {pageData.turningPointExist && <TurningPoint data={pageData.turningPointData} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>
    </React.Fragment>
  );
}

export default BookPage;
