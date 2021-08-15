import React, {useEffect, useState} from "react";
import BookPage from "../Books/BookPage";
import Button from "../UI/Button";

import './ReadBookPageContent.css';

let turningPointValue = 'left';

const ReadBookPageContent = (props) => {

    const [currPage, setCurrPage] = useState({}); 
    const [pageId, setPageId] = useState("");
    const [isFirstPage, setIsFirstPage] = useState(true);
    const [isLastPage, setIsLastPage] = useState(false);


    useEffect(
        () => {
            console.log("props.bookPages");
            console.log(props.bookPages);
            setCurrPage(props.bookPages);
            console.log(currPage);
            setPageId(pageId);
            console.log(pageId);

     console.log("currPage");
     console.log(currPage);

     setIsFirstPage(currPage.pageNum === '1' ? true : false);
     setIsLastPage(currPage.nextPageId[0] === null ? true : false);
    }
    ,[props])


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
            {/* <BookPage data={currPage} onTurningPointChosen={chosenTurningPointHandler}/> */}
            {!isLastPage && <button onClick={nextPageHandler}>הבא</button>}
            {!isFirstPage && <button onClick={prevPageHandler}>הקודם</button>}
            <button onClick={prevPageHandler}>הקודם</button>

        </React.Fragment>
    );
}

export default ReadBookPageContent;