import React, {useEffect, useState} from "react";
import BookPage from "../Books/BookPage";
import Button from "../UI/Button";

import './ReadBookPageContent.css';

let turningPointValue = 'left';
var isFirstPage = true;
var isLastPage = false;

const ReadBookPageContent = (props) => {

    const [currPage, setCurrPage] = useState(null);
    // const [isFirstPage, setIsFirstPage] = useState(true);
    // const [isLastPage, setIsLastPage] = useState(false);

    useEffect(
        () => {

            setCurrPage(props.bookPages[0]);

        },[props]
    )

    const setFirstLastPages = () => {
        if(currPage.prevPageId === null){
            
            isFirstPage = true;
        }else{
            console.log("first false");
            isFirstPage = false;
        }
        
        if(currPage.nextPageId[0] === null){
            isLastPage = true;
        }
        else{
           isLastPage = false;
        }
    }
    

  
   
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
            {currPage && currPage.prevPageId === null && <button onClick={nextPageHandler}>הבא</button>}
            {currPage && currPage.nextPageId[0] === null && <button onClick={prevPageHandler}>הקודם</button>}

        </React.Fragment>
    );
}

export default ReadBookPageContent;