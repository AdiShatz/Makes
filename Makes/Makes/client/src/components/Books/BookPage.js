import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const [text, setText] = useState(null);
    const [pageNum, setPageNum] = useState(null);
    const [background, setBackground] = useState(null);
    const [turningPointExist, setTurningPointExist] = useState(null);
    const [turningPoint, setTurningPoint] = useState(null);

    const [newText, setNewText] = useState(null);
    // const [isEditMode, setIsEditMode] = useState(false);
    // const [isEdited, setIsEdited] = useState(false);

    const chosenBookTextInputRef = useRef(null);


    useEffect(
        () => {
            setText(props.text);
            setPageNum(props.pageNum)
            setTurningPointExist(props.turningPointExist)
            setTurningPoint(props.turningPoint)
            setBackground(props.background)
        },[props]
    )

    const handleEdit = () =>{
      props.setIsEditMode(true);
    }

    const handleSave = () =>{
      props.setIsEditMode(false);
      props.setIsEdited(true);

      setNewText(chosenBookTextInputRef.current.value);

      // Sent http put request
          }

    return(
        <div>

    <div className="main-read-book-container">
      
      
          <div className="book-page-container-left">
          {background && <img src={require("../../images/"+background).default}/> }
          </div>

          <div className="book-page-container-right">
              {!props.isEditMode && !props.isEdited && text && <p>{text}</p>}

              {props.isEditMode && !props.isEdited && <textarea id="textarea" dir = "rtl" name="textarea" rows="20" cols="100" required ref={chosenBookTextInputRef}>
              {text}
              </textarea>}

              {props.isEdited && <p>{newText}</p>}

              {turningPointExist && <TurningPoint data={turningPoint} onTurningPointChosen={props.onTurningPointChosen}/>}
              <br/>
             {!props.isEditMode && <button onClick={handleEdit}>ערוך</button>}
             {props.isEditMode && <button onClick={handleSave}>שמור</button>}
        </div>

      </div>
    {pageNum && <label style={{paddingLeft:"50%"}}>{pageNum}</label>}
    </div>
   
  );
}

export default BookPage;
