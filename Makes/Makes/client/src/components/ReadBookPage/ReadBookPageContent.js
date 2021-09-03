import React, {useEffect, useState} from "react";
import BookPage from "../Books/BookPage";

import './ReadBookPageContent.css';

let turningPointValue = 'left';

const ReadBookPageContent = (props) => {

    const [currPage, setCurrPage] = useState(null);

    const [isEditMode, setIsEditMode] = useState(false);
    const [isEdited, setIsEdited] = useState(false);

    useEffect(
        () => {
            setCurrPage(props.bookPages[0]);
        },[props]
    )
   
    const chosenTurningPointHandler = (value) => {
        turningPointValue = value;
    }

    const nextPageHandler = (event) =>{

        if(currPage.nextPageId[0] != null){
            if(currPage.turningPointExist && turningPointValue==='right'){
                setCurrPage(props.bookPages[props.bookPages.findIndex(
                        (page) => page.id === currPage.nextPageId[1])]
                );
                
            }
            else{
                setCurrPage(props.bookPages[props.bookPages.findIndex(
                    (page) => page.id === currPage.nextPageId[0])]
                    );
            }
        }
        setIsEditMode(false);
        setIsEdited(false);
    }

    const prevPageHandler = (event) =>{
        if(currPage.prevPageId != null){
            setCurrPage(props.bookPages[props.bookPages.findIndex(
                (page) => page.id === currPage.prevPageId)]
            );
        }
        setIsEditMode(false);
        setIsEdited(false);
    }

    return (
        <React.Fragment>
             {currPage && <BookPage text={currPage.text}
              pageNum={currPage.pageNum}
              background={currPage.background}
              turningPointExist={currPage.turningPointExist}
              turningPoint={currPage.turningPoint}
                onTurningPointChosen={chosenTurningPointHandler}
                setIsEditMode={setIsEditMode}
                isEditMode={isEditMode}
                setIsEdited={setIsEdited}
                isEdited={isEdited}/> 
                }
            {currPage && currPage.nextPageId[0] && <button className="continue-button next-button" onClick={nextPageHandler}>הבא</button>}
            {currPage && currPage.prevPageId && <button className="continue-button" onClick={prevPageHandler}>הקודם</button>}
        </React.Fragment>
    );
}

export default ReadBookPageContent;