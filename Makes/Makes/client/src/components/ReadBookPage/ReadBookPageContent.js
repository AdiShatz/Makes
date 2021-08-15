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
        setFirstLastPages();
        setFirstLastPages();
        console.log("next---------");
        console.log("isFirst:");
        console.log(isFirstPage);
        console.log("isLast:");
        console.log(isLastPage);
    }

    const prevPageHandler = (event) =>{
        setCurrPage(props.bookPages[props.bookPages.findIndex(
            (page) => page.id === currPage.prevPageId)]
        );
        setFirstLastPages();
        setFirstLastPages();
        console.log("Prev---------");
        console.log("isFirst:");
        console.log(isFirstPage);
        console.log("isLast:");
        console.log(isLastPage);
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