import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const [pageData, setPageData] = useState(null);
    const [pageText, setPageText] = useState(null);
    const [isEditMode, setIsEditMode] = useState(false);
    const [isEdited, setIsEdited] = useState(false);

    const chosenBookTextInputRef = useRef(null);


    useEffect(
        () => {
            setPageData(props.data);
        },[props]
    )

    const handleEdit = () =>{
      setIsEditMode(true);
      
    }

    const handleSave = () =>{
      setIsEditMode(false);
      setIsEdited(true);
      setPageText(chosenBookTextInputRef.current.value);
          }

    return(
        <div>

    <div className="main-read-book-container">
      
      
          <div className="book-page-container-left">
          {pageData && <img src={require("../../images/"+pageData.background).default}/> }
          </div>

          <div className="book-page-container-right">
              {!isEditMode && !isEdited && pageData && <p>{pageData.text}</p>}

              {isEditMode && !isEdited && <textarea id="textarea" dir = "rtl" name="textarea" rows="20" cols="100" required ref={chosenBookTextInputRef}>
              {pageData.text}
              </textarea>}

              {isEdited && <p>{pageText}</p>}
              {pageData && pageData.turningPointExist && <TurningPoint data={pageData.turningPoint} onTurningPointChosen={props.onTurningPointChosen}/>}
              <br/>
             {!isEditMode && <button onClick={handleEdit}>ערוך</button>}
             {isEditMode && <button onClick={handleSave}>שמור</button>}
        </div>

      </div>
    {pageData && pageData.pageNum && <label style={{paddingLeft:"50%"}}>{pageData.pageNum}</label>}
    </div>
   
  );
}

export default BookPage;
