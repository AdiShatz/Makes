import React, {useState} from "react";
import BookPage from "../Books/BookPage";
import Button from "../UI/Button";

import './ReadBookPageContent.css';

let turningPointValue = 'left';

const ReadBookPageContent = (props) => {

    const [pageId, setPageId] = useState(); 

    const currentPageIndex = props.bookPages.findIndex(
        (page) => page.id === pageId
      );

    const currPage = props.bookPages[currentPageIndex];
    console.log(currPage);
    const isFirstPage = currPage.prevPageId === null ? true : false;
    const isLastPage = currPage.nextPageId[0] === null ? true : false;

    const chosenTurningPointHandler = (value) => {
        turningPointValue = value;
    }

    const nextPageHandler = (event) =>{
        if(currPage.turningPointExist && turningPointValue==='right'){
            setPageId(currPage.nextPageId[1]);
        }
        else{
            setPageId(currPage.nextPageId[0]);
        }
    }

    const prevPageHandler = (event) =>{
        
            setPageId(currPage.prevPageId);
    }

    return (
        <React.Fragment>
            <BookPage data={currPage} onTurningPointChosen={chosenTurningPointHandler}/>
            {!isLastPage && <button onClick={nextPageHandler}>הבא</button>}
            {!isFirstPage && <button onClick={prevPageHandler}>הקודם</button>}
            <button onClick={prevPageHandler}>הקודם</button>

        </React.Fragment>
    );
}

export default ReadBookPageContent;