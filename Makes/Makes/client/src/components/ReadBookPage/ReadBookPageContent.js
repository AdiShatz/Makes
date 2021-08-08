import React, {useState} from "react";
import BookPage from "../Books/BookPage";
import Button from "../UI/Button";

import './ReadBookPageContent.css';

let turningPointValue = 'left';

const ReadBookPageContent = (props) => {

    const [pageId, setPageId] = useState("p1"); 

    const currentPageIndex = props.pages.findIndex(
        (page) => page.id === pageId
      );

    const currPage = props.pages[currentPageIndex];
    const isFirstPage = currPage.pageNum === '1' ? true : false;
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
        <div style={{padding: "100px 0 0 0"}}>
            <BookPage data={currPage} onTurningPointChosen={chosenTurningPointHandler}/>
            {!isLastPage && <button onClick={nextPageHandler}>הבא</button>}
            {!isFirstPage && <button onClick={prevPageHandler}>הקודם</button>}

        </div>
    );
}

export default ReadBookPageContent;