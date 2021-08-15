import React, {useEffect, useState} from "react";
import BookPage from "../Books/BookPage";
import Button from "../UI/Button";

import './ReadBookPageContent.css';

let turningPointValue = 'left';

const ReadBookPageContent = (props) => {

    const [currPage, setCurrPage] = useState(null);
    const [isFirstPage, setIsFirstPage] = useState(null);
    const [isLastPage, setIsLastPage] = useState(null);


    // const currentPageIndex;
    //  = props.bookPages.findIndex(
    //     (page) => page.id === pageId
    //   );

    useEffect(
        () => {

            setCurrPage(props.bookPages[0]);
            setIsFirstPage(true);
            setIsLastPage(false);


        },[props]
    )

    

    //  const currPage = ;
    // console.log(currPage);
    // const isFirstPage = currPage.prevPageId === null ? true : false;
    //  const isLastPage = currPage.nextPageId[0] === null ? true : false;
    const isFirstPage = true;
     const isLastPage = false;

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
    }

    const prevPageHandler = (event) =>{
            setCurrPage(props.bookPages[props.bookPages.findIndex(
                (page) => page.id === currPage.prevPageId)]
                );
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