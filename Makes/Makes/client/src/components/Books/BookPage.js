import React, {useState, useEffect, useRef} from 'react';
import TurningPoint from '../ReadBookPage/TurningPoint'

import './BookPage.css'

const BookPage = (props) => {
    
    const [text, setText] = useState(null);
    const [pageNum, setPageNum] = useState(null);
    const [pageId, setPageId] = useState(null);
    const [background, setBackground] = useState(null);
    const [turningPointExist, setTurningPointExist] = useState(null);
    const [turningPoint, setTurningPoint] = useState(null);

    const [newText, setNewText] = useState(null);
    const chosenBookTextInputRef = useRef(null);


    useEffect(
        () => {
            setText(props.text);
            setPageId(props.pageId);
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

      setNewText(chosenBookTextInputRef.current.value);
      
      let url = "http://localhost:8080/customBooks/editBook/" + localStorage.getItem("bookId");
        fetch(url,
        {
            method: 'PUT',
            body: JSON.stringify({
                text: chosenBookTextInputRef.current.value,
                pageId: pageId,
            }),
            headers: {
                'Content-Type': 'application/json',
            }
         })
        .then(response => {
            if(response.ok){
              console.log("200 OK");
                return response.json();
            }
            else{
                return response.json().then((data)=>
                {
                    let errorMessage ="אירעה שגיאה בפנייה לשרת";
                     if(data && data.error && data.error.message){ 
                     errorMessage = data.error.message; 
                     }
                     throw new Error(errorMessage);
                });
            }
        }).then((data) => { 
          props.onUpdateBook(data.pages, pageId);
        })
        .catch((err)=>{
            alert(err.message);
        });
          }

    return(
        <div>

    <div className="main-read-book-container">
      
      
          <div className="book-page-container-left">
          {background && <img src={require("../../images/"+background).default}/> }
          </div>

          <div className="book-page-container-right">
              {!props.isEditMode  && text && <p>{text}</p>}

              {props.isEditMode  && <textarea id="textarea" dir = "rtl" name="textarea" rows="20" cols="100" required ref={chosenBookTextInputRef}>
              {text}
              </textarea>}

              {turningPointExist && <TurningPoint data={turningPoint} onTurningPointChosen={props.onTurningPointChosen}/>}
              <br/>
             {!props.isEditMode && <button className="edit-save-buttons" onClick={handleEdit}>ערוך</button>}
             {props.isEditMode && <button  className="edit-save-buttons" onClick={handleSave}>שמור</button>}
        </div>

      </div>
    {pageNum && <label style={{paddingLeft:"50%"}}>{pageNum}</label>}
    </div>
   
  );
}

export default BookPage;
