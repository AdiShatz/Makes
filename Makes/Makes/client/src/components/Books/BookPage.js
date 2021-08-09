import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'
import ReactMediaRecorder from '../UI/ReactMediaRecorder'

import './BookPage.css'

const BookPage = (props) => {
    
    const [isRecording, setIsRecording] = useState(false);
    const [isRecordingExist, setIsRecordingExist] = useState(false);

    const pageData= props.data;
    const img = pageData.img;


    // const recordingHandler = () => {
    //   let device = navigator.mediaDevices.getUserMedia({audio: true});
    //   let items=[];
    //   let recorder;
    //   device.then(stream => {
    //     recorder = new MediaRecorder(stream);
    //     recorder.onDataAvailable = event =>{
    //       items.push(event.data);
    //       if(recorder.state === 'inactive'){
    //           let blob = new Blob(items, {type : 'audio/webm'});
    //           document.getElementById('audio').innerHTML = '<source src="'+ URL.createObjectURL(blob)+'" type="video.webm"/>';
    //       }
    //     }
    //     recorder.start(1000);
    //   });

    //   setTimeout(()=>{
    //         recorder.stop();
    //     }, 4000);
    // }

    const recordButtonHandler = () => {
      setIsRecording(!isRecording);
      setIsRecordingExist(true);
    }

    return(

    <div className="main-read-book-container">
          <div className="book-page-container-left">
          <button onClick={recordButtonHandler}> {isRecording ? 'עצור' : 'הקלט'}</button>
          <img src={require("../../images/KipaAduma.jfif").default}/>
          <ReactMediaRecorder
        video
        render={({ previewStream }) => {
          return <VideoPreview stream={previewStream} />;
        }}
      />
        </div>

        <div className="book-page-container-right">
        <p>{pageData.text}</p>
        {pageData.turningPointExist && <TurningPoint data={pageData.turningPointData} onTurningPointChosen={props.onTurningPointChosen}/>}
        </div>
    </div>
  );
}

export default BookPage;
