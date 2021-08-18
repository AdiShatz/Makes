import React, {useEffect, useState} from "react";
import BookPage from "../Books/BookPage";

import './ReadBookPageContent.css';

let turningPointValue = 'left';
var isFirstPage = true;
var isLastPage = false;

const ReadBookPageContent = (props) => {

    const [currPage, setCurrPage] = useState(null);

    useEffect(
        () => {

            setCurrPage(props.bookPages[0]);
            console.log("cuur page:");
            console.log(currPage);

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
       
    }

    const prevPageHandler = (event) =>{
        if(currPage.prevPageId != null){
            setCurrPage(props.bookPages[props.bookPages.findIndex(
                (page) => page.id === currPage.prevPageId)]
            );
        }
    }

    return (
        <React.Fragment>
             <BookPage data={currPage} onTurningPointChosen={chosenTurningPointHandler}/> 
            {currPage && currPage.nextPageId[0] && <button onClick={nextPageHandler}>הבא</button>}
            {currPage && currPage.prevPageId && <button onClick={prevPageHandler}>הקודם</button>}

        </React.Fragment>
    );
}

export default ReadBookPageContent;