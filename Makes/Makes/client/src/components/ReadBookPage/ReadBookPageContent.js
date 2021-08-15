import React, {useEffect, useState} from "react";
import BookPage from "../Books/BookPage";
import Button from "../UI/Button";

import './ReadBookPageContent.css';

let turningPointValue = 'left';

const ReadBookPageContent = (props) => {

     const [pageId, setPageId] = useState(); 
    const [currPage, setCurrPage] = useState(null); 

    // const currentPageIndex;
    //  = props.bookPages.findIndex(
    //     (page) => page.id === pageId
    //   );

    useEffect(
        () => {
            console.log("use effect READBOOKPAGE");
            console.log(props.bookPages);

            setCurrPage(props.bookPages[0]);
            

            // console.log(currPage);

            // setPageId(currPage.id);

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
            setPageId(currPage.nextPageId[1]);
            setCurrPage(props.bookPages[props.bookPages.findIndex(
                    (page) => page.id === currPage.nextPageId[1])]
            );
            
        }
        else{
            setPageId(currPage.nextPageId[0]);
            setCurrPage(props.bookPages[props.bookPages.findIndex(
                (page) => page.id === currPage.nextPageId[0])]
                );
        }
    }

    const prevPageHandler = (event) =>{
        
            setPageId(currPage.prevPageId);
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