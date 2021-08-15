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

        },[props,isFirstPage,isLastPage]
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
        // if(currPage.prevPageId === null){
            
        //     setIsFirstPage(true);
        // }else{
        //     console.log("first false");
        //     setIsFirstPage(false);
        // }
        
        // if(currPage.nextPageId[0] === null){
        //     setIsLastPage(true);
        // }
        // else{
        //     setIsLastPage(false);
        // }
    }
    

    //  const currPage = ;
    // console.log(currPage);
  
   
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
            {<button onClick={nextPageHandler}>הבא</button>}
            {<button onClick={prevPageHandler}>הקודם</button>}

        </React.Fragment>
    );
}

export default ReadBookPageContent;