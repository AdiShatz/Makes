import React, {useState} from "react";
import Questionnaire from "./Questionnaire"
import BookCoverPhoto from "./BookCoverPhoto"
import Button from "../UI/Button";
import './CreateBookPageContent.css';

const CreateBookPageContent = (props) => {

    return (
        <React.Fragment>
        <div id="top-Padding">
                <div style={{textAlign: "center"}}><label>מלא את השאלון והסיפור שלך תיכף יהיה מוכן</label></div>
                <div className="create-book-page-container">
                    <div className="right-container"><p>הרבה הרבה הסברים על השאלון והסיפור</p></div> 
                    <div className="left-container"><Questionnaire questions={props.questions} onCreateBook={props.onCreateBook}/> </div>
                </div>
                <div id="create-book-button"><Button> צור ספר </Button></div>
                
        </div>
        </React.Fragment>
    );



}
export default CreateBookPageContent;