import React, {useState} from "react";
import Header from "../UI/Header";
import CreateBookPageContent from "./ReadBookPageContent";
import Footer from "../UI/Footer";
import BackButton from "../UI/BackButton";

const DUMMY_BOOKS = [
    {
      id: 'q1',
      type: 'text',
      label: 'שם הילד',
      options: ['גבי','לילך','עדי','ניר'] 
    },
    { 
        id: 'q2',
        type: 'combo',
        label: 'בסיפור נבקר את',
        options: ['סבתא','סבא','דודה','אמא'] 
    },
    { 
        id: 'q3',
        type: 'combo',
        label: 'דרך איפה נלך',
        options: ['יער','חוף הים','פארק','מערה'] 
    },
    { 
        id: 'q4',
        type: 'combo',
        label: 'חיה מרושעת',
        options: ['אריה','נחש','נמר','זאב'] 
    }
  ];


const ReadBookPage = (props) => {        

    return (
        <React.Fragment>
            <Header >
                <label>קריאת ספר</label>
                
            </Header>
            <ReadBookPageContent questions={questions}/>
            <Footer>
                <BackButton onBackButtonClicked={props.onBackButtonClicked}/>
            </Footer>
        </React.Fragment>
    );
}
export default ReadBookPage;